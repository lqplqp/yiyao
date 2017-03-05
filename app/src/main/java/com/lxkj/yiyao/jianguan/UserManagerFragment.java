package com.lxkj.yiyao.jianguan;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.CompanyManagerAdapter;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.jianguan.adapter.UserManagerAdapter;
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

public class UserManagerFragment extends BaseFragment {
    private static final String TAG = "UserManagerFragment";
    @BindView(R.id.select)
    TextView select;
    @BindView(R.id.imput_name)
    EditText imputName;
    ImageView cx;
    @BindView(R.id.tj)
    ImageView tj;
    @BindView(R.id.list_view)
    RefreshListView listView;


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
                page = 1;


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
    public void requestData(String s) {
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.jg_gryhgl);
        params.addBodyParameter("page", page + "");
        if (s != null) {
            params.addBodyParameter("cx", s);
        }

        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if (adapter == null) {
                    adapter = new UserManagerAdapter(result);
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


    @Override
    public int getLayout() {
        return R.layout.jg_fragment_layout_usermanager;
    }

    @OnClick(R.id.select)
    public void onClick() {
        toast("查询");
        if(adapter!=null){
            adapter.clear();
            adapter.notifyDataSetChanged();
            page=1;
        }
        requestData(imputName.getText().toString());

    }

}
