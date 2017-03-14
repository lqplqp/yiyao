package com.lxkj.yiyao.shengjugeren.Adapter;

import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.utils.ToastUtil;

import org.xutils.common.Callback;
import org.xutils.common.util.FileUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liqinpeng on 2017/3/9 0009.
 */

public class SJGRDownloadDocAdapter extends MBaseAdapter<SJGRDownloadDocAdapter.ViewHolder> {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.line1)
    LinearLayout line1;

    public SJGRDownloadDocAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, final JSONObject result) {


        holder.title.setText(result.get("wj").toString());

        holder.time.setText(result.get("sj").toString());

        holder.line1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestParams params = new RequestParams(GlobalString.BaseURL + result.get("url").toString().replace("/",""));
                String s = result.get("url").toString();
                params.setAutoRename(true);
                params.setAutoResume(true);//设置是否在下载是自动断点续传
                params.setSaveFilePath("/mnt/sdcard/" + result.get("url").toString());
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
        });


    }

    @Override
    protected int getItemLayout() {
        return R.layout.downloaddoc_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


    static class ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.line1)
        LinearLayout line1;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
