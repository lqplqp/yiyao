package com.lxkj.yiyao.shengji;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.activity.SelectTrainActivity;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.bean.ShengJiHomeBean;
import com.lxkj.yiyao.jianguan.AddAdminActivity;
import com.lxkj.yiyao.shengji.adapter.ShengJiHomeAdapter;
import com.lxkj.yiyao.view.RefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class HomeFragment extends BaseFragment {



    @BindView(R.id.select_project)
    TextView selectProject;
    @BindView(R.id.add_people)
    TextView addPeople;

    ShengJiHomeBean homeBean;
    @BindView(R.id.xuexizhongshu1)
    TextView xuexizhongshu1;
    @BindView(R.id.yiwanchengshu1)
    TextView yiwanchengshu1;
    @BindView(R.id.xuexizhongshu2)
    TextView xuexizhongshu2;
    @BindView(R.id.xuexizhong2)
    TextView xuexizhong2;
    @BindView(R.id.yiwanchengshu2)
    TextView yiwanchengshu2;
    @BindView(R.id.yiwancheng2)
    TextView yiwancheng2;
    @BindView(R.id.xuexizhong1)
    TextView xuexizhong1;
    @BindView(R.id.yiwancheng1)
    TextView yiwancheng1;
    @BindView(R.id.list_view)
    RefreshListView listView;


    @Override
    protected void initView() {
        requestData();
    }

    private void requestData() {

        RequestParams params = new RequestParams("http://af.0101hr.com/admin/fenji1/sy");

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                homeBean = gson.fromJson(result, ShengJiHomeBean.class);
                flushView();
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

    private void flushView() {
        xuexizhongshu1.setText(homeBean.getJgxxz() + "");
        yiwanchengshu1.setText(homeBean.getJgywc() + "" );
        xuexizhongshu2.setText(homeBean.getPxxmxxz()+ "" );
        yiwanchengshu2.setText(homeBean.getPxxmywc() + "");

        ShengJiHomeAdapter adapter = new ShengJiHomeAdapter(homeBean.getData());
        listView.setAdapter(adapter);

    }

    @Override
    public int getLayout() {
        return R.layout.sj_fragment_layout_home;
    }


    /**
     * 点击选择项目
     */
    private void clickSelectProject() {
        toast("选择项目");
    }


    @OnClick({R.id.add_people, R.id.select_project})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.add_people:
                intent = new Intent(getActivity(), AddAdminActivity.class);
                startActivity(intent);
                Log.d("123", "213");
                break;
            case R.id.select_project:
                intent = new Intent(getActivity(), SelectTrainActivity.class);
                intent.putExtra("qiye_admin", true);
                startActivity(intent);
                break;
        }
    }




}
