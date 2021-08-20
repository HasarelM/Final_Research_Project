package com.hasarelm.finalresearch.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.hasarelm.finalresearch.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText mEtName,mEtNIC,mEtMobileNo,mEtEmployeeID, mEtEmail,mEtPassword,mEtConfirmPassword;
    private LinearLayout mLvSignUp,mLvBack;
    private TextView mTvSingIn;
    private SearchableSpinner mSpProvince;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
    }

    private void initView() {
        mEtName = findViewById(R.id.activity_register_user_name);
        mEtNIC = findViewById(R.id.activity_register_user_nic);
        mEtEmployeeID = findViewById(R.id.activity_register_user_emp_ID);
        mEtMobileNo = findViewById(R.id.activity_register_user_mobile);
        mEtEmail = findViewById(R.id.activity_register_user_email);
        mEtPassword = findViewById(R.id.activity_register_user_password);
        mEtConfirmPassword = findViewById(R.id.activity_register_user_c_password);
        mSpProvince = findViewById(R.id.activity_register_sp_province);
        mLvSignUp = findViewById(R.id.activity_register_sign_up_click);
        mTvSingIn = findViewById(R.id.activity_register_tv_sign_in);
        mLvBack = findViewById(R.id.register_activity_lv);
        mLvBack.setOnClickListener(this);
        mLvSignUp.setOnClickListener(this);
        mTvSingIn.setOnClickListener(this);
    }

    private boolean registerFiledValidation(){
        String PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}";
        String name = mEtName.getText().toString();
        String nic = mEtNIC.getText().toString();
        String empID = mEtEmployeeID.getText().toString();
        String mobile = mEtMobileNo.getText().toString();
        String email = mEtEmail.getText().toString();
        String password = mEtPassword.getText().toString();
        String c_password = mEtConfirmPassword.getText().toString();

        if (name.length()==0){
            mEtName.requestFocus();
            mEtName.setError("Field cannot be blank!");
            return false;

        }else if (nic.length()==0){
            mEtNIC.requestFocus();
            mEtNIC.setError("Field can't blank!");
            return false;

        }else if (!nic.matches("^[0-9]{9}[vVxX]$")){
            mEtNIC.requestFocus();
            mEtNIC.setError("Invalid NIC number!");
            return false;

        }else if(empID.length()==0){
            mEtEmployeeID.requestFocus();
            mEtEmployeeID.setError("Field cannot be blank!");
            return false;

        }else if (mobile.length()==0){
            mEtMobileNo.requestFocus();
            mEtMobileNo.setError("Field cannot be blank!");
            return false;

        }else if (mobile.length()<10){
            mEtMobileNo.requestFocus();
            mEtMobileNo.setError("Invalid Mobile Number!");
            return false;

        }else if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
            mEtEmail.requestFocus();
            mEtEmail.setError("Invalid Email address!");
            return false;

        }else if (email.length()==0){
            mEtEmail.requestFocus();
            mEtEmail.setError("Field can't blank!");
            return false;

        }else if (password.length()==0){
            mEtPassword.requestFocus();
            mEtPassword.setError("Password Can't blank!");
            return false;

        }else if (!password.matches(PASSWORD_PATTERN)){
            mEtPassword.requestFocus();
            mEtPassword.setError("Invalid password!");
            return false;

        }else if (c_password.length()==0){
            mEtConfirmPassword.requestFocus();
            mEtConfirmPassword.setError("Password Can't blank!");
            return false;

        }else if (!c_password.matches(PASSWORD_PATTERN)){
            mEtConfirmPassword.requestFocus();
            mEtConfirmPassword.setError("Invalid confirm password!");
            return false;

        }else if (!c_password.matches(password)){
            mEtConfirmPassword.requestFocus();
            mEtConfirmPassword.setError("Password doesn't match!");
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_register_sign_up_click:
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_register_tv_sign_in:
                Intent intent1 = new Intent(this,LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.register_activity_lv:
                Intent intent2 = new Intent(this,LoginActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}