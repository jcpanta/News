package com.iaovy.dream;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class home_zixun extends Fragment implements View.OnClickListener {
    private static bottom_fragment_home context;
    View view;
    RelativeLayout zixun_R1,zixun_R2,zixun_R3,zixun_R4,zixun_R5,zixun_R6,zixun_R7,zixun_R8,zixun_R9,zixun_R10,zixun_R11,zixun_R12;

    public static com.iaovy.dream.home_zixun createFragment(bottom_fragment_home home_zx){
        context = home_zx;
        return new com.iaovy.dream.home_zixun();
    }
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.home_zixun,container,false);

        zixun_R1=(RelativeLayout)view.findViewById(R.id.zixun_R1);
        zixun_R2=(RelativeLayout)view.findViewById(R.id.zixun_R2);
        zixun_R3=(RelativeLayout)view.findViewById(R.id.zixun_R3);
        zixun_R4=(RelativeLayout)view.findViewById(R.id.zixun_R4);
        zixun_R5=(RelativeLayout)view.findViewById(R.id.zixun_R5);
        zixun_R6=(RelativeLayout)view.findViewById(R.id.zixun_R6);
        zixun_R7=(RelativeLayout)view.findViewById(R.id.zixun_R7);
        zixun_R8=(RelativeLayout)view.findViewById(R.id.zixun_R8);
        zixun_R9=(RelativeLayout)view.findViewById(R.id.zixun_R9);
        zixun_R10=(RelativeLayout)view.findViewById(R.id.zixun_R10);
        zixun_R11=(RelativeLayout)view.findViewById(R.id.zixun_R11);
        zixun_R12=(RelativeLayout)view.findViewById(R.id.zixun_R12);

        zixun_R1.setOnClickListener(this);
        zixun_R2.setOnClickListener(this);
        zixun_R3.setOnClickListener(this);
        zixun_R4.setOnClickListener(this);
        zixun_R5.setOnClickListener(this);
        zixun_R6.setOnClickListener(this);
        zixun_R7.setOnClickListener(this);
        zixun_R8.setOnClickListener(this);
        zixun_R9.setOnClickListener(this);
        zixun_R10.setOnClickListener(this);
        zixun_R11.setOnClickListener(this);
        zixun_R12.setOnClickListener(this);

        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (getId()){
            case R.id.zixun_R1:
                break;
            case R.id.zixun_R2:
                break;
            case R.id.zixun_R3:
                break;
            case R.id.zixun_R4:
                break;
            case R.id.zixun_R5:
                break;
            case R.id.zixun_R6:
                break;
            case R.id.zixun_R7:
                break;
            case R.id.zixun_R8:
                break;
            case R.id.zixun_R9:
                break;
            case R.id.zixun_R10:
                break;
            case R.id.zixun_R11:
                break;
            case R.id.zixun_R12:
                break;
        }

    }
}
