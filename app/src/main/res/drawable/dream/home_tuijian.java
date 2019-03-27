package com.iaovy.dream;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class home_tuijian extends Fragment implements View.OnClickListener {
    private static com.iaovy.dream.bottom_fragment_home context;
    View view;
    Banner tuijian_banner;
    RelativeLayout bf1f1_1, bf1f1_2, bf1f1_3, bf1f1_4, bf1f1_5, bf1f1_6, bf1f1_7, bf1f1_8,bf1f1_9,bf1f1_10;


    public static com.iaovy.dream.home_tuijian createFragment(com.iaovy.dream.bottom_fragment_home home_tj){
        context = home_tj;
        return new com.iaovy.dream.home_tuijian();
    }
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.home_tuijian,container,false);

        List images = new ArrayList();
        images.add(R.drawable.advertisment1);
        images.add(R.drawable.advertisment2);
        images.add(R.drawable.advertisment3);
        images.add(R.drawable.advertisment4);

        tuijian_banner= (Banner)view.findViewById(R.id.banner);
        //设置图片加载器
        tuijian_banner.setImageLoader(new com.iaovy.dream.GlideImageLoader());
        //设置图片集合
        tuijian_banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        tuijian_banner.start();

        //增加点击事件
        tuijian_banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(getActivity(), "position" + position, Toast.LENGTH_SHORT).show();
            }
        });

        bf1f1_1 = (RelativeLayout)view.findViewById(R.id.bf1f1_1);
        bf1f1_2 = (RelativeLayout)view.findViewById(R.id.bf1f1_2);
        bf1f1_3 = (RelativeLayout)view.findViewById(R.id.bf1f1_3);
        bf1f1_4 = (RelativeLayout)view.findViewById(R.id.bf1f1_4);
        bf1f1_5 = (RelativeLayout)view.findViewById(R.id.bf1f1_5);
        bf1f1_6 = (RelativeLayout)view.findViewById(R.id.bf1f1_6);
        bf1f1_7 = (RelativeLayout)view.findViewById(R.id.bf1f1_7);
        bf1f1_8 = (RelativeLayout)view.findViewById(R.id.bf1f1_8);
        bf1f1_9 = (RelativeLayout)view.findViewById(R.id.bf1f1_9);
        bf1f1_10 = (RelativeLayout)view.findViewById(R.id.bf1f1_10);

        bf1f1_1.setOnClickListener(this);
        bf1f1_2.setOnClickListener(this);
        bf1f1_3.setOnClickListener(this);
        bf1f1_4.setOnClickListener(this);
        bf1f1_5.setOnClickListener(this);
        bf1f1_6.setOnClickListener(this);
        bf1f1_7.setOnClickListener(this);
        bf1f1_8.setOnClickListener(this);
        bf1f1_9.setOnClickListener(this);
        bf1f1_10.setOnClickListener(this);

        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bf1f1_1:
                break;
            case R.id.bf1f1_2:
                break;
            case R.id.bf1f1_3:
                break;
            case R.id.bf1f1_4:
                break;
            case R.id.bf1f1_5:
                break;
            case R.id.bf1f1_6:
                break;
            case R.id.bf1f1_7:
                break;
            case R.id.bf1f1_8:
                break;
            case R.id.bf1f1_9:
                break;
            case R.id.bf1f1_10:
                break;
        }
    }
}


