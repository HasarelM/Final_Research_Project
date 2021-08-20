package com.hasarelm.finalresearch.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.hasarelm.finalresearch.R;

public class ResetPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mLvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        initView();
    }

    private void initView() {
        mLvBack = findViewById(R.id.reset_Password_activity_lv);
        mLvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reset_Password_activity_lv:
                Intent intent = new Intent(this,ForgetPasswordActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}