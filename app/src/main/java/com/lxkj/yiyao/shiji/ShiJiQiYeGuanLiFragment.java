package com.lxkj.yiyao.shiji;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.shengji.adapter.CompanyInfoListAdapter;
import com.lxkj.yiyao.view.RefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/19.
 */

public class ShiJiQiYeGuanLiFragment extends BaseFragment {

    // ======================== 模板代码=============================

    CompanyInfoListAdapter adapter;
    @BindView(R.id.list_view)
    RefreshListView listView;
    @BindView(R.id.select)
    TextView select;
    @BindView(R.id.sousuoxinxi)
    EditText sousuoxinxi;
    private int page = 1;

    private String TAG = "ShiJiQiYeGuanLiFragment";


    @Override
    protected void initView() {
        requestData();

        listView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onDownPullRefresh() {


                adapter.clear();
                adapter.notifyDataSetChanged();
                page = 1;


                requestData();


            }

            @Override
            public void onLoadingMore() {


                requestData();


            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.clear();
                adapter.notifyDataSetChanged();
                page = 1;
                requestData();
            }
        });

    }
    // ======================== 模板代码=============================


    // ======================== 模板代码=============================
    public void requestData() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shiyao", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.shiji_qygl);
        params.addBodyParameter("page", page + "");
        params.addBodyParameter("username", "" + username);
        params.addBodyParameter("xx", sousuoxinxi.getText() + "");


        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (adapter == null) {
                    JSONObject jsonObject = JSONObject.parseObject(result);
                    String data = jsonObject.getString("data");
                    adapter = new CompanyInfoListAdapter(data);
                    listView.setAdapter(adapter);
                } else {
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


    @Override
    public int getLayout() {
        return R.layout.sjgr_fragment_layout_person_qiye_info_list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
