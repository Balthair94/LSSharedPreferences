package baltamon.mx.lssharedpreferences.viewholders;

import android.view.View;
import android.widget.EditText;

import baltamon.mx.lssharedpreferences.R;

/**
 * Created by Baltazar Rodriguez on 21/03/2017.
 */

public class RegisterViewHolder {

    private EditText mUserName;
    private EditText mUserEmail;
    private EditText mUserPhone;

    public RegisterViewHolder(View view){
        mUserName = (EditText) view.findViewById(R.id.et_user_name);
        mUserEmail = (EditText) view.findViewById(R.id.et_user_email);
        mUserPhone = (EditText) view.findViewById(R.id.et_user_phone);
    }

    public EditText getmUserName() {
        return mUserName;
    }

    public EditText getmUserEmail() {
        return mUserEmail;
    }

    public EditText getmUserPhone() {
        return mUserPhone;
    }

}
