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

public class bottom_fragment_chat extends Fragment {
    private static Context context;
    View view;
    private ViewPager chat_viewpager;
    private TabLayout chat_tablayout;

    private List<Fragment> chat_list;
    private com.iaovy.dream.bottom_fragment_chat.MyAdapter chat_adapter;
    private  String[] chat_title = {"私信","评论","@我","通知"};

    public static com.iaovy.dream.bottom_fragment_chat createFragment(Context main_chat){
        context = main_chat;
        return new com.iaovy.dream.bottom_fragment_chat();
    }
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.main_bottom_chat,container,false);

        chat_viewpager=(ViewPager)view.findViewById(R.id.chat_viewpager);
        chat_tablayout=(TabLayout)view.findViewById(R.id.chat_tablayout);

        chat_list=new ArrayList<>();
        chat_list.add(chat_sixin.createFragment(this));
        chat_list.add(com.iaovy.dream.chat_pinglun.createFragment(this));
        chat_list.add(com.iaovy.dream.chat_wo.createFragment(this));
        chat_list.add(com.iaovy.dream.chat_tongzhi.createFragment(this));

        chat_adapter=new MyAdapter(getChildFragmentManager());
        chat_viewpager.setAdapter(chat_adapter);
        chat_viewpager.setOffscreenPageLimit(2);

        chat_tablayout.setupWithViewPager(chat_viewpager);



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
            return chat_list.get(i);
        }

        @Override
        public int getCount() {
            return chat_list.size();
        }
        @Override
        public CharSequence getPageTitle(int i){
            return chat_title[i];
        }
    }
}
