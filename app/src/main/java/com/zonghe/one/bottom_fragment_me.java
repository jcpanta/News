package com.zonghe.one;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class bottom_fragment_me extends Fragment {
    private static Context context;
    View view;
    TextView me_name,me_picture;
    private static String strUserName,str;

    public static bottom_fragment_me createFragment(Context main_me){
        context = main_me;
        return new bottom_fragment_me();
    }
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view=inflater.inflate(R.layout.main_bottom_me,container,false);

        me_name=(TextView)view.findViewById(R.id.me_name);
        me_picture=(TextView)view.findViewById(R.id.me_picture);
        Intent intent1=getActivity().getIntent();
        if (intent1 != null){
            Bundle data=intent1.getExtras();
            strUserName=data.getString("username");
            me_name.setText(strUserName);
            str=strUserName.substring(0,1);
            me_picture.setText(str);
            me_picture.setTextSize(20);
        }
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
}
