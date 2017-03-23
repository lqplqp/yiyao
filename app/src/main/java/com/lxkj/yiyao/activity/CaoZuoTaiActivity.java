package com.lxkj.yiyao.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;

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
    }

    private void parseInfo() {
        String[] split = qrInfo.split(";");
        if(split.length > 6){
            xukezhengbianhao = split[0].replace("许可证编号:", "");
            jingyingzhemingcheng = split[1].replace("经营者名称:", "");
            jingyingchangsuo = split[2].replace("经营场所:", "");
            fadingdaibiaoren = split[3].replace("法定代表人(负责人):", "");
            zhutiyetai = split[4].replace("主体业态:", "");
            youxiaoqi = split[5].replace("有效期至:", "");
            gengduoxinxi = split[6].replace("更多信息请访问:", "");
        }


        if(!TextUtils.isEmpty(jingyingzhemingcheng))
            qiyemingcheng.setText(jingyingzhemingcheng);
        if(!TextUtils.isEmpty(fadingdaibiaoren))
            faren.setText(fadingdaibiaoren);
        if(!TextUtils.isEmpty(zhutiyetai))
            jingyingfanwei.setText(zhutiyetai);
        if(!TextUtils.isEmpty(jingyingchangsuo))
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

                break;
            case R.id.kaoshijieguo:
                break;
            case R.id.qiyezhifa:
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
更多信息请访问:http://hda.gov.cn/CL0577*/
