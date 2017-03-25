package com.lxkj.yiyao.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.activity.adapter.XuanGouKeChengJiChuKeChengAdapter;
import com.lxkj.yiyao.activity.adapter.XuanGouKeChengQiYeRenYuanAdapter;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.global.GlobalString;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;

/**
 * Created by liqinpeng on 2017/3/19 0019.
 *
 * @author 李秦鹏
 *         -------------------------------
 */

public class XueXiKeChengActivity extends BaseActivity {
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.title_tv)
    TextView titleTv;
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
    @BindView(R.id.jichukecheng_listview)
    ListView jichukechengListview;
    @BindView(R.id.qiyerenyuanleibiao_listview)
    ListView qiyerenyuanleibiaoListview;
    @BindView(R.id.chakanmoban)
    TextView chakanmoban;
    private int index = 1;

    private XuanGouKeChengJiChuKeChengAdapter jiChuKeChengAdapter;
    private XuanGouKeChengQiYeRenYuanAdapter qiYeRenYuanAdapter;

    @Override
    protected void init() {
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        index = Integer.parseInt(getIntent().getStringExtra("pxid"));
        requestDate();
    }

    private void requestDate() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + "/admin/ybpxxm/ybpxxm");
        params.addBodyParameter("pxid", index + "");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JSONObject jsonObject = JSONObject.parseObject(result);
                String a = jsonObject.get("data").toString();
                String b = jsonObject.get("datb").toString();
                String c = jsonObject.get("datc").toString();

                JSONObject object = JSONObject.parseObject(a);

                Glide.with(XueXiKeChengActivity.this).load(object.get("tpdz")).into(image);
                if (object.get("tpjs") != null) {
                    title.setText("" + object.get("tpjs").toString());
                }
                if (object.get("sydq") != null)
                    shiyingdiqu.setText("" + object.get("sydq").toString());
                if (object.get("sshy") != null)
                    suoshuhangye.setText("" + object.get("sshy").toString());
                if (object.get("pxsj") != null && object.get("pxsj1") != null)
                    peixunshijian.setText("" + object.get("pxsj").toString() + "到" + object.get("pxsj1").toString());
                if (object.get("pxblb") != null)
                    peixunbanleibie.setText("" + object.get("pxblb").toString());
                if (object.get("zsmc") != null)
                    zhengshumingcheng.setText("" + object.get("zsmc").toString());
                if (object.get("jytj") != null)
                    jieyetiaojian.setText("" + object.get("jytj").toString());
                if (object.get("ts") != null)
                    jieguo.setText("" + object.get("ts").toString());
                if (object.get("jysj") != null && object.get("jysj1") != null)
                    jieshushijian.setText("" + object.get("jysj").toString() + "到" + object.get("jysj1").toString());


                jiChuKeChengAdapter = new XuanGouKeChengJiChuKeChengAdapter(b);
                jichukechengListview.setAdapter(jiChuKeChengAdapter);

                qiYeRenYuanAdapter = new XuanGouKeChengQiYeRenYuanAdapter(c);
                qiyerenyuanleibiaoListview.setAdapter(qiYeRenYuanAdapter);

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
        return R.layout.xuangou_kecheng_yibaopeixun;
    }


}
