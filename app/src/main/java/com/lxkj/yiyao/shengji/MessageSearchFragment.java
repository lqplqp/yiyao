package com.lxkj.yiyao.shengji;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.shengji.adapter.MessageSearchAdapter;
import com.lxkj.yiyao.view.RefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/19.
 */

public class MessageSearchFragment extends BaseFragment {

    // ======================== 模板代码=============================

    MessageSearchAdapter adapter;
    @BindView(R.id.list_view)
    RefreshListView listView;
    @BindView(R.id.chaxun)
    TextView chaxun;
    @BindView(R.id.faqidanwei)
    EditText faqidanwei;
    @BindView(R.id.peixuntongzhileixing)
    Spinner peixuntongzhileixing;
    @BindView(R.id.xingzhengleixing)
    Spinner xingzhengleixing;
    @BindView(R.id.peixunbanleixing)
    Spinner peixunbanleixing;
    private int page = 1;

    private String TAG = "CompanyManageyFragment";


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
        RequestParams params = new RequestParams("http://af.0101hr.com/admin/fenji1/tzxx");
        params.addBodyParameter("page", page + "");

        params.addBodyParameter("fqdw",faqidanwei.getText().toString());
        params.addBodyParameter("pxtzlx" , peixuntongzhileixing.getSelectedItem().toString());
        params.addBodyParameter("hylx",xingzhengleixing.getSelectedItem().toString());
        params.addBodyParameter("pxblx",peixunbanleixing.getSelectedItem().toString());
        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if (adapter == null) {
                    adapter = new MessageSearchAdapter(result);
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
        return R.layout.sjgr_fragment_layout_message_search;
    }


    @OnClick(R.id.chaxun)
    public void onClick() {
    }
}
