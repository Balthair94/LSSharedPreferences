package baltamon.mx.lssharedpreferences.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import baltamon.mx.lssharedpreferences.MainActivity;
import baltamon.mx.lssharedpreferences.R;
import baltamon.mx.lssharedpreferences.persistence.UserSession;
import baltamon.mx.lssharedpreferences.viewholders.RegisterViewHolder;

/**
 * Created by Baltazar Rodriguez on 21/03/2017.
 */

public class RegisterActivity extends AppCompatActivity {

    private RegisterViewHolder holder;
    private UserSession userSession;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setUpToolbar();
        holder = new RegisterViewHolder(this.findViewById(android.R.id.content));
        setUpButtonRegister();
    }

    private void setUpButtonRegister() {
        Button btnRegister = (Button) findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //CREATING AND SAVING THE USER DATA
                userSession = new UserSession(getApplicationContext());
                userSession.setUserName(holder.getmUserName().getText().toString());
                userSession.setUserEmail(holder.getmUserEmail().getText().toString());
                userSession.setUserPhone(holder.getmUserPhone().getText().toString());

                //START NEW ACTIVITY
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
    }

    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("User Register");
        }
    }
}
