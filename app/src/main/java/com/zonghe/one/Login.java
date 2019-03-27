package com.zonghe.one;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {  //登录界面活动

    public int pwdresetFlag=0;
    private EditText mAccount;  //用户名
    private EditText mPwd;  //密码
    private Button mLoginButton; //登录按钮
    private TextView mSignButton; //注册按钮
    private CheckBox mRememberCheck;

    private SharedPreferences login_sp;
    private  String userNameValue;
    private  String passwordValue;

    private UserDataManager mUserDataManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAccount = (EditText)findViewById(R.id.login_username);
        mPwd = (EditText)findViewById(R.id.login_password);
        mLoginButton = (Button)findViewById(R.id.login_login);
        mSignButton = (TextView)findViewById(R.id.login_sign);
        mRememberCheck =(CheckBox)findViewById(R.id.login_remember);

        login_sp = getSharedPreferences("userInfo",0);
        String name = login_sp.getString("USER_NAME","");
        String pwd = login_sp.getString("PASSWORD","");
        boolean choseRemember=login_sp.getBoolean("mRememberCheck",false);
        boolean choseAutoLogin=login_sp.getBoolean("mAutologinCheck",false);
        if(choseRemember){
            mAccount.setText(name);
            mPwd.setText(pwd);
            mRememberCheck.setChecked(true);
        }

        mLoginButton.setOnClickListener(mListener);
        mSignButton.setOnClickListener(mListener);

        if(mUserDataManager == null){
            mUserDataManager = new UserDataManager(this);
            mUserDataManager.openDataBase();
        }
    }
    OnClickListener mListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.login_login:
                    login();
                    break;
                case R.id.login_sign:
                    startActivity(new Intent(Login.this,Sign.class));
                    break;
            }
        }
    };
    public void login(){
        if(isUserNameAndPwdValid()){
            String userName = mAccount.getText().toString().trim();
            String userPwd = mPwd.getText().toString().trim();
            SharedPreferences.Editor editor = login_sp.edit();
            int result = mUserDataManager.findUserByNameAndPwd(userName,userPwd);
            if (result == 1) {
                editor.putString("USER_NAME", userName);
                editor.putString("PASSWORD", userPwd);
                editor.commit();

                if(mRememberCheck.isChecked()){
                    editor.putBoolean("mRememberCheck",true);
                }else {
                    editor.putBoolean("mRememberCheck",false);
                }
                editor.commit();

                startActivity(new Intent(Login.this, Main.class));
                Toast.makeText(Login.this, "登陆成功", Toast.LENGTH_SHORT).show();
                finish();
            }else if (result == 0){
                Toast.makeText(Login.this,"账号或密码不正确",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public boolean isUserNameAndPwdValid(){
        if(mAccount.getText().toString().trim().equals("")){
            Toast.makeText(Login.this,"请输入你的账号",Toast.LENGTH_SHORT).show();
            return false;
        }else if (mPwd.getText().toString().trim().equals("")){
            Toast.makeText(Login.this,"请输入你的密码",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    @Override
    protected void onResume() {
        if (mUserDataManager == null) {
            mUserDataManager = new UserDataManager(this);
            mUserDataManager.openDataBase();
        }
        super.onResume();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    protected void onPause() {
        if (mUserDataManager != null) {
            mUserDataManager.closeDataBase();
            mUserDataManager = null;
        }
        super.onPause();
    }
}
