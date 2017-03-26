package com.lxkj.yiyao.utils;

import android.os.Environment;

import com.lxkj.yiyao.global.GlobalString;

import org.xutils.common.util.LogUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 紫荆 on 2016/10/21.
 */

public class UploadImgBiz {
    private String ip = GlobalString.BaseURL + "/index.php/admin/Image/up";
    public static UploadImgBiz uploadImgBiz;

    public static UploadImgBiz getInstance() {
        if (uploadImgBiz == null) {
            uploadImgBiz = new UploadImgBiz();
        }
        return uploadImgBiz;
    }

    public interface OnUploadListener {
        void success(String result);

        void failed();
    }

    public void uploadImg(String fileUri, OnUploadListener uploadListener) {
        try {
            File uploadFile = new File( fileUri);
            URL url = new URL(ip);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            OutputStream out = conn.getOutputStream();
            InputStream in = new FileInputStream(uploadFile);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) != -1)
                out.write(buf, 0, len);
            in.close();
            out.close();
            if (conn.getResponseCode() == 200) {
                InputStream inputStream = conn.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String s = bufferedReader.readLine();
                uploadListener.success(s);
            } else {
                LogUtil.d("上传时ResponseCode不为200");
                uploadListener.failed();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void uploadImg(final File file, final OnUploadListener uploadListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(ip);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setDoOutput(true);
                    OutputStream out = conn.getOutputStream();
                    InputStream in = new FileInputStream(file);
                    byte[] buf = new byte[1024];
                    int len;
                    while ((len = in.read(buf)) != -1)
                        out.write(buf, 0, len);
                    in.close();
                    out.close();
                    if (conn.getResponseCode() == 200) {
                        InputStream inputStream = conn.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        String s = bufferedReader.readLine();
                        //BaseBean baseBean = GetGson.getGson().fromJson(s, BaseBean.class);
                        uploadListener.success(s);
                    } else {
                        LogUtil.d("上传时ResponseCode不为200");
                        uploadListener.failed();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LogUtil.d("上传图片业务抛异常了: " + e.toString());
                }
            }
        }).start();

    }
}
