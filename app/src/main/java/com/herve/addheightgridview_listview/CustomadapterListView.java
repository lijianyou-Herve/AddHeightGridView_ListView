package com.herve.addheightgridview_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Herve on 2016/1/8.
 */
public class CustomadapterListView extends BaseAdapter {

    private List<String> data = new ArrayList<>();
    private Context context;

    public CustomadapterListView() {
    }

    public CustomadapterListView(List<String> data) {
        this.data = data;
    }

    public CustomadapterListView(Context context, List<String> data) {
        this.data = data;
        this.context = context;
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

        convertView = LayoutInflater.from(context).inflate(R.layout.item_comment, null);
        TextView tv_user = (TextView) convertView.findViewById(R.id.tv_user);
        TextView tv_comment = (TextView) convertView.findViewById(R.id.tv_comment);



        if (position % 5 == 0)
            tv_comment.setText("佩兰在广东");
        if (position % 5 == 1)
            tv_comment.setText("2014年2月的最后一天，佩兰在广东，他的合同自动延续到2018年世界杯预选赛结束");
        if (position % 5 == 2)
            tv_comment.setText("2014年2月的最后一天，佩兰在广东，他的合同自动延续到2018年世界杯预选赛结束2014年2月的最后一天，佩兰在广东，他的合同自动延续到2018年世界杯预选赛结束");
        if (position % 5 == 3)
            tv_comment.setText("2014年2月的最后一天，佩兰在广东，");
        if (position % 5 == 5)
            tv_comment.setText("佩兰在广东2014年2月的最后一天，佩兰在广东，他的合同自动延续到2018年世界杯预选赛结束预选赛结束");


        return convertView;
    }
}
