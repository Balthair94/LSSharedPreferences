package baltamon.mx.lssharedpreferences.persistence;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Baltazar Rodriguez on 21/03/2017.
 */

public class UserSession {
    private SharedPreferences manager;
    private SharedPreferences.Editor editor;

    //NAME OF THE "FILE, TABLE THAT CONTAIN THE USER SESSION"
    private static final String SESSION_TAG = "user_session";

    //NAME OF THE FIELDS IN THE USER_SESSION
    private static final String USER_NAME = "user_name";
    private static final String USER_EMAIL = "user_email";
    private static final String USER_PHONE = "user_phone";

    public UserSession(Context context){
        manager = context.getSharedPreferences(SESSION_TAG, 0);
        editor = manager.edit();
    }

    /**
     * If USER_NAME is different than null, there is a user logged
     * @return
     */
    public boolean isUserLogged(){return getUserName() != null;}

    /**
     * We clean the SharePreference
     */
    public void logout(){
        editor.clear();
        editor.commit();
    }

    /**
     * Send the data to the USER_SESSION
     * @param userName
     */
    public void setUserName(String userName){
        editor.putString(USER_NAME, userName);
        editor.commit();
    }

    public void setUserEmail(String userEmail){
        editor.putString(USER_EMAIL, userEmail);
        editor.commit();
    }

    public void setUserPhone(String userPhone){
        editor.putString(USER_PHONE, userPhone);
        editor.commit();
    }

    /**
     * Get data from USER_SESSION
     * @return
     */
    public String getUserName(){return manager.getString(USER_NAME, null);}

    public String getUserEmail(){return manager.getString(USER_EMAIL, null);}

    public String getUserPhone(){return manager.getString(USER_PHONE, null);}

}
