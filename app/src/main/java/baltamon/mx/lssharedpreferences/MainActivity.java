package baltamon.mx.lssharedpreferences;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import baltamon.mx.lssharedpreferences.activities.RegisterActivity;
import baltamon.mx.lssharedpreferences.persistence.UserSession;
import baltamon.mx.lssharedpreferences.viewholders.RegisterViewHolder;

public class MainActivity extends AppCompatActivity {

    private UserSession userSession;
    private RegisterViewHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();
        userSession = new UserSession(getApplicationContext());
        holder = new RegisterViewHolder(this.findViewById(android.R.id.content));
        showUserData();
        setUpButtons();
    }

    private void setUpButtons() {
        Button btnUpdate = (Button) findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUserData();
            }
        });

        Button btnLogut = (Button) findViewById(R.id.btn_logout);
        btnLogut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSession.logout();
                Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                finish();
            }
        });
    }

    private void updateUserData(){
        userSession.setUserName(holder.getmUserName().getText().toString());
        userSession.setUserEmail(holder.getmUserEmail().getText().toString());
        userSession.setUserPhone(holder.getmUserPhone().getText().toString());
        Toast.makeText(this, "Data updated", Toast.LENGTH_SHORT).show();
    }

    private void showUserData() {
        holder.getmUserName().setText(userSession.getUserName());
        holder.getmUserEmail().setText(userSession.getUserEmail());
        holder.getmUserPhone().setText(userSession.getUserPhone());
    }

    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("Welcome User");
        }
    }
}
