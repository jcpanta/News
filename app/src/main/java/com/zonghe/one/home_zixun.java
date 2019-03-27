package com.zonghe.one;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class home_zixun extends Fragment  {
    private static bottom_fragment_home context;
    View view;

    public static home_zixun createFragment(bottom_fragment_home home_zx){
        context = home_zx;
        return new home_zixun();
    }
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.home_zixun,container,false);

        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
}
