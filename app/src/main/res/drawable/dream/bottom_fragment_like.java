package com.iaovy.dream;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class bottom_fragment_like extends Fragment {
    private static Context context;
    View view;
    TabLayout like_tablayout;
    ViewPager like_viewpager;
    private  com.iaovy.dream.bottom_fragment_like.MyAdapter like_adapter;
    private String[] like_title = {"电子书","视频"};
    private List<Fragment> like_list;

    public static com.iaovy.dream.bottom_fragment_like createFragment(Context main_like){
        context = main_like;
        return new com.iaovy.dream.bottom_fragment_like();
    }
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.main_bottom_like,container,false);

        like_tablayout=(TabLayout)view.findViewById(R.id.like_tablayout);
        like_viewpager=(ViewPager)view.findViewById(R.id.like_viewpager);

        like_list=new ArrayList<>();
        like_list.add(com.iaovy.dream.like_book.createFragment(this));
        like_list.add(like_video.createFragment(this));

        like_adapter=new MyAdapter(getChildFragmentManager());
        like_viewpager.setAdapter(like_adapter);
        like_viewpager.setOffscreenPageLimit(2);
        like_tablayout.setupWithViewPager(like_viewpager);

        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return like_list.get(i);
        }

        @Override
        public int getCount() {
            return like_list.size();
        }
        @Override
        public CharSequence getPageTitle(int i){
            return like_title[i];
        }
    }
}
