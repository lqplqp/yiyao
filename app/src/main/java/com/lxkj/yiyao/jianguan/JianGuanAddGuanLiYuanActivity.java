package com.lxkj.yiyao.jianguan;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.utils.PickViewUtils;
import com.lxkj.yiyao.utils.ToastUtil;
import com.lxkj.yiyao.utils.UploadImgBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/4/10.
 */

public class JianGuanAddGuanLiYuanActivity extends BaseActivity {
    @BindView(R.id.yonghuming)
    EditText yonghuming;
    @BindView(R.id.add_touxiang)
    Button addTouxiang;
    @BindView(R.id.touxiangdizhi)
    ImageView touxiangdizhi;
    @BindView(R.id.guanliyuanleixing)
    Spinner guanliyuanleixing;
    @BindView(R.id.shurumima)
    EditText shurumima;
    @BindView(R.id.querenmima)
    EditText querenmima;
    @BindView(R.id.danweimingcheng)
    EditText danweimingcheng;
    @BindView(R.id.guanlirenshu)
    EditText guanlirenshu;
    @BindView(R.id.xingming)
    EditText xingming;
    @BindView(R.id.youxiang)
    EditText youxiang;
    @BindView(R.id.shoujihaoma)
    EditText shoujihaoma;
    @BindView(R.id.danweidizhi)
    TextView danweidizhi;
    @BindView(R.id.dizhi)
    EditText dizhi;
    @BindView(R.id.commit)
    Button commit;
    @BindView(R.id.hangyelingyu)
    Spinner hangyelingyu;
    /*@BindView(R.id.back_img)
    ImageView backImg;*/
    Unbinder unbinder;
    private static final String IMAGE_UNSPECIFIED = "image/*";
    private final int IMAGE_CODE = 0; // 这里的IMAGE_CODE是自己任意定义的

    private String upDateTpdz = "";

    //省市县对应id  省级 2   市级 4  县级6
    private int guanliyuanleixingtId;
    private ArrayAdapter<String> mSpinnerAdapter;
    private String guanliyuanleixingtType;
    private String hangyelingyuType;
    private ProgressDialog progressDialog;
    @Override
    protected void init() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在加载...");
        progressDialog.setCanceledOnTouchOutside(false);

        initSpinner1();
        initSpinner2();
        /*backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });*/
    }

    private void requestDate(){
        // http://af.0101hr.com/+admin/fenji/addadmin
        RequestParams requestParams = new RequestParams("http://af.0101hr.com/admin/fenji/addadmin");
        requestParams.addBodyParameter("yhm",yonghuming.getText().toString());
        requestParams.addBodyParameter("address",upDateTpdz);
        requestParams.addBodyParameter("fl",""+guanliyuanleixingtId);
        requestParams.addBodyParameter("mm",shurumima.getText().toString());
        requestParams.addBodyParameter("glrs",guanlirenshu.getText().toString());
        requestParams.addBodyParameter("qrmm",querenmima.getText().toString());
        requestParams.addBodyParameter("dwmc",danweimingcheng.getText().toString());
        requestParams.addBodyParameter("gly",xingming.getText().toString());
        requestParams.addBodyParameter("yx",youxiang.getText().toString());
        requestParams.addBodyParameter("sjhm",shoujihaoma.getText().toString());

        String sanji = danweidizhi.getText().toString();
        String [] sanjidizhi = sanji.split("-");

        requestParams.addBodyParameter("szdq",sanjidizhi[0]);
        requestParams.addBodyParameter("szdq1",sanjidizhi[1]);
        requestParams.addBodyParameter("szdq2",sanjidizhi[2]);

        requestParams.addBodyParameter("dwdz",dizhi.getText().toString());

        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (result != null) {
                    JSONObject jsonObject = JSONObject.parseObject(result);
                    String code = jsonObject.getString("data");
                    if (code.equals("111111")) {
                        finish();
                        ToastUtil.show("保存成功");
                    } else {
                        ToastUtil.show("保存失败");
                    }
                }
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

    @Override
    public int getLayout() {
        return R.layout.jianguan_add_guanliyuan;
    }

    @OnClick({R.id.add_touxiang, R.id.danweidizhi, R.id.commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_touxiang:
                Intent intent = new Intent(Intent.ACTION_PICK,null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_UNSPECIFIED);
                startActivityForResult(intent, 0);
                break;
            case R.id.danweidizhi:
                new PickViewUtils(this, danweidizhi).pickProvince();
                break;
            case R.id.commit:
                requestDate();
                break;
        }
    }

    private void initSpinner1() {
        final List<String> selects = new ArrayList<String>();
        selects.add("省局管理员");
        selects.add("市局管理员");
        selects.add("县局管理员");

        mSpinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, selects);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        guanliyuanleixing.setAdapter(mSpinnerAdapter);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        guanliyuanleixing.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                if(arg3==0){
                    guanliyuanleixingtId = 2;
                }
                if(arg3 ==1){
                    guanliyuanleixingtId = 4;
                }
                if(arg3 ==2){
                    guanliyuanleixingtId = 6;
                }

                //guanliyuanleixingtId = (int) arg3;
                guanliyuanleixingtType = selects.get((int) arg3);
                /* 将mySpinner 显示*/
                //arg0.setVisibility(View.VISIBLE);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                //arg0.setVisibility(View.VISIBLE);
                ToastUtil.show("12332");
            }
        });

    }

    private void initSpinner2() {
        final List<String> selects = new ArrayList<String>();
        selects.add("食品生产");
        selects.add("食品流通");
        selects.add("餐饮");

        mSpinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, selects);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        hangyelingyu.setAdapter(mSpinnerAdapter);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        hangyelingyu.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                hangyelingyuType = selects.get((int) arg3);
                /* 将mySpinner 显示*/
                //arg0.setVisibility(View.VISIBLE);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                //arg0.setVisibility(View.VISIBLE);
                ToastUtil.show("12332");
            }
        });

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

    @Override
    public void onActivityResult(final int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub


        Bitmap bm = null;

        // 外界的程序访问ContentProvider所提供数据 可以通过ContentResolver接口

        ContentResolver resolver = this.getContentResolver();

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
                Cursor cursor = this.managedQuery(originalUri, proj, null, null, null);

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
                touxiangdizhi.setImageBitmap(bm);
                progressDialog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        UploadImgBiz.getInstance().uploadImg(path, new UploadImgBiz.OnUploadListener() {
                            @Override
                            public void success(final String result) {
                                JSONObject jsonObject = JSONObject.parseObject(result);
                                upDateTpdz = jsonObject.get("data").toString();
                                mActivity.runOnUiThread(new Runnable() {
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
                }).start();
            }

        } catch (IOException e) {
            Log.e("TAG-->Error", e.toString());

        }


        super.onActivityResult(requestCode, resultCode, data);

    }

}
