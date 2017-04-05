package com.lxkj.yiyao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

/**
 * Created by liqinpeng on 2017/3/14 0014.
 */

public class GeRenScannerQrCodeActivity extends BaseActivity{

    private int REQUEST_CODE = 1;

    @Override
    protected void init() {
        Intent intent = new Intent(this, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    String[] split = result.split("----");
                    //Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this,ExamActivity.class);
                    //intent.putExtra("kmid",split[0]);
                    intent.putExtra("xkzbh",split[1]);
                    startActivity(intent);
                    finish();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }

    }

    @Override
    public int getLayout() {
        return R.layout.image;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
