package com.zonghe.one;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.youth.banner.BannerConfig;
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
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.home_tuijian,container,false);

        List images = new ArrayList();
        images.add(R.drawable.advertisment1);
        images.add(R.drawable.advertisment2);
        images.add(R.drawable.advertisment3);
        images.add(R.drawable.advertisment4);

        /*
        List titles=new ArrayList();
        titles.add(R.string.banner_images1);
        titles.add(R.string.banner_images2);
        titles.add(R.string.banner_images3);
        titles.add(R.string.banner_images4);
        */

        tuijian_banner= (Banner)view.findViewById(R.id.banner);
        //设置图片加载器
        tuijian_banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        tuijian_banner.setImages(images);

        //设置title集合
       // tuijian_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
       // tuijian_banner.setBannerTitles(titles);

        //banner设置方法全部调用完毕时最后调用
        tuijian_banner.start();

        //增加点击事件
        tuijian_banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                switch (position){
                    case 0:
                        //startActivity(new Intent(getActivity(),));
                        break;
                    case 1:
                        //startActivity(new Intent(getActivity(),));
                        break;
                    case 2:
                        //startActivity(new Intent(getActivity(),));
                        break;
                    case 3:
                        //startActivity(new Intent(getActivity(),));
                        break;
                }
            }
        });

        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
}


