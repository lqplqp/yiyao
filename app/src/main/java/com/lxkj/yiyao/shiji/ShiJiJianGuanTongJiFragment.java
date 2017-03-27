package com.lxkj.yiyao.shiji;

import android.util.Log;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.shengji.adapter.JianGuanDanWeiTongJiAdapter;
import com.lxkj.yiyao.view.RefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/1/19.
 */

public class ShiJiJianGuanTongJiFragment extends BaseFragment {

    // ======================== 模板代码=============================

    JianGuanDanWeiTongJiAdapter adapter;
    @BindView(R.id.list_view)
    RefreshListView listView;
    private int page = 1;

    private String TAG = "JianGuanTongJiFragment";


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


    }
    // ======================== 模板代码=============================


    // ======================== 模板代码=============================
    public void requestData() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.fenji1_tzxx);
        params.addBodyParameter("page", page + "");

        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if (adapter == null) {
                    adapter = new JianGuanDanWeiTongJiAdapter(result);
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


    @Override
    public int getLayout() {
        return R.layout.shengji_fragment_layout_jianguantongji;
    }

}
