package com.lxkj.yiyao.shengjugeren;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.shengjugeren.Adapter.SJGRDownloadDocAdapter;
import com.lxkj.yiyao.view.RefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/1/19.
 */

public class SJGRDownloadDocFragment2 extends BaseFragment {

    @BindView(R.id.list_view)
    RefreshListView listView;

    private MBaseAdapter adapter;

    @Override
    protected void initView() {


        requestDate();

    }

    private void requestDate() {

        RequestParams params = new RequestParams(GlobalString.BaseURL + "/admin/fenji1/yymb");
        params.addBodyParameter("type",2 + "");

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                adapter = new SJGRDownloadDocAdapter(result);

                listView.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    @Override
    public int getLayout() {
        return R.layout.sjgr_fragment_layout_download_doc;
    }


}
