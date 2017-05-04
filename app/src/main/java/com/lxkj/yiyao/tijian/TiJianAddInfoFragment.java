package com.lxkj.yiyao.tijian;

import android.app.ProgressDialog;
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
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.utils.FileUploadUtil;
import com.lxkj.yiyao.utils.PickViewUtils;
import com.lxkj.yiyao.utils.SPUtil;
import com.lxkj.yiyao.utils.ToastUtil;
import com.lxkj.yiyao.utils.UploadImgBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liqinpeng on 2017/4/29 0029.
 *
 * @author 李秦鹏
 *         -------------------------------
 */

public class TiJianAddInfoFragment extends BaseFragment {
    @BindView(R.id.head_image)
    ImageView headImage;
    @BindView(R.id.tijianbaogaobianhao)
    EditText tijianbaogaobianhao;
    @BindView(R.id.xingming)
    EditText xingming;
    @BindView(R.id.radio_nan)
    RadioButton radioNan;
    @BindView(R.id.radio_nv)
    RadioButton radioNv;
    @BindView(R.id.shenfenzhenghao)
    EditText shenfenzhenghao;
    @BindView(R.id.gongzuodanwei)
    EditText gongzuodanwei;
    @BindView(R.id.shifouhege)
    Spinner shifouhege;
    @BindView(R.id.commit_but)
    Button commitBut;
    @BindView(R.id.tijianshijian)
    TextView tijianshijian;
    private ProgressDialog progressDialog;

    @Override
    protected void initView() {

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("正在加载...");
        progressDialog.setCanceledOnTouchOutside(false);

        headImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });

        tijianshijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PickViewUtils(mActivity,tijianshijian).pickDate();
            }
        });

    }

    private static final String IMAGE_UNSPECIFIED = "image/*";
    private final int IMAGE_CODE = 0; // 这里的IMAGE_CODE是自己任意定义的
    public void uploadImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_UNSPECIFIED);
        startActivityForResult(intent, 0);
    }

    @Override
    public int getLayout() {
        return R.layout.tijian;
    }

    void requestData(String imagePath){
        RequestParams params = new RequestParams(GlobalString.BaseURL + "/admin/tjgl/addtjjl");
        params.addBodyParameter("username", SPUtil.getUserName(getContext()));
        params.addBodyParameter("headimage",imagePath);
        params.addBodyParameter("tjbgbh",tijianbaogaobianhao.getText().toString());
        params.addBodyParameter("xm",xingming.getText().toString());
        if(radioNan.isChecked()){
            params.addBodyParameter("xb","男");
        }
        if(radioNv.isChecked()){
            params.addBodyParameter("xb","女");
        }

        params.addBodyParameter("sfzh",shenfenzhenghao.getText().toString());
        params.addBodyParameter("gzdw",gongzuodanwei.getText().toString());

        if(shifouhege.getSelectedItemPosition()==0){
            params.addBodyParameter("sfhg","是");
        }else {
            params.addBodyParameter("sfhg","否");
        }
        params.addBodyParameter("tjsj",tijianshijian.getText().toString());

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JSONObject jsonObject = JSONObject.parseObject(result);
                /*jsonObject.get("code");
                if("111111".equals(jsonObject.get("code"))){

                }*/
                ToastUtil.show("" + jsonObject.get("message"));
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

    boolean isClickable = true;
    @OnClick(R.id.commit_but)
    public void onClick() {
        if(isClickable){
            uploadImageAndSaveInfo();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final Timer timer = new Timer();

                    timer.schedule(new TimerTask() {
                        int i = 30;
                        @Override
                        public void run() {
                            Log.i("time" , ""+i);
                            i--;
                            if(i<3){
                                isClickable = true;
                                timer.cancel();
                            }else {
                                isClickable = false;
                            }
                        }
                    },1000,3000);
                }
            }).start();
        }

        else {
            ToastUtil.show("30秒之内只能提交一次");
        }
    }

    String imagePath;

    private void uploadImageAndSaveInfo() {
        if(imagePath!=null){

            progressDialog.show();
            FileUploadUtil.uploadImage(imagePath, new FileUploadUtil.FileUploadResult() {
                @Override
                public void resultFilePath(String result) {
                    progressDialog.dismiss();
                    JSONObject jsonObject = JSONObject.parseObject(result);
                    Object data = jsonObject.get("data");
                    if(data!=null){

                        requestData(data.toString());
                    }
                    ToastUtil.show("图片上传失败");
                }
            });
        }else {
            ToastUtil.show("请上传图片");
        }


    }


    @Override
    public void onActivityResult(final int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub


        Bitmap bm = null;

        // 外界的程序访问ContentProvider所提供数据 可以通过ContentResolver接口

        ContentResolver resolver = getActivity().getContentResolver();

        try {
            if (data != null) {

                Uri originalUri = data.getData(); // 获得图片的uri
                originalUri = getUri(data);
                bm = MediaStore.Images.Media.getBitmap(resolver, originalUri);

                //imageView.setImageBitmap(ThumbnailUtils.extractThumbnail(bm, 100, 100));  //使用系统的一个工具类，参数列表为 Bitmap Width,Height  这里使用压缩后显示，否则在华为手机上ImageView 没有显示
                // 显得到bitmap图片


                // imageView.setImageBitmap(bm);

                String[] proj = {MediaStore.Images.Media.DATA};

                // 好像是android多媒体数据库的封装接口，具体的看Android文档
                Cursor cursor = mActivity.managedQuery(originalUri, proj, null, null, null);

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

                imagePath = path;




                /*new Thread(new Runnable() {
                    @Override
                    public void run() {
                        UploadImgBiz.getInstance().uploadImg(path, new UploadImgBiz.OnUploadListener() {
                            @Override
                            public void success(final String result) {
                                JSONObject jsonObject = JSONObject.parseObject(result);
                                upDateTpdz = jsonObject.get("data").toString();
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressDialog.dismiss();
                                    }
                                });

                            }

                            @Override
                            public void failed() {
                                String a = "A";
                            }
                        });

                    }
                }).start();*/
            }

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
}
