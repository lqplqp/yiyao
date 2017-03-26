package com.lxkj.yiyao.utils;

import android.util.Log;

import com.lxkj.yiyao.global.GlobalString;

import org.xutils.common.Callback;
import org.xutils.common.util.KeyValue;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.http.body.MultipartBody;
import org.xutils.x;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqinpeng on 2017/3/26 0026.
 *
 * @author 李秦鹏
 *         -------------------------------
 */

public class FileUploadUtil  {

    public static  void uploadImage(String filePath , final FileUploadResult uploadResult){
        RequestParams params = new RequestParams(GlobalString.BaseURL + "index.php/admin/Image/up");
        List<KeyValue> list = new ArrayList<>();
        //给list中添加数据，filePah是上传的文件路径，比如sd卡中图片
        list.add(new KeyValue("file", new File(filePath)));//文件流数据
        //其它参数，根据项目而定，比如我的项目中要传入的参数是json格式的
        //list.add(new KeyValue("parameters", json.toString()));
        //创建MultipartBody
        MultipartBody body = new MultipartBody(list, "UTF-8");
        //添加请求参数
        params.setRequestBody(body);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                uploadResult.resultFilePath(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                ex.printStackTrace();
            }

            @Override
            public void onCancelled(CancelledException cex) {
                cex.printStackTrace();
            }

            @Override
            public void onFinished() {
                LogUtil.i("图片上传完成");
            }
        });

    }


    public interface FileUploadResult{
        void resultFilePath(String result);
    }



}
