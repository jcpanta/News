package com.zonghe.one;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main extends AppCompatActivity implements View.OnClickListener {

    private BottomNavigationView main_bottomnavigation;
    private ViewPager main_viewPager;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    TextView home_name;
    ImageButton main_search;
    SharedPreferences sprfMain;
    SharedPreferences.Editor editorMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //底部导航栏
        main_viewPager=(ViewPager)findViewById(R.id.main_viewpager);
        main_viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                main_bottomnavigation.getMenu().getItem(position).setChecked(true);

            }

            @Override
            public void onPageScrollStateChanged(int position) {

            }
        });

        final ArrayList<Fragment>fgLists=new ArrayList<>(4);
        fgLists.add(bottom_fragment_home.createFragment(this));
        fgLists.add(bottom_fragment_like.createFragment(this));
        fgLists.add(bottom_fragment_search.createFragment(this));
        fgLists.add(bottom_fragment_me.createFragment(this));

        FragmentPagerAdapter mPagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fgLists.get(position);
            }

            @Override
            public int getCount() {
                return fgLists.size();
            }
        };

        main_viewPager.setAdapter(mPagerAdapter);
        main_viewPager.setOffscreenPageLimit(2);

        main_bottomnavigation=(BottomNavigationView)findViewById(R.id.main_bottomnavigation);
        //BottomNavigationViewHelper.disableShiftMode(main_bottomnavigation);
        main_bottomnavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.bottom_home:
                        main_viewPager.setCurrentItem(0);
                        break;
                    case R.id.bottom_like:
                        main_viewPager.setCurrentItem(1);
                        break;
                    case R.id.bottom_search:
                        main_viewPager.setCurrentItem(2);
                        break;
                    case R.id.bottom_me:
                        main_viewPager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });

        //侧滑导航栏
        drawerLayout=(DrawerLayout)findViewById(R.id.main);
        navigationView=(NavigationView)findViewById(R.id.main_side_left);
        View side_main=navigationView.getHeaderView(0);
        home_name =(TextView)findViewById(R.id.main_name);
        home_name.setOnClickListener(this);

        /*
        navigationView.findViewById(R.id.text12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
        */

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.side_account:
                        //startActivity(new Intent(Main.this, Side_account.class));
                        break;
                    case R.id.side_score:
                        //startActivity(new Intent(Main.this, Side_score.class));
                        break;
                    case R.id.side_notifications:
                        //startActivity(new Intent(Main.this, Side_notifications.class));
                        break;
                    case R.id.side_privacy:
                        //startActivity(new Intent(Main.this, Side_privacy.class));
                        break;
                    case R.id.side_general:
                        //startActivity(new Intent(Main.this, Side_general.class));
                        break;
                    case R.id.side_about:
                        //startActivity(new Intent(Main.this, Side_about.class));
                        Toast.makeText(Main.this,"暂不支持",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.side_help:
                        //startActivity(new Intent(Main.this, Side_help.class));
                        Toast.makeText(Main.this,"暂不支持",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.side_out:

                        //resetSprfMain();

                        Intent intent=new Intent(Main.this,Login.class);
                        startActivity(intent);
                        Main.this.finish();
                        break;
                }
                drawerLayout.closeDrawer(navigationView);
                return true;
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_name:
                if(drawerLayout.isDrawerOpen(navigationView)){
                    drawerLayout.closeDrawer(navigationView);
                }else{
                    drawerLayout.openDrawer(navigationView);
                }
                break;
        }
    }
    @Override
    public void  onPointerCaptureChanged(boolean hasCapture){
    }

    /*
    public void resetSprfMain(){
        sprfMain= PreferenceManager.getDefaultSharedPreferences(this);
        editorMain=sprfMain.edit();
        editorMain.putBoolean("main",false);
        editorMain.commit();
    }
    */
    public void setDrawerLayout(DrawerLayout drawerLayout){
        this.drawerLayout=drawerLayout;
    }
    public DrawerLayout getDrawerLayout(){
        return this.drawerLayout;
    }
}
