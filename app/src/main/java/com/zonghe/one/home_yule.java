package com.zonghe.one;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zonghe.one.JSONNewsEntityClass.Contentlist;
import com.zonghe.one.JSONNewsEntityClass.Imageurls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;
import static java.net.HttpURLConnection.HTTP_OK;

public class home_yule extends Fragment  {
    private static bottom_fragment_home context;
    View view;
    private String jsonString;
    private int showapi_res_code;
    private String showapi_res_error;
    private RecyclerView mRecyclerView;
    private NewsRecyclerListAdapter2 mNewsListAdapter;
    private List<Contentlist> mContentlistList;
    private List<Imageurls> mImageurlsList;

    public static home_yule createFragment(bottom_fragment_home home_yl){
        context = home_yl;
        return new home_yule();
    }
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.home_yule,container,false);
        mRecyclerView =view.findViewById(R.id.RecyclerView_yule);

        final Handler handler = new Handler(){

            public void handleMessage (Message msg){
                super.handleMessage(msg);
                if (msg.what ==1){
                    Log.d(TAG, "HandlerMessage: 请求完成即将进入解析");
                    handleJsonData(jsonString);
                    Log.d(TAG, "handleMessage: +mContentList="+mContentlistList);
                    Log.d(TAG, "HandlerMessage: 完成解析");
                    if (showapi_res_code ==0)
                    {
                        Log.d(TAG, "handleMessage: mContentlistList.size()="+mContentlistList.size());
                        mNewsListAdapter=new NewsRecyclerListAdapter2(container.getContext(),mContentlistList);
                        mRecyclerView.setAdapter(mNewsListAdapter);
                        mRecyclerView.setLayoutManager(new LinearLayoutManager(container.getContext(),LinearLayoutManager.VERTICAL,false));

                        mNewsListAdapter.setOnItemClickListener(new NewsListAdapter.onItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                Intent intent = new Intent(container.getContext(), every_news_activity.class);
                                Contentlist sendContentlist = new Contentlist();
                                sendContentlist.setHtml(mContentlistList.get(position).getHtml());
                                sendContentlist.setSource(mContentlistList.get(position).getSource());
                                sendContentlist.setPubDate(mContentlistList.get(position).getPubDate());
                                sendContentlist.setTitle(mContentlistList.get(position).getTitle());
                                intent.putExtra("sendContentlist", (Serializable) sendContentlist);
                                startActivity(intent);
                            }
                        });
                    }
                }

            }


        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                requestDataByGet();
                handler.sendEmptyMessage(1);
            }
        }).start();

        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    public String streamToString(InputStream is) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            baos.close();
            is.close();
            byte[] byteArray = baos.toByteArray();
            return new String(byteArray);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }
    private void requestDataByGet() {
        String appid="91287";//要替换成自己的
        String secret="aece97a8085e42f398fa0f39ff8d2cea";//要替换成自己的
        String channelName = "娱乐最新";
        try {
            URL url = new URL("https://route.showapi.com/109-35?channelId=&channelName="+channelName+"&id=&maxResult=20&needAllList=0&needContent=0&needHtml=1&page=1&showapi_appid="+appid+"&showapi_timestamp=&title=&showapi_sign="+secret);
            Log.d(TAG, "requestDataByGet: url="+url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(30*1000);
            connection.setRequestMethod("GET");
            connection.connect();
            int responCode = connection.getResponseCode();
            if (responCode == HTTP_OK){
                InputStream inPutStream = connection.getInputStream();
                jsonString=streamToString(inPutStream);
                Log.d(TAG, "requestDataByGet: 请求到json数据 jsonString="+jsonString);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void handleJsonData(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString); //获得整个json对象
            Log.d(TAG, "handleJsonData: 获得了整个json对象"+jsonObject);
            showapi_res_code=jsonObject.getInt("showapi_res_code");
            showapi_res_error=jsonObject.getString("showapi_res_error");
            JSONArray contentlist =jsonObject.getJSONObject("showapi_res_body").getJSONObject("pagebean").getJSONArray("contentlist");
            mContentlistList = new ArrayList<>();

            if (contentlist!=null &&contentlist.length()>0){
                for (int index = 0;index<contentlist.length();index++){
                    Log.d(TAG, "handleJsonData: 进入循环");
                    JSONObject everyNewsObject= (JSONObject) contentlist.get(index);
                    String pubDate = everyNewsObject.getString("pubDate");
                    String link= everyNewsObject.getString("link");
                    String id = everyNewsObject.getString("id");
                    Boolean havePic = everyNewsObject.getBoolean("havePic");
                    String title = everyNewsObject.getString("title");
                    String source = everyNewsObject.getString("source");
                    String html = everyNewsObject.getString("html");
                    //每个contenlist中的图片对象
                    JSONArray imageurls = everyNewsObject.getJSONArray("imageurls");
                    mImageurlsList = new ArrayList<>();
                    if (imageurls!= null &&imageurls.length()>0){
                        for (int i=0 ;i<imageurls.length();i++){
                            JSONObject everyNewsImageUrlObject = (JSONObject) imageurls.get(i);
                            String url = everyNewsImageUrlObject.getString("url");
                            int height = everyNewsImageUrlObject.getInt("height");
                            int width = everyNewsImageUrlObject.getInt("width");
                            Imageurls imageurlsItem = new Imageurls();
                            imageurlsItem.setHeight(height);
                            imageurlsItem.setWidth(width);
                            imageurlsItem.setUrl(url);
                            mImageurlsList.add(imageurlsItem);
                        }
                    }else {

                    }

                    Contentlist contentlistItem = new Contentlist();
                    contentlistItem.setPubDate(pubDate);
                    contentlistItem.setLink(link);
                    contentlistItem.setId(id);
                    contentlistItem.setTitle(title);
                    contentlistItem.setHavePic(havePic);
                    contentlistItem.setSource(source);
                    contentlistItem.setHtml(html);
                    contentlistItem.setImageurls(mImageurlsList);
                    mContentlistList.add(contentlistItem);
                }
                Log.d(TAG, "handleJsonData: 总的"+mContentlistList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, "handleJsonData: 解析出错！！");
        }
    }

}
