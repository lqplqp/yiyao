package com.lxkj.yiyao.xianji;

import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.utils.SPUtil;
import com.lxkj.yiyao.view.RefreshListView;
import com.lxkj.yiyao.xianji.adapter.XianJiWoDeZhengShuAdapter;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/3/16.
 */

public class XianJiYongHuZhengShuFragment extends BaseFragment {
    private static final String TAG = "XianJiYongHuZhengShuFragment";
    @BindView(R.id.rb_1)
    RadioButton rb1;
    @BindView(R.id.rb_2)
    RadioButton rb2;
    @BindView(R.id.list_view)
    RefreshListView listView;
    Unbinder unbinder;
    XianJiWoDeZhengShuAdapter adapter;
    private int page = 1;
    //我的证书是0，过期证书是1
    private int current = 0;

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

    @Override
    public int getLayout() {
        return R.layout.xianjiyonghu_wodezhengshu;
    }


    @OnClick({R.id.rb_1, R.id.rb_2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_1:
                rb1.setBackgroundResource(R.drawable.blue_but_bg);
                rb1.setTextColor(getResources().getColor(R.color.white));
                rb2.setTextColor(getResources().getColor(R.color.global_black));
                rb2.setBackgroundResource(R.drawable.radiobut_color);
                page = 1;
                current = 0;
                requestData();
                break;
            case R.id.rb_2:
                rb2.setBackgroundResource(R.drawable.blue_but_bg);
                rb2.setTextColor(getResources().getColor(R.color.white));
                rb1.setTextColor(getResources().getColor(R.color.global_black));
                rb1.setBackgroundResource(R.drawable.radiobut_color);
                page = 1;
                current = 1;
                requestData();
                break;
        }
    }

    /**
     * 请求我的证书
     */
    private void requestData(){
        RequestParams params = new RequestParams(GlobalString.BaseURL + "/admin/fenji2/wdzsin");
        params.addBodyParameter("page", page + "");
//        params.addBodyParameter("username", "省人1");
        if (current == 1){
            params.addBodyParameter("gq", "1");
        }
        params.addBodyParameter("username", SPUtil.getUserName(getActivity()) + "");
        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if (adapter == null) {
                    adapter = new XianJiWoDeZhengShuAdapter(result);
                    adapter.setContext(getActivity());
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

}
