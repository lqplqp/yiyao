package com.lxkj.yiyao.jianguan;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.CompanyManagerAdapter;
import com.lxkj.yiyao.view.RefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/18.
 */

public class CompanyManagerFragment extends BaseFragment {

    public String TAG = this.getClass().getSimpleName();

    @BindView(R.id.select)
    TextView select;
    @BindView(R.id.company_name)
    EditText companyName;
    @BindView(R.id.list_view)
    RefreshListView listView;

    CompanyManagerAdapter adapter;


    private int page = 1;

    // ======================== 模板代码=============================
    @Override
    protected void initView() {


        //请求网络获取数据
        requestData();


        listView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onDownPullRefresh() {


                CompanyManagerFragment.this.adapter.clear();
                adapter.notifyDataSetChanged();
                page=1;
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
    public void requestData(){
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.fenji);
        params.addBodyParameter("page",page+"");
        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if(CompanyManagerFragment.this.adapter == null){
                    CompanyManagerFragment.this.adapter = new CompanyManagerAdapter(result);
                    listView.setAdapter(CompanyManagerFragment.this.adapter);
                }else{
                    CompanyManagerFragment.this.adapter.addData(result);
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
        return R.layout.jg_fragment_layout_company_manager;
    }


    @OnClick(R.id.select)
    public void onClick() {
        toast("查询");
        // TODO: 2017/1/18
        requestData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
