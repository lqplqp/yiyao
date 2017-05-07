package com.lxkj.yiyao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.adapter.JiChuKeChengAdapter;
import com.lxkj.yiyao.adapter.JieYeKaoShiAdapter;
import com.lxkj.yiyao.adapter.JieYeZhengShuAdapter;
import com.lxkj.yiyao.adapter.XiangGuanZiLiaoAdapter;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.gerenyonghu.Adapter.GeRenYongHuXueXiAdapter;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.utils.SPUtil;
import com.lxkj.yiyao.utils.ToastUtil;
import com.lxkj.yiyao.view.ExpandListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liqinpeng on 2017/3/11 0011.
 */

public class LearningActivity extends BaseActivity {


    @BindView(R.id.jichukecheng_listview)
    ExpandListView jichukechengListview;
    @BindView(R.id.xiangguanziliao_listview)
    ExpandListView xiangguanziliaoListview;
    @BindView(R.id.zaixiankaoshi_listview)
    ExpandListView zaixiankaoshiListview;
    @BindView(R.id.jieyezhengshu_listview)
    ExpandListView jieyezhengshuListview;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.shiyingdiqu)
    TextView shiyingdiqu;
    @BindView(R.id.suoshuhangye)
    TextView suoshuhangye;
    @BindView(R.id.peixunshijian)
    TextView peixunshijian;
    @BindView(R.id.peixunbanleibie)
    TextView peixunbanleibie;
    @BindView(R.id.zhengshumingcheng)
    TextView zhengshumingcheng;
    @BindView(R.id.jieyetiaojian)
    TextView jieyetiaojian;
    @BindView(R.id.jieguo)
    TextView jieguo;
    @BindView(R.id.jieshushijian)
    TextView jieshushijian;
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.chakanmoban)
    TextView chakanmoban;

    private int index = 1;
    private int user_type;

    private JiChuKeChengAdapter jiChuKeChengAdapter;
    private GeRenYongHuXueXiAdapter geRenYongHuXueXiAdapter;
    private JieYeKaoShiAdapter jieYeKaoShiAdapter;
    private JieYeZhengShuAdapter jieYeZhengShuAdapter;
    private XiangGuanZiLiaoAdapter xiangGuanZiLiaoAdapter;
    String imageUrl;

    @Override
    protected void init() {
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        index = Integer.parseInt(getIntent().getStringExtra("pxid"));
        user_type = getIntent().getIntExtra("user_type",0);
        requestDate();
    }

    private void requestDate() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + "/admin/ybpxxm/ybpxxm");
        params.addBodyParameter("pxid", index + "");
        params.addBodyParameter("username", SPUtil.getUserName(this));
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                String s = result;
                JSONObject jsonObject = JSONObject.parseObject(result);
                String a=null,b=null,c=null,d=null,e=null;
                if(jsonObject.get("data") != null)
                    a = jsonObject.get("data").toString();
                if(jsonObject.get("datb") != null)
                    b = jsonObject.get("datb").toString();
                if(jsonObject.get("datc") != null)
                    c = jsonObject.get("datc").toString();
                if(jsonObject.get("datd") != null)
                    d = jsonObject.get("datd").toString();
                if(jsonObject.get("date") != null)
                    e = jsonObject.get("date").toString();
                JSONObject object = JSONObject.parseObject(a);

                Glide.with(LearningActivity.this).load(GlobalString.BaseURL + "uploads/" + object.get("tpdz")).into(image);
                if (object.get("tpjs") != null) {
                    title.setText("" + object.get("tpjs"));
                }
                if (object.get("sydq") != null)
                    shiyingdiqu.setText("" + object.get("sydq"));
                if (object.get("sshy") != null)
                    suoshuhangye.setText("" + object.get("sshy"));
                if (object.get("pxsj") != null && object.get("pxsj1") != null)
                    peixunshijian.setText("" + object.get("pxsj") + "到" + object.get("pxsj1"));
                if (object.get("pxblb") != null)
                    peixunbanleibie.setText("" + object.get("pxblb"));
                if (object.get("zsmc") != null)
                    zhengshumingcheng.setText("" + object.get("zsmc"));
                if (object.get("jytj") != null)
                    jieyetiaojian.setText("" + object.get("jytj"));
                if (object.get("ts") != null)
                    jieguo.setText("" + object.get("ts"));
                if (object.get("jysj") != null && object.get("jysj1") != null)
                    jieshushijian.setText("" + object.get("jysj")+ "到" + object.get("jysj1"));

                if(user_type == -1){
                    geRenYongHuXueXiAdapter = new GeRenYongHuXueXiAdapter(LearningActivity.this,b);
                    jichukechengListview.setAdapter(geRenYongHuXueXiAdapter);
                }else {
                    jiChuKeChengAdapter = new JiChuKeChengAdapter(b);
                    jichukechengListview.setAdapter(jiChuKeChengAdapter);
                }
                xiangGuanZiLiaoAdapter = new XiangGuanZiLiaoAdapter(c);
                xiangguanziliaoListview.setAdapter(xiangGuanZiLiaoAdapter);

                jieYeKaoShiAdapter = new JieYeKaoShiAdapter(d);
                zaixiankaoshiListview.setAdapter(jieYeKaoShiAdapter);


                jieYeZhengShuAdapter = new JieYeZhengShuAdapter(e);
                jieyezhengshuListview.setAdapter(jieYeZhengShuAdapter);


                JSONObject date = jsonObject.getJSONObject("date");
                if(date!=null){
                    imageUrl = date.get("imageurl").toString();
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
        return R.layout.learning;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.chakanmoban)
    public void onClick() {

        Intent intent = new Intent(this,MuBanActivity.class);
        if(imageUrl==null){
            ToastUtil.show("暂无模板,请联系管理员");
        }else {
            intent.putExtra("imagePath","zhengshu.png");
            startActivity(intent);
        }

    }
}
