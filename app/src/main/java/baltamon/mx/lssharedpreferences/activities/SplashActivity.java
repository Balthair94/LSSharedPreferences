package baltamon.mx.lssharedpreferences.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import baltamon.mx.lssharedpreferences.MainActivity;
import baltamon.mx.lssharedpreferences.R;
import baltamon.mx.lssharedpreferences.persistence.UserSession;

/**
 * Created by Baltazar Rodriguez on 21/03/2017.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                UserSession userSession = new UserSession(getApplicationContext());

                if (userSession.isUserLogged())
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                else
                    startActivity(new Intent(getApplicationContext(), RegisterActivity.class));

                finish();
            }
        }, 3000);
    }
}
