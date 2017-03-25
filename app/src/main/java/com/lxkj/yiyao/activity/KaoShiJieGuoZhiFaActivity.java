package com.lxkj.yiyao.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.activity.adapter.KaoShiJieGuoZhiFaAdapter;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.global.GlobalString;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liqinpeng on 2017/3/25 0025.
 *
 * @author 李秦鹏
 *         -------------------------------
 */

public class KaoShiJieGuoZhiFaActivity extends BaseActivity {
    @BindView(R.id.chengjiliebiao)
    ListView chengjiliebiao;
    @BindView(R.id.shuaxin_but)
    Button shuaxinBut;
    @BindView(R.id.match_qiyemingcheng)
    TextView matchQiyemingcheng;
    @BindView(R.id.match_diyizhifa)
    TextView matchDiyizhifa;
    @BindView(R.id.diyizhifa)
    EditText diyizhifa;
    @BindView(R.id.match_dierzhifa)
    TextView matchDierzhifa;
    @BindView(R.id.dierzhifa)
    EditText dierzhifa;
    @BindView(R.id.tijiao_but)
    Button tijiaoBut;

    String number;
    String username;

    private KaoShiJieGuoZhiFaAdapter adapter;

    @Override
    protected void init() {
        String number = getIntent().getStringExtra("qrcode_result").toString();
        String username = getIntent().getStringExtra("username").toString();
        requestDate();
    }

    private void requestDate() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + "admin/qita1/khcjlb");
        params.addBodyParameter("kmid",number);
        params.addBodyParameter("username",username);
        params.addBodyParameter("xkzbh",number);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                adapter = new KaoShiJieGuoZhiFaAdapter(result);
                chengjiliebiao.setAdapter(adapter);
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
        return R.layout.kaohecehngji_layout;
    }


}
