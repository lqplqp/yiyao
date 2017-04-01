package com.lxkj.yiyao.jianguan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.activity.SelectTrainActivity;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.HomeMessageAdapter;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.add_people)
    TextView addPeople;
    @BindView(R.id.select_project)
    TextView selectProject;
    @BindView(R.id.jianguan_xuexizhong)
    TextView jianguanXuexizhong;
    @BindView(R.id.jianguan_yiwancheng)
    TextView jianguanYiwancheng;
    @BindView(R.id.xuanze_xuexizhong)
    TextView xuanzeXuexizhong;
    @BindView(R.id.xuanze_yiwancheng)
    TextView xuanzeYiwancheng;
    @BindView(R.id.list_view)
    ListView listView;
    Unbinder unbinder;

    private MBaseAdapter mBaseAdapter;
    @Override
    protected void initView() {
        requestDate();
    }

    private void requestDate() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + "/admin/fenji/sy");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JSONObject jsonObject = JSONObject.parseObject(result);
                String a = jsonObject.get("data").toString();

                mBaseAdapter = new HomeMessageAdapter(a);
                listView.setAdapter(mBaseAdapter);

                if(jsonObject.get("jgxxz") != null){
                    jianguanXuexizhong.setText(""+jsonObject.get("jgxxz").toString());
                }
                if(jsonObject.get("jgywc") != null){
                    jianguanYiwancheng.setText(""+jsonObject.get("jgywc").toString());
                }
                if(jsonObject.get("pxxmxxz") != null){
                    xuanzeXuexizhong.setText(""+jsonObject.get("pxxmxxz").toString());
                }
                if(jsonObject.get("pxxmywc") != null){
                    xuanzeYiwancheng.setText(""+jsonObject.get("pxxmywc").toString());
                }
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
        return R.layout.jg_fragment_layout_home;
    }


    @OnClick({R.id.add_people, R.id.select_project})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.add_people:
                intent = new Intent(getActivity(), AddAdminActivity.class);
                startActivity(intent);
                break;
            case R.id.select_project:
                intent = new Intent(getActivity(), SelectTrainActivity.class);
                intent.putExtra("qiye_admin", true);
                startActivity(intent);
                break;
        }
    }
}
