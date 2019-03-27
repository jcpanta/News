package com.iaovy.dream;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Side_account extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout account_id,account_phone,account_pwd,account_voice,account_yingji,account_shebei,account_more,account_R4;
    ImageButton account_back;
    RelativeLayout account_shiming;
    TextView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_account);

        account_id=(RelativeLayout)findViewById(R.id.account_id);
        account_phone=(RelativeLayout)findViewById(R.id.account_phone);
        account_pwd=(RelativeLayout)findViewById(R.id.account_psw);
        account_voice=(RelativeLayout)findViewById(R.id.account_voice);
        account_yingji=(RelativeLayout)findViewById(R.id.account_yingji);
        account_shebei=(RelativeLayout)findViewById(R.id.account_shebei);
        account_more=(RelativeLayout)findViewById(R.id.account_more);
        account_R4=(RelativeLayout)findViewById(R.id.account_R4);
        account_shiming=(RelativeLayout)findViewById(R.id.account_shiming);
        back=(TextView)findViewById(R.id.back);

        account_back=(ImageButton) findViewById(R.id.account_back);

        account_id.setOnClickListener(this);
        account_phone.setOnClickListener(this);
        account_pwd.setOnClickListener(this);
        account_voice.setOnClickListener(this);
        account_yingji.setOnClickListener(this);
        account_shebei.setOnClickListener(this);
        account_more.setOnClickListener(this);
        account_R4.setOnClickListener(this);
        account_shiming.setOnClickListener(this);
        back.setOnClickListener(this);

        account_back.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.account_id:
                break;
            case R.id.account_phone:
                break;
            case R.id.account_psw:
                break;
            case R.id.account_voice:
                break;
            case R.id.account_yingji:
                break;
            case R.id.account_shebei:
                break;
            case R.id.account_more:
                break;
            case R.id.account_R4:
                break;
            case R.id.account_back:
                finish();
                break;
            case R.id.back:
                finish();
                break;
            case R.id.account_shiming:
                break;
        }
    }
}
