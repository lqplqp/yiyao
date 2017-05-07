package com.lxkj.yiyao.utils;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.global.GlobalString;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.math.BigDecimal;

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


    public static int i = 1;

    /**
     * 下载工具类
     *
     * @param url
     * @param path
     */
    public static void downLoad(String url, final String path, final Context context) {


        final NotificationManager mNotifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
        mBuilder.setContentTitle("文件下载")
                .setContentText("正在下载...")
                .setContentInfo("0%")
                .setSmallIcon(R.mipmap.ic_launcher);


        RequestParams params = new RequestParams(url);
        //设置断点续传
        params.setAutoResume(true);
        params.setSaveFilePath(path);

        x.http().get(params, new Callback.ProgressCallback<File>() {


            @Override
            public void onWaiting() {

            }

            @Override
            public void onStarted() {
                //Toast.makeText(x.app(), "开始下载", Toast.LENGTH_LONG).show();
                ToastUtil.show("开始下载");
            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                BigDecimal b = new BigDecimal((float) current / (float) total);
                float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
                mBuilder.setProgress(100, (int) (f1 * 100), false);
                mBuilder.setContentInfo((int) (f1 * 100) + "%");
                mNotifyManager.notify(i, mBuilder.build());
            }

            @Override
            public void onSuccess(File result) {
                mBuilder.setContentText("正在下载...")
                        // Removes the progress bar
                        .setProgress(0, 0, false);
                mNotifyManager.notify(1, mBuilder.build());
                //mNotifyManager.cancel(1);
                //Toast.makeText(x.app(), "下载成功", Toast.LENGTH_LONG).show();
                ToastUtil.show("下载完成");
                //InstallUtils.installApp(context, path);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                mBuilder.setContentText("下载完成")
                        // Removes the progress bar
                        .setProgress(0, 0, false);
                mNotifyManager.notify(i++, mBuilder.build());

            }
        });
    }

}
