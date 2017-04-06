package com.lxkj.yiyao.gerenyonghu;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import com.lxkj.yiyao.utils.SPUtil;
import com.lxkj.yiyao.utils.ToastUtil;
import com.lxkj.yiyao.utils.UploadImgBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

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
    TextView usernameTv;
    Unbinder unbinder;
    @BindView(R.id.head_image)
    ImageView headImage;
    @BindView(R.id.unitname_tv)
    EditText unitnameTv;
    @BindView(R.id.manage_person_tv)
    EditText managePersonTv;
    @BindView(R.id.contact_name_tv)
    EditText contactNameTv;
    @BindView(R.id.email_tv)
    EditText emailTv;
    @BindView(R.id.phone_tv)
    EditText phoneTv;
    Unbinder unbinder1;


    private static final String IMAGE_UNSPECIFIED = "image/*";
    private final int IMAGE_CODE = 0; // 这里的IMAGE_CODE是自己任意定义的
    @BindView(R.id.radio_nan)
    RadioButton radioNan;
    @BindView(R.id.radio_nv)
    RadioButton radioNv;
    @BindView(R.id.chushengriqi_tv)
    EditText chushengriqiTv;
    @BindView(R.id.zhiwei_tv)
    EditText zhiweiTv;
    @BindView(R.id.gongzhong_tv)
    EditText gongzhongTv;
    @BindView(R.id.danweidizhi_tv)
    TextView danweidizhiTv;
    @BindView(R.id.tijianbaogaibianhao_tv)
    EditText tijianbaogaibianhaoTv;
    @BindView(R.id.guoqiriqi_tv)
    TextView guoqiriqiTv;
    @BindView(R.id.xueli)
    Spinner xueli;
    @BindView(R.id.commit_but)
    Button commitBut;
    private String userName;

    @Override
    protected void initView() {
        userName = SPUtil.getUserName(getActivity());
        requestData();
        commitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.show("123");
                updateData();
            }
        });
    }

    private void updateData() {
        final RequestParams requestParams = new RequestParams(GlobalString.gerenyonghu_yonghuxinxi);
        requestParams.addBodyParameter("username", userName);
        requestParams.addBodyParameter("xm", "" + unitnameTv.getText());
        if (radioNan.isChecked()) {
            requestParams.addBodyParameter("xb", "男");
        } else if (radioNv.isChecked()) {
            requestParams.addBodyParameter("xb", "女");
        }
        requestParams.addBodyParameter("sfzh", "" + managePersonTv.getText());
        requestParams.addBodyParameter("jgdwmc", "" + contactNameTv.getText());
        requestParams.addBodyParameter("yx", "" + emailTv.getText());
        requestParams.addBodyParameter("sjhm", "" + phoneTv.getText());
        requestParams.addBodyParameter("csrq", "" + chushengriqiTv.getText());
        requestParams.addBodyParameter("zw", "" + zhiweiTv.getText());
        requestParams.addBodyParameter("gw", "" + gongzhongTv.getText());
        //学历
        xueli.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                requestParams.addBodyParameter("xl", "" + getResources().getStringArray(R.array.xueli)[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        requestParams.addBodyParameter("szdq", "" + danweidizhiTv.getText());
        requestParams.addBodyParameter("tjbgh", "" + tijianbaogaibianhaoTv.getText());
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (result != null) {
                    JSONObject jsonObject = JSONObject.parseObject(result);
                    String code = jsonObject.getString("code");
                    if (code.equals("1111111")) {
                        ToastUtil.show("保存成功");
                    } else {
                        ToastUtil.show("保存失败");
                    }
                }
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

    private void requestData() {
        RequestParams requestParams = new RequestParams(GlobalString.gerenyonghu_yonghuxinxi);
        requestParams.addBodyParameter("username", userName);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (result != null) {
                    JSONObject jsonObject = JSONObject.parseObject(JSONObject.parseObject(result).getString("date"));
                    //用户名
                    String zh = jsonObject.getString("zh");
                    //姓名
                    String xm = jsonObject.getString("xm");
                    //性别
                    String xb = jsonObject.getString("xb");
                    //身份证号
                    String sfzh = jsonObject.getString("sfzh");
                    //单位名称
                    String jgdwmc = jsonObject.getString("jgdwmc");
                    //邮箱
                    String yx = jsonObject.getString("yx");
                    //手机号码
                    String sjhm = jsonObject.getString("sjhm");
                    //出生日期
                    String csrq = jsonObject.getString("csrq");
                    //职务
                    String zw = jsonObject.getString("zw");
                    //工种
                    String gw = jsonObject.getString("gw");
                    //学历
                    String xl = jsonObject.getString("xl");
                    //单位地址  省 市  县  单位
                    String szdq = jsonObject.getString("szdq");
                    String szdq1 = jsonObject.getString("szdq1");
                    String szdq2 = jsonObject.getString("szdq2");
                    String dz = jsonObject.getString("dz");
                    //体检报告号
                    String tjbgh = jsonObject.getString("tjbgh");
                    //过期日期
                    String gqrq = jsonObject.getString("gqrq");
                    //用户信息图片地址
                    String tpdz = jsonObject.getString("tpdz");

                    x.image().bind(headImage, tpdz);
                    usernameTv.setText("" + zh);
                    unitnameTv.setText("" + xm);
                    if (TextUtils.equals("男", xb)) {
                        radioNan.setChecked(true);
                    } else {
                        radioNv.setChecked(true);
                    }
                    managePersonTv.setText("" + sfzh);
                    contactNameTv.setText("" + jgdwmc);
                    emailTv.setText("" + yx);
                    phoneTv.setText("" + sjhm);
                    chushengriqiTv.setText("" + csrq);
                    zhiweiTv.setText("" + zw);
                    gongzhongTv.setText("" + gw);
                    danweidizhiTv.setText("" + szdq + szdq1 + szdq2 + dz);
                    tijianbaogaibianhaoTv.setText("" + tjbgh);
                    guoqiriqiTv.setText("" + gqrq);

                }
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


    @Override
    public int getLayout() {
        return R.layout.gerenyonghu_yonghuxinxi;
    }


    @OnClick({R.id.head_image})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.head_image:
                uploadImage();
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
            if (data != null) {

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
            }

        } catch (IOException e) {
            Log.e("TAG-->Error", e.toString());

        }


        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }
}
