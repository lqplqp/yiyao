package com.lxkj.yiyao.shiji;

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
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.shiji.adapter.MessageSearchAdapter;
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

public class MessageSearchFragment extends BaseFragment {
    public String TAG = this.getClass().getSimpleName();

    @BindView(R.id.chaxun)
    TextView chaxun;
    @BindView(R.id.faqidanwei)
    EditText faqidanwei;
    @BindView(R.id.list_view)
    RefreshListView listView;
    Unbinder unbinder;

    // ======================== 模板代码=============================

    MBaseAdapter adapter;
    private int page = 1;


    @Override
    protected void initView() {

        requestData(faqidanwei.getText().toString(),"","","");


        listView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onDownPullRefresh() {


                adapter.clear();
                adapter.notifyDataSetChanged();
                page=1;


                requestData(faqidanwei.getText().toString(),"","","");


            }

            @Override
            public void onLoadingMore() {


                requestData(faqidanwei.getText().toString(),"","","");



            }
        });


    }
    // ======================== 模板代码=============================





    // ======================== 模板代码=============================
    public void requestData(String faqidanwei,String peixuntongzhileixing,String xingzhengleixing,String peixunbanleixing){
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.shiji_tzxx);
        params.addBodyParameter("page",page+"");
        if(faqidanwei!=null){
            params.addBodyParameter("fqdw",faqidanwei);
            params.addBodyParameter("pxtzlx",peixuntongzhileixing);
            params.addBodyParameter("pxblx",peixunbanleixing);
            params.addBodyParameter("xzlx",xingzhengleixing);

        }

        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if(adapter == null){
                    adapter = new MessageSearchAdapter(result);
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
        return R.layout.sjgr_fragment_layout_message_search;
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
        requestData(faqidanwei.getText().toString(),"","","");
    }
}
