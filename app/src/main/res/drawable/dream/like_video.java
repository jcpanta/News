package com.iaovy.dream;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class like_video extends Fragment {
    private static com.iaovy.dream.bottom_fragment_like contex;
    View view;

    public static com.iaovy.dream.like_video createFragment(com.iaovy.dream.bottom_fragment_like like_v){
        contex=like_v;
        return new com.iaovy.dream.like_video();
    }
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.like_video,container,false);
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
}
