package com.lxkj.yiyao.shengjugeren;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.shengjugeren.Adapter.SJGRPersonAnalysisAdapter;
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

public class SJGRPersonAnalysisFragment extends BaseFragment {
    public String TAG = this.getClass().getSimpleName();

    @BindView(R.id.chaxun)
    TextView chaxun;
    @BindView(R.id.shiqu)
    Spinner shiqu;
    @BindView(R.id.xianqu)
    Spinner xianqu;
    @BindView(R.id.list_view)
    RefreshListView listView;
    Unbinder unbinder;

    // ======================== 模板代码=============================

    MBaseAdapter adapter;
    private int page = 1;

    private View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView == null) {
            rootView = super.onCreateView(inflater, container, savedInstanceState);
            return rootView;
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }
    @Override
    protected void initView() {

        requestData("","");


        listView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onDownPullRefresh() {


                adapter.clear();
                adapter.notifyDataSetChanged();
                page=1;


                requestData("","");


            }

            @Override
            public void onLoadingMore() {


                requestData("","");



            }
        });


    }
    // ======================== 模板代码=============================





    // ======================== 模板代码=============================
    public void requestData(String sq,String xq){
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.shiji_gryhtjfx);
        params.addBodyParameter("page",page+"");
        if(sq!=null && xq!=null){
            params.addBodyParameter("sq",sq);
            params.addBodyParameter("xq",xq);
        }

        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if(adapter == null){
                    adapter = new SJGRPersonAnalysisAdapter(result);
                    listView.setAdapter(adapter);
                }else{
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

    @OnClick(R.id.chaxun)
    public void onClick() {
        toast("查询");
        // TODO: 2017/1/18
        if(adapter!=null){
            adapter.clear();
            adapter.notifyDataSetChanged();
            page=1;
        }
        requestData("","");
    }
}
