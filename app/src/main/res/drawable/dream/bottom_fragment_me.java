package com.iaovy.dream;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class bottom_fragment_me extends Fragment {
    private static Context context;
    View view;

    public static com.iaovy.dream.bottom_fragment_me createFragment(Context main_me){
        context = main_me;
        return new com.iaovy.dream.bottom_fragment_me();
    }
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.main_bottom_me,container,false);
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
}
