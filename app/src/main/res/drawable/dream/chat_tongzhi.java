package com.iaovy.dream;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class chat_tongzhi extends Fragment implements View.OnClickListener{
    private static bottom_fragment_chat contex;
    View view;
    RelativeLayout bf4f4_1, bf4f4_2, bf4f4_3, bf4f4_4, bf4f4_5, bf4f4_6, bf4f4_7, bf4f4_8;
    RelativeLayout bf4f4_9, bf4f4_10, bf4f4_11, bf4f4_12, bf4f4_13, bf4f4_14, bf4f4_15, bf4f4_16, bf4f4_17;

    public static com.iaovy.dream.chat_tongzhi createFragment(bottom_fragment_chat chat_tz){
        contex = chat_tz;
        return new com.iaovy.dream.chat_tongzhi();
    }
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.chat_tongzhi,container,false);

        bf4f4_1 = (RelativeLayout)view.findViewById(R.id. bf4f4_1);
        bf4f4_2 = (RelativeLayout)view.findViewById(R.id. bf4f4_2);
        bf4f4_3 = (RelativeLayout)view.findViewById(R.id. bf4f4_3);
        bf4f4_4 = (RelativeLayout)view.findViewById(R.id. bf4f4_4);
        bf4f4_5 = (RelativeLayout)view.findViewById(R.id. bf4f4_5);
        bf4f4_6 = (RelativeLayout)view.findViewById(R.id. bf4f4_6);
        bf4f4_7 = (RelativeLayout)view.findViewById(R.id. bf4f4_7);
        bf4f4_8 = (RelativeLayout)view.findViewById(R.id. bf4f4_8);
        bf4f4_9 = (RelativeLayout)view.findViewById(R.id. bf4f4_9);
        bf4f4_10 = (RelativeLayout)view.findViewById(R.id. bf4f4_10);
        bf4f4_11 = (RelativeLayout)view.findViewById(R.id. bf4f4_11);
        bf4f4_12 = (RelativeLayout)view.findViewById(R.id. bf4f4_12);
        bf4f4_13 = (RelativeLayout)view.findViewById(R.id. bf4f4_13);
        bf4f4_14 = (RelativeLayout)view.findViewById(R.id. bf4f4_14);
        bf4f4_15 = (RelativeLayout)view.findViewById(R.id. bf4f4_15);
        bf4f4_16 = (RelativeLayout)view.findViewById(R.id. bf4f4_16);
        bf4f4_17 = (RelativeLayout)view.findViewById(R.id. bf4f4_17);

        bf4f4_1.setOnClickListener(this);
        bf4f4_2.setOnClickListener(this);
        bf4f4_3.setOnClickListener(this);
        bf4f4_4.setOnClickListener(this);
        bf4f4_5.setOnClickListener(this);
        bf4f4_6.setOnClickListener(this);
        bf4f4_7.setOnClickListener(this);
        bf4f4_8.setOnClickListener(this);
        bf4f4_9.setOnClickListener(this);
        bf4f4_10.setOnClickListener(this);
        bf4f4_11.setOnClickListener(this);
        bf4f4_12.setOnClickListener(this);
        bf4f4_13.setOnClickListener(this);
        bf4f4_14.setOnClickListener(this);
        bf4f4_15.setOnClickListener(this);
        bf4f4_16.setOnClickListener(this);
        bf4f4_17.setOnClickListener(this);

        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bf4f4_1:
                break;
            case R.id.bf4f4_2:
                break;
            case R.id.bf4f4_3:
                break;
            case R.id.bf4f4_4:
                break;
            case R.id.bf4f4_5:
                break;
            case R.id.bf4f4_6:
                break;
            case R.id.bf4f4_7:
                break;
            case R.id.bf4f4_8:
                break;
            case R.id.bf4f4_9:
                break;
            case R.id.bf4f4_10:
                break;
            case R.id.bf4f4_11:
                break;
            case R.id.bf4f4_12:
                break;
            case R.id.bf4f4_13:
                break;
            case R.id.bf4f4_14:
                break;
            case R.id.bf4f4_15:
                break;
            case R.id.bf4f4_16:
                break;
            case R.id.bf4f4_17:
                break;
        }
    }
}
