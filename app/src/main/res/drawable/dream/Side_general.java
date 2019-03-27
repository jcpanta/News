package com.iaovy.dream;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Side_general extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout general_R1,general_R2,general_R3,general_R4,general_R5,general_R6,general_R7,general_R8;
    ImageButton general_back;
    TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_general);

        general_R1=(RelativeLayout)findViewById(R.id.general_R1);
        general_R2=(RelativeLayout)findViewById(R.id.general_R2);
        general_R3=(RelativeLayout)findViewById(R.id.general_R3);
        general_R4=(RelativeLayout)findViewById(R.id.general_R4);
        general_R5=(RelativeLayout)findViewById(R.id.general_R5);
        general_R6=(RelativeLayout)findViewById(R.id.general_R6);
        general_R7=(RelativeLayout)findViewById(R.id.general_R7);
        general_R8=(RelativeLayout)findViewById(R.id.general_R8);
        general_back=(ImageButton)findViewById(R.id.general_back);
        back=(TextView)findViewById(R.id.back);

        general_R1.setOnClickListener(this);
        general_R2.setOnClickListener(this);
        general_R3.setOnClickListener(this);
        general_R4.setOnClickListener(this);
        general_R5.setOnClickListener(this);
        general_R6.setOnClickListener(this);
        general_R7.setOnClickListener(this);
        general_R8.setOnClickListener(this);
        general_back.setOnClickListener(this);
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.general_R1:
                break;
            case R.id.general_R2:
                break;
            case R.id.general_R3:
                break;
            case R.id.general_R4:
                break;
            case R.id.general_R5:
                break;
            case R.id.general_R6:
                break;
            case R.id.general_R7:
                break;
            case R.id.general_R8:
                break;
            case R.id.general_back:
                finish();
                break;
            case R.id.back:
                finish();
                break;
        }
    }
}
