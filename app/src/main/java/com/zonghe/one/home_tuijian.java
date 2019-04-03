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
import android.widget.Toast;

import com.youth.banner.BannerConfig;
import com.zonghe.one.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class home_tuijian extends Fragment  {
    private static String TAG="home_yuijian";
    private static bottom_fragment_home context;
    View view;
    Banner tuijian_banner;
    private String mResult;
    private List<NewsResult.News> newsList;
    private RecyclerView mRecyclerView;
    private NewsListAdapter mNewsListAdapter;

    public static home_tuijian createFragment(bottom_fragment_home home_tj){
        context = home_tj;
        return new home_tuijian();
    }
    @Override
    @Nullable
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState){
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
        //蒋recyclerView开始

        findViews();
//主线程创建Handler，接收子线程的信息。
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    handleJsonData(mResult);
                    mNewsListAdapter=new NewsListAdapter(container,newsList);
                    mRecyclerView.setAdapter(mNewsListAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(container.getContext(),LinearLayoutManager.VERTICAL,false));
                    mNewsListAdapter.setOnItemClickListener(new NewsListAdapter.onItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            Intent intent = new Intent(container.getContext(),NewsDetailActivity.class);
                            intent.putExtra("NewsURL",newsList.get(position).getURL());
                            startActivity(intent);
                        }
                    });
                }
            }
        };
        //子线程处理耗时任务： 连接网络获取json；
        new Thread(new Runnable() {
            @Override
            public void run() {
                requestDataByGet();

                Log.d(TAG, "run: 从网上获得json数据="+mResult);
                //完成下载json后通知主线程去解析。
                handler.sendEmptyMessage(1);
            }
        }).start();



        //蒋recyclerview结尾

        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    private void findViews() {
        mRecyclerView =view.findViewById(R.id.RecyclerView_News);

    }

    private void requestDataByGet() {
        try {
            URL url = new URL("http://v.juhe.cn/toutiao/index?type=shehui&key=18863045453569167f499c366196d7e5");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(30 * 1000);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Charset", "UTF-8");
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.connect();

            int responCode = connection.getResponseCode();
            Log.d(TAG, "requestDataByGet: 返回码 responCode="+responCode);
            String responMessage = connection.getResponseMessage();
            if (responCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                mResult = streamToString(inputStream);
                Log.d(TAG, "requestDataByGet: 获得了jsonle嘛+"+mResult);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void handleJsonData(String result) {
        NewsResult mNewsResult = new NewsResult();
        try {

            JSONObject jsonObject = new JSONObject(result);
            JSONObject jsonObject_result = jsonObject.getJSONObject("result");
            Log.d(TAG, "handleJsonData: jsonObject_result=" + jsonObject_result);
            JSONArray news = jsonObject_result.getJSONArray("data");
            Log.d(TAG, "handleJsonData: jsoArray('data')" + news);
            Log.d(TAG, "handleJsonData: new.length" + news.length());
            newsList = new ArrayList<>();

            int stat = jsonObject_result.getInt("stat");

            mNewsResult.setStat(stat);


            if (news != null && news.length() > 0) {
                for (int index = 0; index < news.length(); index++) {
                    JSONObject everyNews = (JSONObject) news.get(index);
                    Log.d(TAG, "handleJsonData: firstNews" + everyNews);

                    String mUniquekey = everyNews.getString("uniquekey");

                    String mTitle = everyNews.getString("title");
                    Log.d(TAG, "handleJsonData: mtitle " + mTitle);
                    String mDate = everyNews.getString("date");
                    String mCategory = everyNews.getString("category");
                    String mAuthor_name = everyNews.getString("author_name");
                    String mURL = everyNews.getString("url");
                    String mThumbnail_pic_s = everyNews.getString("thumbnail_pic_s");
                    try {
                        String mThumbnail_pic_s02 = everyNews.getString("thumbnail_pic_s01");
                        String mThumbnail_pic_s03 = everyNews.getString("thumbnail_pic_s02");
                    } catch (Exception e) {
                        String mThumbnail_pic_s02 = null;
                        String mThumbnail_pic_s03 = null;
                    }

                    NewsResult.News NewsItem = new NewsResult.News();
                    NewsItem.setMuniquekey(mUniquekey);
                    NewsItem.setTitle(mTitle);
                    NewsItem.setDate(mDate);
                    NewsItem.setCategory(mCategory);
                    NewsItem.setAuthor_name(mAuthor_name);
                    NewsItem.setURL(mURL);
                    NewsItem.setThumbnail_pic_s(mThumbnail_pic_s);

                    newsList.add(NewsItem);
                }
                mNewsResult.setNews(newsList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
}


