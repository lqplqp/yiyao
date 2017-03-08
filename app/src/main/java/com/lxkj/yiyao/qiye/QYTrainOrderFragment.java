package com.lxkj.yiyao.qiye;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.CompanyManagerAdapter;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.qiye.adapter.QYTrainOrderAdapter;
import com.lxkj.yiyao.view.RefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/19.
 */

public class QYTrainOrderFragment extends BaseFragment {
    private static final String TAG = "QYTrainOrderFragment";
    @BindView(R.id.rb_1)
    RadioButton rb1;
    @BindView(R.id.rb_2)
    RadioButton rb2;
    @BindView(R.id.rb_3)
    RadioButton rb3;
    @BindView(R.id.rb_4)
    RadioButton rb4;

    // ======================== 模板代码=============================

    MBaseAdapter adapter;
    @BindView(R.id.list_view)
    RefreshListView listView;
    private int page = 1;


    @Override
    protected void initView() {

        init();


        requestData(null , 0);


        listView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onDownPullRefresh() {


                adapter.clear();
                adapter.notifyDataSetChanged();
                page = 1;


                requestData(null , 0);


            }

            @Override
            public void onLoadingMore() {


                requestData(null , 0);


            }
        });


    }
    // ======================== 模板代码=============================


    // ======================== 模板代码=============================
    public void requestData(String s , int tab) {
        RequestParams params = null;
        if(tab == 1 || tab ==0){
            params = new RequestParams(GlobalString.BaseURL + GlobalString.qiye_quanbudingdan);
        }
        if(tab == 2){
            params = new RequestParams(GlobalString.BaseURL + GlobalString.qiye_daifukuan);
        }
        if(tab ==3){
            params = new RequestParams(GlobalString.BaseURL + GlobalString.qiye_yifukuan);
        }
        if(tab == 4){
            params = new RequestParams(GlobalString.BaseURL + GlobalString.qiye_yiquxiao);
        }

        params.addBodyParameter("page", page + "");



        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if (adapter == null) {
                    adapter = new QYTrainOrderAdapter(result);
                    listView.setAdapter(adapter);
                } else {
                    listView.setAdapter(adapter);
                    adapter.addData(result);
                    listView.deferNotifyDataSetChanged();
                }
                page++;

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                ex.printStackTrace();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                listView.onRefreshComplete();
                listView.loadMoreComplete();
            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }


    // ======================== 模板代码=============================

    private void hide() {
        rb1.setChecked(false);
        rb2.setChecked(false);
        rb3.setChecked(false);
        rb4.setChecked(false);
        rb1.setBackgroundResource(R.drawable.fillet_white_bg);
        rb2.setBackgroundResource(R.drawable.fillet_white_bg);
        rb3.setBackgroundResource(R.drawable.fillet_white_bg);
        rb4.setBackgroundResource(R.drawable.fillet_white_bg);
    }

    @Override
    public int getLayout() {
        return R.layout.qy_fragment_layout_train_order;
    }


    void init() {
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
                requestData(null , 1);
                rb1.setBackgroundResource(R.drawable.blue_but_bg);
                rb1.setTextColor(getResources().getColor(R.color.white));
                rb2.setTextColor(getResources().getColor(R.color.global_black));
                rb3.setTextColor(getResources().getColor(R.color.global_black));
                rb4.setTextColor(getResources().getColor(R.color.global_black));
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
                rb2.setBackgroundResource(R.drawable.blue_but_bg);
                rb2.setTextColor(getResources().getColor(R.color.white));
                rb1.setTextColor(getResources().getColor(R.color.global_black));
                rb3.setTextColor(getResources().getColor(R.color.global_black));
                rb4.setTextColor(getResources().getColor(R.color.global_black));
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
                rb3.setBackgroundResource(R.drawable.blue_but_bg);
                rb3.setTextColor(getResources().getColor(R.color.white));
                rb2.setTextColor(getResources().getColor(R.color.global_black));
                rb1.setTextColor(getResources().getColor(R.color.global_black));
                rb4.setTextColor(getResources().getColor(R.color.global_black));
            }
        });
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
                rb4.setBackgroundResource(R.drawable.blue_but_bg);
                rb4.setTextColor(getResources().getColor(R.color.white));
                rb2.setTextColor(getResources().getColor(R.color.global_black));
                rb3.setTextColor(getResources().getColor(R.color.global_black));
                rb1.setTextColor(getResources().getColor(R.color.global_black));
            }
        });
    }



}
