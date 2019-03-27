package com.iaovy.dream;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Side_score extends AppCompatActivity implements View.OnClickListener {
    ImageButton scoreback;
    Button scorerecharge;
    RelativeLayout tsecurity;
    TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_score);

        back=(TextView)findViewById(R.id.back);
        back.setOnClickListener(this);
        scoreback = (ImageButton)findViewById(R.id.score_back);
        scoreback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        scorerecharge = (Button)findViewById(R.id.score_recharge);
        scorerecharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.iaovy.dream.Side_score.this,"暂不支持",Toast.LENGTH_SHORT).show();
            }
        });

        tsecurity = (RelativeLayout)findViewById(R.id.score_1);
        tsecurity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //startActivity(new Intent(Side_score.this,score_anquan.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
}
