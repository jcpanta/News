package com.iaovy.dream;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class luntan_plus extends AppCompatActivity implements View.OnClickListener {
    ImageButton plus_back;
    TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luntan_plus);

        plus_back=(ImageButton)findViewById(R.id.plus_back);
        back=(TextView)findViewById(R.id.back);

        plus_back.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.plus_back:
                finish();
                break;
            case R.id.back:
                finish();
                break;
        }
    }
}
