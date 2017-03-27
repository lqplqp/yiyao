package com.lxkj.yiyao.gerenyonghu;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.gerenyonghu.Adapter.GeRenYongHuWenDangXiaZaiAdapter;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.view.RefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/3/16.
 */

public class GeRenYongYingYongChaJianXiaZaiFragment extends BaseFragment {
    @BindView(R.id.list_view)
    RefreshListView listView;
    Unbinder unbinder;

    private MBaseAdapter adapter;
    @Override
    protected void initView() {
        requestDate();
    }

    private void requestDate() {

        RequestParams params = new RequestParams(GlobalString.BaseURL + "/admin/fenji1/yycj");

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                adapter = new GeRenYongHuWenDangXiaZaiAdapter(result);

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
        return R.layout.gerenyonghu_wendangxiazai;
    }

}
