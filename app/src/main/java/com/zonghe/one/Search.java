package com.zonghe.one;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Search extends AppCompatActivity implements View.OnClickListener {
    private EditText_Clear search;
    private RelativeLayout search_top;
    private ImageButton search_back;
    private Button search_clear;

    private ICallBack iCallBack;
    private BCallBack bCallBack;

    private ListView search_list;
    private BaseAdapter baseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search=(EditText_Clear)findViewById(R.id.search);
        search_top=(RelativeLayout)findViewById(R.id.search_top);
        search_back=(ImageButton)findViewById(R.id.search_back);
        search_list=(ListView)findViewById(R.id.search_list);
        search_clear=(Button)findViewById(R.id.search_clear);
        search_clear.setVisibility(View.INVISIBLE);

        search.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {

                    // 点击搜索按键后，根据输入的搜索字段进行查询
                    // 注：由于此处需求会根据自身情况不同而不同，所以具体逻辑由开发者自己实现，此处仅留出接口
                    if (!(iCallBack == null)){
                        iCallBack.SearchAciton(search.getText().toString());
                    }
                    Toast.makeText(Search.this, "需要搜索的是" + search.getText(), Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        search_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_back:
                finish();
        }
    }

    // 搜索按键回调接口
    public interface ICallBack {
        void SearchAciton(String string);
    }
    // 返回按键接口回调
    public void setOnClickBack(BCallBack bCallBack){
        this.bCallBack = bCallBack;
    }

}
