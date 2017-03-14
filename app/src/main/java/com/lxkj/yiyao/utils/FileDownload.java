package com.lxkj.yiyao.utils;

import android.util.Log;

import com.lxkj.yiyao.global.GlobalString;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;

/**
 * Created by liqinpeng on 2017/3/13 0013.
 */

public class FileDownload {

    public static  void downloadFile(String url){
        RequestParams params = new RequestParams(GlobalString.BaseURL + url.replace("/",""));
        params.setAutoRename(true);
        params.setAutoResume(true);//设置是否在下载是自动断点续传
        params.setSaveFilePath("/mnt/sdcard/" + url);
        x.http().get(params, new Callback.CommonCallback<File>() {
            @Override
            public void onSuccess(File result2) {

                ToastUtil.show("下载完成,请到系统文件夹进行查看 ");
                Log.i("123","下载完成");
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

}
