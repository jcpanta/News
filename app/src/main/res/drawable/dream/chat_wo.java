package com.iaovy.dream;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class chat_wo extends Fragment {
    private static bottom_fragment_chat contex;
    View view;

    public static com.iaovy.dream.chat_wo createFragment(bottom_fragment_chat chat_w){
        contex=chat_w;
        return new com.iaovy.dream.chat_wo();
    }
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.chat_wo,container,false);
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
}
