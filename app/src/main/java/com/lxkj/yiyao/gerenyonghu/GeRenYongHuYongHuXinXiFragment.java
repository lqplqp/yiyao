package com.lxkj.yiyao.gerenyonghu;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.utils.UploadImgBiz;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/3/16.
 */

public class GeRenYongHuYongHuXinXiFragment extends BaseFragment {
    @BindView(R.id.username_tv)
    EditText usernameTv;
    Unbinder unbinder;
    @BindView(R.id.head_image)
    ImageView headImage;
    @BindView(R.id.commit)
    Button commit;
    private String username;


    private static final String IMAGE_UNSPECIFIED = "image/*";
    private final int IMAGE_CODE = 0; // 这里的IMAGE_CODE是自己任意定义的

    @Override
    protected void initView() {
        usernameTv.setText("eee");
    }

    @Override
    public int getLayout() {
        return R.layout.gerenyonghu_yonghuxinxi;
    }




    @OnClick({R.id.head_image, R.id.commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.head_image:
                uploadImage();
                break;
            case R.id.commit:
                commit();
                break;
        }
    }

    private void commit() {

    }

    public void uploadImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_UNSPECIFIED);
        startActivityForResult(intent, 0);


    }


    @Override
    public void onActivityResult(final int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub


        Bitmap bm = null;

        // 外界的程序访问ContentProvider所提供数据 可以通过ContentResolver接口

        ContentResolver resolver = getActivity().getContentResolver();

        try {

            Uri originalUri = data.getData(); // 获得图片的uri

            bm = MediaStore.Images.Media.getBitmap(resolver, originalUri);

            //imageView.setImageBitmap(ThumbnailUtils.extractThumbnail(bm, 100, 100));  //使用系统的一个工具类，参数列表为 Bitmap Width,Height  这里使用压缩后显示，否则在华为手机上ImageView 没有显示
            // 显得到bitmap图片


            // imageView.setImageBitmap(bm);

            String[] proj = {MediaStore.Images.Media.DATA};

            // 好像是android多媒体数据库的封装接口，具体的看Android文档
            Cursor cursor = getActivity().managedQuery(originalUri, proj, null, null, null);

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
            headImage.setImageBitmap(bm);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    UploadImgBiz.getInstance().uploadImg(path, new UploadImgBiz.OnUploadListener() {
                        @Override
                        public void success(final String result) {
                            JSONObject jsonObject = JSONObject.parseObject(result);
                            String filePath = jsonObject.get("data").toString();


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
}
