package com.lxkj.yiyao.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.utils.UploadImgBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liqinpeng on 2017/3/26 0026.
 *
 * @author 李秦鹏
 *         -------------------------------
 */

public class QiYeZhiFaActivity extends BaseActivity {

    private static final String IMAGE_UNSPECIFIED = "image/*";
    private final int IMAGE_CODE = 0; // 这里的IMAGE_CODE是自己任意定义的

    @BindView(R.id.img_1)
    ImageView img1;
    @BindView(R.id.img_2)
    ImageView img2;
    @BindView(R.id.img_3)
    ImageView img3;
    @BindView(R.id.img_4)
    ImageView img4;
    @BindView(R.id.match_diyizhifa)
    TextView matchDiyizhifa;
    @BindView(R.id.match_dierzhifa)
    TextView matchDierzhifa;
    @BindView(R.id.diyizhifa)
    EditText diyizhifa;
    @BindView(R.id.dierzhifa)
    EditText dierzhifa;
    @BindView(R.id.tijiao_but)
    Button tijiaoBut;


    private String imgFile1;
    private String imgFile2;
    private String imgFile3;
    private String imgFile4;

    private String xukezhenghao ;


    @Override
    protected void init() {
        xukezhenghao = getIntent().getStringExtra("xkzbh");
    }

    @Override
    public int getLayout() {
        return R.layout.shangchuantupian_layout;
    }


    @OnClick({R.id.img_1, R.id.img_2, R.id.img_3, R.id.img_4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_1:
                uploadImage(1);
                break;
            case R.id.img_2:
                uploadImage(2);
                break;
            case R.id.img_3:
                uploadImage(3);
                break;
            case R.id.img_4:
                uploadImage(4);
                break;
        }
    }

    public void uploadImage(int index) {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_UNSPECIFIED);
        startActivityForResult(intent, index);


    }


    @Override
    protected void onActivityResult(final int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub


        Bitmap bm = null;

        // 外界的程序访问ContentProvider所提供数据 可以通过ContentResolver接口

        ContentResolver resolver = getContentResolver();

        try {
            if(data == null){
                return;
            }

            Uri originalUri = data.getData(); // 获得图片的uri
            originalUri = getUri(data);

            bm = MediaStore.Images.Media.getBitmap(resolver, originalUri);

            //imageView.setImageBitmap(ThumbnailUtils.extractThumbnail(bm, 100, 100));  //使用系统的一个工具类，参数列表为 Bitmap Width,Height  这里使用压缩后显示，否则在华为手机上ImageView 没有显示
            // 显得到bitmap图片

            if (requestCode == 1) {
                img1.setImageBitmap(bm);
            }
            if (requestCode == 2) {
                img2.setImageBitmap(bm);
            }
            if (requestCode == 3) {
                img3.setImageBitmap(bm);
            }
            if (requestCode == 4) {
                img4.setImageBitmap(bm);
            }

            // imageView.setImageBitmap(bm);

            String[] proj = {MediaStore.Images.Media.DATA};

            // 好像是android多媒体数据库的封装接口，具体的看Android文档
            Cursor cursor = managedQuery(originalUri, proj, null, null, null);

            // 按我个人理解 这个是获得用户选择的图片的索引值
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            // 将光标移至开头 ，这个很重要，不小心很容易引起越界
            cursor.moveToFirst();
            // 最后根据索引值获取图片路径
            final String path = cursor.getString(column_index);
                /*FileUploadUtil.uploadImage(path, new FileUploadUtil.FileUploadResult() {
                    @Override
                    public void resultFilePath(String result2) {
                        LogUtil.i(result2);
                    }
                });*/
            new Thread(new Runnable() {
                @Override
                public void run() {
                    UploadImgBiz.getInstance().uploadImg(path, new UploadImgBiz.OnUploadListener() {
                        @Override
                        public void success(final String result) {
                            JSONObject jsonObject = JSONObject.parseObject(result);
                            String filePath = jsonObject.get("data").toString();

                            if (requestCode == 1) {
                                imgFile1 = filePath;
                            }
                            if (requestCode == 2) {
                                imgFile2 = filePath;
                            }
                            if (requestCode == 3) {
                                imgFile3 = filePath;
                            }
                            if (requestCode == 4) {
                                imgFile4 = filePath;
                            }
                        }

                        @Override
                        public void failed() {
                            String a = "A";
                        }
                    });

                }
            }).start();

        } catch (IOException e) {
            Log.e("TAG-->Error", e.toString());

        }


        super.onActivityResult(requestCode, resultCode, data);

    }

    /**
     * 解决小米手机上获取图片路径为null的情况
     * @param intent
     * @return
     */
    public Uri getUri(android.content.Intent intent) {
        Uri uri = intent.getData();
        String type = intent.getType();
        if (uri.getScheme().equals("file") && (type.contains("image/"))) {
            String path = uri.getEncodedPath();
            if (path != null) {
                path = Uri.decode(path);
                ContentResolver cr = mActivity.getContentResolver();
                StringBuffer buff = new StringBuffer();
                buff.append("(").append(MediaStore.Images.ImageColumns.DATA).append("=")
                        .append("'" + path + "'").append(")");
                Cursor cur = cr.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        new String[] { MediaStore.Images.ImageColumns._ID },
                        buff.toString(), null, null);
                int index = 0;
                for (cur.moveToFirst(); !cur.isAfterLast(); cur.moveToNext()) {
                    index = cur.getColumnIndex(MediaStore.Images.ImageColumns._ID);
                    // set _id value
                    index = cur.getInt(index);
                }
                if (index == 0) {
                    // do nothing
                } else {
                    Uri uri_temp = Uri
                            .parse("content://media/external/images/media/"
                                    + index);
                    if (uri_temp != null) {
                        uri = uri_temp;
                    }
                }
            }
        }
        return uri;
    }


    @OnClick(R.id.tijiao_but)
    public void onClick() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + "admin/qita1/qyzf");
        params.addBodyParameter("tpdz" , imgFile1);
        params.addBodyParameter("tpdz1" , imgFile2);
        params.addBodyParameter("tpdz2" , imgFile3);
        params.addBodyParameter("tpdz3" , imgFile4);

        params.addBodyParameter("dyzfr" , diyizhifa.getText().toString());
        params.addBodyParameter("dezfr" , dierzhifa.getText().toString());
        params.addBodyParameter("qyxkzh" , xukezhenghao);

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

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
