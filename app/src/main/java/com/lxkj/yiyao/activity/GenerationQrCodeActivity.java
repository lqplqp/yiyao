package com.lxkj.yiyao.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liqinpeng on 2017/3/14 0014.
 */

public class GenerationQrCodeActivity extends BaseActivity {
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.top)
    RelativeLayout top;


    private String codeText;
    String xkzbh;
    String username;

    @Override
    protected void init() {
        //codeText = getIntent().getStringExtra("qrcode_result");
        xkzbh = getIntent().getStringExtra("xkzbh");
        username = getIntent().getStringExtra("username").toString();
        if(TextUtils.isEmpty(codeText)){
            codeText = "非法二维码";
        }
        codeText = xkzbh + "----" + username;

        Bitmap mBitmap = CodeUtils.createImage(codeText, 400, 400, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        this.image.setImageBitmap(mBitmap);

    }

    @Override
    public int getLayout() {
        return R.layout.generation_qrcode;
    }


    @OnClick({R.id.back_img, R.id.image})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.image:

                break;
        }
    }
}
