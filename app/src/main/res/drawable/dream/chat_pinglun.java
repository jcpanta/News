package com.iaovy.dream;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class chat_pinglun extends Fragment {
    private static bottom_fragment_chat contex;
    View view;
    RelativeLayout comment1,comment2,comment3;

    public static com.iaovy.dream.chat_pinglun createFragment(bottom_fragment_chat chat_pl){
        contex = chat_pl;
        return new com.iaovy.dream.chat_pinglun();
    }
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.chat_pinglun,container,false);

        comment1 = (RelativeLayout)view.findViewById(R.id.bf4f2_1);
        comment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        comment2 = (RelativeLayout)view.findViewById(R.id.bf4f2_2);
        comment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        comment3 = (RelativeLayout)view.findViewById(R.id.bf4f2_3);
        comment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
}
