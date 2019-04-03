package com.zonghe.one;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zonghe.one.bottom_fragment_home;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.itemViewHolder> {
    private List<NewsResult.News> mNewsList;
    private ViewGroup mContext;
    private onItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
    public NewsListAdapter(ViewGroup mContext, List<NewsResult.News> mNewsList) {
        this.mContext= mContext;
        this.mNewsList = mNewsList;
    }

    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View itemView = View.inflate(mContext.getContext(),R.layout.item,null);

        return new itemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder itemViewHolder, final int i) {
        final NewsResult.News everyNews = mNewsList.get(i);
        final Bitmap[] bitmap = new Bitmap[1];
        itemViewHolder.TV_title.setText(everyNews.getTitle());
        itemViewHolder.TV_Author_name.setText(everyNews.getAuthor_name());
        //使用Glide 来加载网络图片。。
        Glide.with(mContext).load(everyNews.getThumbnail_pic_s()).into(itemViewHolder.IM_Thumbnail_pic_s);

        itemViewHolder.mitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用接口的回调方法
                if (mOnItemClickListener!=null){
                    mOnItemClickListener.onItemClick(i);

                }
            }
        });

    }


    class itemViewHolder extends RecyclerView.ViewHolder{
        private TextView TV_title;
        private TextView TV_Author_name;
        private ImageView IM_Thumbnail_pic_s;
        View mitemView;

        public itemViewHolder(@NonNull View itemView) {
            super(itemView);
            TV_title = itemView.findViewById(R.id.TV_tital);
            TV_Author_name=itemView.findViewById(R.id.TV_author_name);
            IM_Thumbnail_pic_s = itemView.findViewById(R.id.IV_thumbnail_pic_s);
            mitemView=itemView;
        }
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }
    /**
     * 定义点击item事件的回调接口
     */


    interface onItemClickListener{
        //回调方法
        void onItemClick(int position);
    }
}
