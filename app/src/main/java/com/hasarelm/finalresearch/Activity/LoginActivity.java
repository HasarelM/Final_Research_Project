package com.hasarelm.finalresearch.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.hasarelm.finalresearch.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private TextInputEditText mEtUserName, mEtPassword;
    private TextView mTvForgetPassword, mTvSignUp;
    private LinearLayout mLvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        mEtUserName = findViewById(R.id.activity_login_et_user_name);
        mEtPassword = findViewById(R.id.activity_login_et_password);
        mLvLogin = findViewById(R.id.activity_login_click);
        mTvSignUp = findViewById(R.id.activity_login_tv_sign_up);
        mTvForgetPassword = findViewById(R.id.activity_login_tv_forget_password);
        mTvSignUp.setOnClickListener(this);
        mTvForgetPassword.setOnClickListener(this);
        mLvLogin.setOnClickListener(this);
    }

    private boolean loginValidation() {
        String email = mEtUserName.getText().toString();
        String password = mEtPassword.getText().toString();
        String PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}";

        if (email.length() == 0) {
            mEtUserName.requestFocus();
            mEtUserName.setError("Field cannot be blank");
            return false;

        } else if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            mEtUserName.requestFocus();
            mEtUserName.setError("invalid email address");
            return false;

        } else if (password.length() == 0) {
            mEtPassword.requestFocus();
            mEtPassword.setError("Field cannot be blank");
            return false;

        } else if (!password.matches(PASSWORD_PATTERN)) {
            mEtPassword.requestFocus();
            mEtPassword.setError("Invalid password");
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_login_click:
              /*  if (loginValidation()) {

                }*/
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                break;

            case R.id.activity_login_tv_sign_up:
                Intent intent1 = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent1);
                break;
            case R.id.activity_login_tv_forget_password:
                Intent intent2 = new Intent(LoginActivity.this,ForgetPasswordActivity.class);
                startActivity(intent2);
                break;
        }
    }
}