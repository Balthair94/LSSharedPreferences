package baltamon.mx.lssharedpreferences;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

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
    }

    private void showUserData() {

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
