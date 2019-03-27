package com.iaovy.dream;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class home_luntan extends Fragment implements View.OnClickListener {
    private static bottom_fragment_home context;
    View view;
    RelativeLayout luntan_R1,luntan_R2,luntan_R3,luntan_R4,luntan_R5,luntan_R6,luntan_R7,luntan_R8,luntan_R9,luntan_R10;
    FloatingActionButton luntan_plus;

    public static com.iaovy.dream.home_luntan createFragment(bottom_fragment_home home_lt){
        context = home_lt;
        return new com.iaovy.dream.home_luntan();
    }
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.home_luntan,container,false);

        luntan_R1=(RelativeLayout)view.findViewById(R.id.luntan_R1);
        luntan_R2=(RelativeLayout)view.findViewById(R.id.luntan_R2);
        luntan_R3=(RelativeLayout)view.findViewById(R.id.luntan_R3);
        luntan_R4=(RelativeLayout)view.findViewById(R.id.luntan_R4);
        luntan_R5=(RelativeLayout)view.findViewById(R.id.luntan_R5);
        luntan_R6=(RelativeLayout)view.findViewById(R.id.luntan_R6);
        luntan_R7=(RelativeLayout)view.findViewById(R.id.luntan_R7);
        luntan_R8=(RelativeLayout)view.findViewById(R.id.luntan_R8);
        luntan_R9=(RelativeLayout)view.findViewById(R.id.luntan_R9);
        luntan_R10=(RelativeLayout)view.findViewById(R.id.luntan_R10);

       luntan_plus=(FloatingActionButton) view.findViewById(R.id.luntan_plus);

        luntan_R1.setOnClickListener(this);
        luntan_R2.setOnClickListener(this);
        luntan_R3.setOnClickListener(this);
        luntan_R4.setOnClickListener(this);
        luntan_R5.setOnClickListener(this);
        luntan_R6.setOnClickListener(this);
        luntan_R7.setOnClickListener(this);
        luntan_R8.setOnClickListener(this);
        luntan_R9.setOnClickListener(this);
        luntan_R10.setOnClickListener(this);

        luntan_plus.setOnClickListener(this);

        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.luntan_R1:
                break;
            case R.id.luntan_R2:
                break;
            case R.id.luntan_R3:
                break;
            case R.id.luntan_R4:
                break;
            case R.id.luntan_R5:
                break;
            case R.id.luntan_R6:
                break;
            case R.id.luntan_R7:
                break;
            case R.id.luntan_R8:
                break;
            case R.id.luntan_R9:
                break;
            case R.id.luntan_R10:
                break;
            case R.id.luntan_plus:
                startActivity(new Intent(getActivity(), com.iaovy.dream.luntan_plus.class ));
                break;
        }
    }
}


