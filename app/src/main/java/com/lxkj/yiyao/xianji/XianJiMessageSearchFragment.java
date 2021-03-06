package com.lxkj.yiyao.xianji;

import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.qiye.adapter.QYMessageSearchAdapter;
import com.lxkj.yiyao.view.RefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/19.
 */

public class XianJiMessageSearchFragment extends BaseFragment {
    private static final String TAG = "QYMessageSearchFragment";
    @BindView(R.id.select)
    TextView select;
    @BindView(R.id.company)
    EditText company;
    @BindView(R.id.message_type)
    Spinner messageType;
    @BindView(R.id.administrative_type)
    Spinner administrativeType;
    @BindView(R.id.train_type)
    Spinner trainType;

    // ======================== 模板代码=============================

    MBaseAdapter adapter;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.list_view)
    RefreshListView listView;
    private int page = 1;


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
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.qiye_tongzhixiaoxi);
        params.addBodyParameter("page", page + "");




        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if (adapter == null) {
                    adapter = new QYMessageSearchAdapter(result);
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
        return R.layout.xianji_fragment_layout_message_search;
    }


    @OnClick(R.id.select)
    public void onClick() {
        toast("查询");// TODO: 2017/1/19
        requestData();
    }


}
