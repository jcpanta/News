package com.zonghe.one;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zonghe.one.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class home_tuijian extends Fragment  {
    private static bottom_fragment_home context;
    View view;
    Banner tuijian_banner;

    public static home_tuijian createFragment(bottom_fragment_home home_tj){
        context = home_tj;
        return new home_tuijian();
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
        tuijian_banner.setImageLoader(new GlideImageLoader());
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

        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
}


