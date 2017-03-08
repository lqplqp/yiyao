package com.lxkj.yiyao.shiji;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.shiji.adapter.PeiXunListAdapter;
import com.lxkj.yiyao.view.RefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class PeiXunListFragment extends BaseFragment {

    public String TAG = this.getClass().getSimpleName();

    @BindView(R.id.list_view)
    RefreshListView listView;
    Unbinder unbinder;

    // ======================== 模板代码=============================

    MBaseAdapter adapter;
    private int page = 1;


    @Override
    protected void initView() {

        requestData(null);


        listView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onDownPullRefresh() {


                adapter.clear();
                adapter.notifyDataSetChanged();
                page=1;


                requestData(null);


            }

            @Override
            public void onLoadingMore() {


                requestData(null);



            }
        });


    }
    // ======================== 模板代码=============================





    // ======================== 模板代码=============================
    public void requestData(String s){
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.shiji_pxtzgl);
        params.addBodyParameter("page",page+"");
        if(s!=null){
            params.addBodyParameter("cx",s);
        }

        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if(adapter == null){
                    adapter = new PeiXunListAdapter(result);
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
        return R.layout.shiji_fragment_layout_yibao_peixun_list;
//        return R.layout.qymanager_fragment_layout_select_train;
    }

}
