package com.lxkj.yiyao.tijian;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.tijian.adapter.TiJianListAdapter;
import com.lxkj.yiyao.utils.SPUtil;
import com.lxkj.yiyao.view.RefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liqinpeng on 2017/5/1 0001.
 *
 * @author 李秦鹏
 *         -------------------------------
 */

public class TiJianListFragment extends BaseFragment {


    @BindView(R.id.list_view)
    RefreshListView listView;

    @Override
    protected void initView() {
        requestData();
    }


    void requestData(){
        RequestParams params = new RequestParams("http://af.0101hr.com/index.php/admin/tjgl/tjlist");
        params.addBodyParameter("username", SPUtil.getUserName(getContext()));
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                TiJianListAdapter tiJianListAdapter = new TiJianListAdapter(result);
                listView.setAdapter(tiJianListAdapter);
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

            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.tijian_list;
    }



}
