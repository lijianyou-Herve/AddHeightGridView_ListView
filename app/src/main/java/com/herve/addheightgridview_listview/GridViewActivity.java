package com.herve.addheightgridview_listview;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {

    CustomGridView moreItemsGridView;
    CustomadapterGridView customadapter;
    LinearLayout ll_add_more;
    //每行的个数
    int column = 4;
    //点击一次添加的个数
    int addNum=8;
    //默认恢复到原始的个数
    int defaNum=4;
    List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        initUI();
        initdata();
        initListener();


    }

    private void initListener() {

        moreItemsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 3) {
                    if (ll_add_more.getVisibility() == View.GONE) {
                        //加载出来addNum个图片
                        updateView(addNum);
                        ll_add_more.setVisibility(View.VISIBLE);
                    } else {

                        //置空，重新装填原始的4个图片
                        data = new ArrayList<String>();
                        updateView(4);
                        ll_add_more.setVisibility(View.GONE);

                    }

                }

            }
        });

        ll_add_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //增加出来addNum个图片
                updateView(addNum);
            }
        });
    }

    private void initdata() {
        //初始化图片，原始看到的图片，如果值小于4，大于则出现加载更多的按钮，会自动变成居中，GridView的 numColum
        data = new ArrayList<>();
        updateView(4);

    }

    private void initUI() {
        moreItemsGridView = (CustomGridView) findViewById(R.id.moreItemsGridView);
        moreItemsGridView.setSelector(new ColorDrawable(Color.TRANSPARENT));


        ll_add_more = (LinearLayout) findViewById(R.id.ll_add_more);

    }


    //刷新列表
    private void updateView(int count) {
        boolean isMore = false;

        for (int i = 0; i < count; i++) {

            data.add("2");

        }


        //如果大于4个，则显示
        if (count > column) {
            isMore = true;
            moreItemsGridView.setNumColumns(column);

        } else {
            moreItemsGridView.setNumColumns(count);
        }


        //
        customadapter = new CustomadapterGridView(GridViewActivity.this, data, isMore);

        moreItemsGridView.setAdapter(customadapter);
        moreItemsGridView.requestLayout();
        add();
    }


    //自动增加高度的方法
    public void add() {
        ListAdapter listAdapter = moreItemsGridView.getAdapter();

        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;

        for (int i = 0; i < listAdapter.getCount(); i += column) {
            View listItem = listAdapter.getView(i, null, moreItemsGridView);

            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = moreItemsGridView.getLayoutParams();

        params.height = totalHeight;

        //增加间隔
//        ((ViewGroup.MarginLayoutParams) params).setMargins(10, 10, 10, 10);
        moreItemsGridView.setLayoutParams(params);
    }
}
