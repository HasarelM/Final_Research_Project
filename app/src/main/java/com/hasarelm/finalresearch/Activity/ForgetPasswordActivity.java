package com.hasarelm.finalresearch.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.hasarelm.finalresearch.R;

public class ForgetPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText mEtEmail;
    private LinearLayout mLvForgetPassword,mLvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        initView();
    }

    private void initView() {
        mEtEmail = findViewById(R.id.activity_forget_password_email);
        mLvForgetPassword = findViewById(R.id.activity_forget_login_click);
        mLvBack = findViewById(R.id.forgetPassword_activity_lv);
        mLvBack.setOnClickListener(this);
        mLvForgetPassword.setOnClickListener(this);
    }

    private boolean resetEmailValidation(){
        String email = mEtEmail.getText().toString();
        if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
            mEtEmail.requestFocus();
            mEtEmail.setError("Invalid email!");
            return false;
        }else if (email.length()==0){
            mEtEmail.requestFocus();
            mEtEmail.setError("Field cannot be blank!");
            return false;
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_forget_login_click:
                Intent intent = new Intent(this,ResetPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.forgetPassword_activity_lv:
                Intent intent1 = new Intent(this,LoginActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }
}