package com.iaovy.dream;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Side_notifications extends AppCompatActivity implements View.OnClickListener {
    ImageButton notifications_back;
    RelativeLayout notifications_tishiyin;
    TextView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_notifications);

        notifications_back=(ImageButton)findViewById(R.id.notifications_back);
        notifications_tishiyin=(RelativeLayout)findViewById(R.id.notifications_tishiyin);
        back=(TextView)findViewById(R.id.back);

        notifications_back.setOnClickListener(this);
        notifications_tishiyin.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.notifications_back:
                finish();
                break;
            case R.id.notifications_tishiyin:
                break;
            case R.id.back:
                finish();
                break;
        }
    }
}
