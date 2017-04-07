package com.lxkj.yiyao.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.global.GlobalString;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liqinpeng on 2017/3/14 0014.
 */

public class CaoZuoTaiActivity extends BaseActivity {

    @BindView(R.id.qiyemingcheng)
    TextView qiyemingcheng;
    @BindView(R.id.faren)
    TextView faren;
    @BindView(R.id.jingyingfanwei)
    TextView jingyingfanwei;
    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.erweimashengcheng)
    Button erweimashengcheng;
    @BindView(R.id.kaoshijieguo)
    Button kaoshijieguo;
    @BindView(R.id.qiyezhifa)
    Button qiyezhifa;
    @BindView(R.id.shipin)
    TextView shipin;
    private String qrInfo;

    private String xukezhengbianhao;

    private String jingyingzhemingcheng;

    private String jingyingchangsuo;

    private String fadingdaibiaoren;

    private String zhutiyetai;

    private String youxiaoqi;

    private String gengduoxinxi;

    @Override
    protected void init() {
        qrInfo = getIntent().getStringExtra("qrcode_result");
        parseInfo();
        requestData();
    }

    private void requestData() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + "/admin/qita1/qyxx");
        SharedPreferences sp = getSharedPreferences("shiyao", 0);
        String id = sp.getString("username", "");

        params.addBodyParameter("username", id);
        params.addBodyParameter("qyxxbh", xukezhengbianhao);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JSONObject obj = JSONObject.parseObject(result);
                String message = obj.get("message").toString();
                shipin.setText(message);
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

    private void parseInfo() {
        String[] split = qrInfo.split(";");
        if (split.length > 6) {
            xukezhengbianhao = split[0].replace("许可证编号:", "");
            jingyingzhemingcheng = split[1].replace("经营者名称:", "");
            jingyingchangsuo = split[2].replace("经营场所:", "");
            fadingdaibiaoren = split[3].replace("法定代表人(负责人):", "");
            zhutiyetai = split[4].replace("主体业态:", "");
            youxiaoqi = split[5].replace("有效期至:", "");
            gengduoxinxi = split[6].replace("更多信息请访问:", "");
        }


        if (!TextUtils.isEmpty(jingyingzhemingcheng))
            qiyemingcheng.setText(jingyingzhemingcheng);
        if (!TextUtils.isEmpty(fadingdaibiaoren))
            faren.setText(fadingdaibiaoren);
        if (!TextUtils.isEmpty(zhutiyetai))
            jingyingfanwei.setText(zhutiyetai);
        if (!TextUtils.isEmpty(jingyingchangsuo))
            dizhi.setText(jingyingchangsuo);


    }

    @Override
    public int getLayout() {
        return R.layout.caozuotai;
    }


    @OnClick({R.id.erweimashengcheng, R.id.kaoshijieguo, R.id.qiyezhifa})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.erweimashengcheng:
                Intent intent = new Intent(this,GenerationQrCodeActivity.class);

                intent.putExtra("xkzbh",xukezhengbianhao);
                SharedPreferences sp = getSharedPreferences("shiyao", 0);
                String id = sp.getString("username", "");
                intent.putExtra("username",id);
                startActivity(intent);
                break;
            case R.id.kaoshijieguo:
                Intent intent2 = new Intent(this,KaoShiJieGuoZhiFaActivity.class);
                intent2.putExtra("qrcode_result",xukezhengbianhao);
                SharedPreferences sp2 = getSharedPreferences("shiyao", 0);
                String id2 = sp2.getString("username", "");
                intent2.putExtra("username",id2);

                startActivity(intent2);
                break;
            case R.id.qiyezhifa:

                Intent intent3 = new Intent(this,QiYeZhiFaActivity.class);
                intent3.putExtra("xkzbh",xukezhengbianhao);
                startActivity(intent3);

                break;
        }
    }

}

/*
许可证编号:JY24107110024586;
经营者名称:新乡市牧野区小城固始餐馆;
经营场所:新乡市牧野区理想城20号楼108室;
法定代表人(负责人):刘兰发;
主体业态:餐饮服务经营者;
有效期至:2021-09-25;
更多信息请访问:http://hda.gov.cn/CL0577
*/
