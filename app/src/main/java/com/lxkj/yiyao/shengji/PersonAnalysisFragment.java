package com.lxkj.yiyao.shengji;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.shengji.adapter.PersonAnalysisAdapter;
import com.lxkj.yiyao.utils.PickViewUtils;
import com.lxkj.yiyao.view.RefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/1/19.
 */

public class PersonAnalysisFragment extends BaseFragment {
// ======================== 模板代码=============================

    PersonAnalysisAdapter adapter;

    Unbinder unbinder;
    @BindView(R.id.chaxun)
    TextView chaxun;
    @BindView(R.id.diqu)
    TextView diqu;
    @BindView(R.id.list_view)
    RefreshListView listView;
    Unbinder unbinder1;
    private int page = 1;

    private String TAG = "PersonAnalysisFragment";


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
        chaxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestData();
            }
        });


    }
    // ======================== 模板代码=============================


    // ======================== 模板代码=============================
    public void requestData() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.fenji1_gryhtjfx);
        params.addBodyParameter("page", page + "");

        SharedPreferences sp = getActivity().getSharedPreferences("shiyao", getActivity().MODE_PRIVATE);
        params.addBodyParameter("username", sp.getString("username", "") + "");

        String[] sanji = diqu.getText().toString().split("-");

        params.addBodyParameter("sq", sanji[1]);
        params.addBodyParameter("xq", sanji[2]);

        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if (adapter == null) {
                    adapter = new PersonAnalysisAdapter(result);
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
        return R.layout.sjgr_fragment_layout_person_analysis;
    }


    @OnClick({R.id.chaxun, R.id.diqu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.chaxun:
                if (adapter != null) {
                    adapter.clear();
                    adapter.notifyDataSetChanged();
                    page = 1;
                }
                requestData();

                break;
            case R.id.diqu:
                new PickViewUtils(getActivity(), diqu).pickProvince();

                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }
}
