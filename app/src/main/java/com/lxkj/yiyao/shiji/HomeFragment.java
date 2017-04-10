package com.lxkj.yiyao.shiji;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.activity.SelectTrainActivity;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.AddAdminActivity;
import com.lxkj.yiyao.shiji.adapter.ShouYeTongZhiXiaoXiAdapter;
import com.lxkj.yiyao.view.ExpandListView;

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
    Unbinder unbinder;
    @BindView(R.id.img_diannao)
    ImageView imgDiannao;
    @BindView(R.id.match_xuexizhong1)
    TextView matchXuexizhong1;
    @BindView(R.id.img_heiban)
    ImageView imgHeiban;
    @BindView(R.id.xuexizhong2)
    TextView xuexizhong2;
    @BindView(R.id.list_view)
    ExpandListView listView;

    @Override
    protected void initView() {
        requestData();
    }

    private void requestData() {
        RequestParams requestParams = new RequestParams(GlobalString.shiji_shouye);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (result != null) {
                    JSONObject jsonObject = JSONObject.parseObject(result);
                    JSONArray jsonArray = JSONArray.parseArray(jsonObject.getString("data"));
                    ShouYeTongZhiXiaoXiAdapter shouYeTongZhiXiaoXiAdapter = new ShouYeTongZhiXiaoXiAdapter(jsonArray);
                    listView.setAdapter(shouYeTongZhiXiaoXiAdapter);

                    String jgxxz = jsonObject.getString("jgxxz");
                    String jgywc = jsonObject.getString("jgywc");
                    String pxxmxxz = jsonObject.getString("pxxmxxz");
                    String pxxmywc = jsonObject.getString("pxxmywc");
                    jianguanXuexizhong.setText("" + jgxxz);
                    jianguanYiwancheng.setText("" + jgywc);
                    xuanzeXuexizhong.setText("" + pxxmxxz);
                    xuanzeYiwancheng.setText("" + pxxmywc);
                }
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
        return R.layout.shiji_fragment_layout_home;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
