package com.herve.addheightgridview_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Herve on 2016/1/8.
 */
public class CustomadapterGridView extends BaseAdapter {

    private Context context;
    private List<String> data = new ArrayList<>();
    //判断加载哪一个图片加载
    private boolean flag = false;


    public CustomadapterGridView(Context context, List<String> data) {
        this.data = data;
        this.context = context;
    }

    public CustomadapterGridView(Context context, List<String> data, boolean flag) {
        this.context = context;
        this.data = data;
        this.flag = flag;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
        final ImageView iv_film_logo = (ImageView) convertView.findViewById(R.id.iv_film_logo);

        //加载地三个位置的Imageview为查看更多
        if (position == 3) {
            //若是是True,就加载点击的浏览更多图片
            if (flag) {
                Glide.with(context).load(R.drawable.community_details_more_selected).into(iv_film_logo);
            } else {
                Glide.with(context).load(R.drawable.community_details_more_selected_touch).into(iv_film_logo);
            }

            convertView.setTag(iv_film_logo);
        } else {
            //其他的用户头像，后期可以通过data来设置
            Glide.with(context).load(R.drawable.image2).into(iv_film_logo);
        }

        return convertView;
    }
}
