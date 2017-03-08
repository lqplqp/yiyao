package com.lxkj.yiyao.shiji;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.shiji.adapter.AdminManagerAdapter;
import com.lxkj.yiyao.view.RefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class AdminManagerFragment extends BaseFragment {

    public String TAG = this.getClass().getSimpleName();
    @BindView(R.id.chaxun)
    TextView chaxun;
    @BindView(R.id.souguoneirong)
    EditText souguoneirong;
    @BindView(R.id.start_time)
    TextView startTime;
    @BindView(R.id.end_time)
    TextView endTime;
    @BindView(R.id.add)
    TextView add;
    @BindView(R.id.list_view)
    RefreshListView listView;
    Unbinder unbinder;


    // ======================== 模板代码=============================


    MBaseAdapter adapter;
    private int page = 1;


    @Override
    protected void initView() {

        requestData(null, null, null);


        listView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onDownPullRefresh() {


                adapter.clear();
                adapter.notifyDataSetChanged();
                page = 1;


                requestData(null, null, null);


            }

            @Override
            public void onLoadingMore() {


                requestData(null, null, null);


            }
        });


    }
    // ======================== 模板代码=============================


    // ======================== 模板代码=============================
    public void requestData(String xx, String sj1, String sj2) {
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.shiji_jgrygl);
        params.addBodyParameter("page", page + "");
        if (xx != null && sj1 != null && sj2 != null) {
            params.addBodyParameter("xx", xx);
            params.addBodyParameter("sj1", sj1);
            params.addBodyParameter("sj2", sj2);
        }

        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if (adapter == null) {
                    adapter = new AdminManagerAdapter(result);
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
        return R.layout.shiji_fragment_layout_jianguanmanager;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.chaxun, R.id.start_time, R.id.end_time, R.id.add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.chaxun:
                break;
            case R.id.start_time:
                break;
            case R.id.end_time:
                break;
            case R.id.add:
                break;
        }
    }
}
