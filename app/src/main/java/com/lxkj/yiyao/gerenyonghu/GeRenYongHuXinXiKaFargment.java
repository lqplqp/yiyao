package com.lxkj.yiyao.gerenyonghu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.gerenyonghu.Adapter.GeRenYongHuWenDangXiaZaiAdapter;
import com.lxkj.yiyao.global.GlobalString;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/3/16.
 */

public class GeRenYongHuXinXiKaFargment extends BaseFragment {


    @BindView(R.id.bianhao)
    TextView bianhao;
    @BindView(R.id.xingming)
    TextView xingming;
    @BindView(R.id.xingbie)
    TextView xingbie;
    @BindView(R.id.gangwei)
    TextView gangwei;
    @BindView(R.id.dianhuahaoma)
    TextView dianhuahaoma;
    @BindView(R.id.gongzuodanwei)
    TextView gongzuodanwei;
    @BindView(R.id.youxiaoqi)
    TextView youxiaoqi;
    @BindView(R.id.shengchangangwei)
    TextView shengchangangwei;
    @BindView(R.id.fanhui)
    Button fanhui;
    Unbinder unbinder;

    @Override
    protected void initView() {
        TextView username = (TextView) getActivity().findViewById(R.id.user_name);
        String s = username.getText().toString();
        requestDate(s);
    }

    private void requestDate(String s) {

        RequestParams params = new RequestParams(GlobalString.BaseURL + "/admin/fenji6/wdxxk");
        params.addBodyParameter("username", s);

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JSONObject jsonObject = JSONObject.parseObject(result);
                String a = jsonObject.get("date").toString();
                JSONObject object = JSONObject.parseObject(a);
                if(object.get("xxkbh")!=null){
                    bianhao.setText(object.get("xxkbh").toString());
                }
                if(object.get("xm") != null){
                    xingming.setText(object.get("xm").toString());
                }
                if (object.get("xb") != null){
                    xingbie.setText(object.get("xb").toString());
                }
                if (object.get("gw") != null){
                    gangwei.setText(object.get("gw").toString());
                }
                if (object.get("sjhm") != null){
                    dianhuahaoma.setText(object.get("sjhm").toString());
                }
                if (object.get("gzdw") != null){
                    gongzuodanwei.setText(object.get("gzdw").toString());
                }
                if (object.get("yxq") != null && object.get("xyq1") != null) {
                    youxiaoqi.setText("" + object.get("yxq").toString() + "到" + object.get("xyq1").toString());
                }
                if (object.get("jgdw") != null){
                    shengchangangwei.setText(object.get("jgdw").toString());
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
        return R.layout.gerenyonghu_xinxika;
    }

    @OnClick(R.id.fanhui)
    public void onClick() {
    }
}
