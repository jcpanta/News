package com.iaovy.dream;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class chat_sixin extends Fragment {
    private static com.iaovy.dream.bottom_fragment_chat contex;
    View view;
    RelativeLayout chat1;
    RelativeLayout chat2;

    public static com.iaovy.dream.chat_sixin createFragment(com.iaovy.dream.bottom_fragment_chat chat_sx){
        contex= chat_sx;
        return new com.iaovy.dream.chat_sixin();
    }
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.chat_sixin,container,false);

        chat1 = (RelativeLayout)view.findViewById(R.id.chat_chat1);
        chat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getActivity(),chat1.class));
            }
        });

        chat2 = (RelativeLayout)view.findViewById(R.id.chat_chat2);
        chat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getActivity(),chat2.class));
            }
        });
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
}
