package com.iaovy.dream;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Side_privacy extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout privacy_tianjia,privacy_R2;
    ImageButton privacy_back;
    TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_privacy);

        privacy_tianjia=(RelativeLayout)findViewById(R.id.privacy_tianjia);
        privacy_R2=(RelativeLayout)findViewById(R.id.privacy_R2);
        privacy_back=(ImageButton)findViewById(R.id.privacy_back);
        back=(TextView)findViewById(R.id.back);

        privacy_tianjia.setOnClickListener(this);
        privacy_R2.setOnClickListener(this);
        privacy_back.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.privacy_tianjia:
                break;
            case R.id.privacy_R2:
                break;
            case R.id.privacy_back:
                finish();
                break;
            case R.id.back:
                finish();
                break;
        }
    }
}
