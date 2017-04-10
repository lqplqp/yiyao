package com.lxkj.yiyao.qiye;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.utils.PickViewUtils;
import com.lxkj.yiyao.utils.SPUtil;
import com.lxkj.yiyao.utils.ToastUtil;
import com.lxkj.yiyao.view.DoubleDatePickerDialog;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/3/6 0006.
 */

public class ZengJiaRenYuanActivity extends BaseActivity {


    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.xingming)
    EditText xingming;
    @BindView(R.id.nan)
    RadioButton nan;
    @BindView(R.id.nv)
    RadioButton nv;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.tijianxinxibianhao)
    EditText tijianxinxibianhao;
    @BindView(R.id.tijianxinxiyouxiaoqi)
    TextView tijianxinxiyouxiaoqi;
    @BindView(R.id.peixunzhenghao)
    EditText peixunzhenghao;
    @BindView(R.id.peixunzhengyouxiaoqi)
    TextView peixunzhengyouxiaoqi;
    @BindView(R.id.chushengriqi)
    TextView chushengriqi;
    @BindView(R.id.xiaoxitixing)
    EditText xiaoxitixing;
    @BindView(R.id.youxiang)
    EditText youxiang;
    @BindView(R.id.shoujihaoma)
    EditText shoujihaoma;
    @BindView(R.id.shenfenzhenghao)
    EditText shenfenzhenghao;
    @BindView(R.id.zhiwu)
    Spinner zhiwu;
    @BindView(R.id.xueli)
    Spinner xueli;
    @BindView(R.id.xiangxidizhi)
    TextView xiangxidizhi;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.gangwei)
    EditText gangwei;
    @BindView(R.id.dizhi_et)
    EditText dizhiEt;
    private String userName;
    private String zhiwuString;
    private String xueliString;

    @Override
    protected void init() {
        userName = SPUtil.getUserName(this);
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tijianxinxiyouxiaoqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                // 最后一个false表示不显示日期，如果要显示日期，最后参数可以是true或者不用输入
                new DoubleDatePickerDialog(ZengJiaRenYuanActivity.this, 0, new DoubleDatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker startDatePicker, int startYear, int startMonthOfYear, int startDayOfMonth) {
                        String textString = String.format("%d-%d-%d", startYear,
                                startMonthOfYear + 1, startDayOfMonth);
                        tijianxinxiyouxiaoqi.setText(textString);
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), true).show();
            }
        });
        peixunzhengyouxiaoqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                // 最后一个false表示不显示日期，如果要显示日期，最后参数可以是true或者不用输入
                new DoubleDatePickerDialog(ZengJiaRenYuanActivity.this, 0, new DoubleDatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker startDatePicker, int startYear, int startMonthOfYear, int startDayOfMonth) {
                        String textString = String.format("%d-%d-%d", startYear,
                                startMonthOfYear + 1, startDayOfMonth);
                        peixunzhengyouxiaoqi.setText(textString);
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), true).show();
            }
        });
        chushengriqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                // 最后一个false表示不显示日期，如果要显示日期，最后参数可以是true或者不用输入
                new DoubleDatePickerDialog(ZengJiaRenYuanActivity.this, 0, new DoubleDatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker startDatePicker, int startYear, int startMonthOfYear, int startDayOfMonth) {
                        String textString = String.format("%d-%d-%d", startYear,
                                startMonthOfYear + 1, startDayOfMonth);
                        chushengriqi.setText(textString);
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), true).show();
            }
        });
        zhiwu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                zhiwuString = getResources().getStringArray(R.array.qiye_zhiwu)[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        xueli.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                xueliString = getResources().getStringArray(R.array.qiye_xueli)[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        xiangxidizhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PickViewUtils(ZengJiaRenYuanActivity.this, xiangxidizhi).pickProvince();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestDate();
            }
        });
    }

    private void requestDate() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + "/admin/qita1/qyryxz");
        params.addBodyParameter("username", userName);
        params.addBodyParameter("yhxm", xingming.getText() + "");
        if (nan.isChecked()) {
            params.addBodyParameter("xb", "男");
        } else if (nv.isChecked()) {
            params.addBodyParameter("xb", "女");
        }
        params.addBodyParameter("tjxxbh", tijianxinxibianhao.getText() + "");
        params.addBodyParameter("tjxxyxq", tijianxinxiyouxiaoqi.getText() + "");
        params.addBodyParameter("pxzh", peixunzhenghao.getText() + "");
        params.addBodyParameter("pxzyxq", peixunzhengyouxiaoqi.getText() + "");
        params.addBodyParameter("csrq", chushengriqi.getText() + "");
        params.addBodyParameter("yx", youxiang.getText() + "");
        params.addBodyParameter("sjhm", shoujihaoma.getText() + "");
        params.addBodyParameter("zw", zhiwuString + "");
        params.addBodyParameter("sfzh", shenfenzhenghao.getText() + "");
        params.addBodyParameter("gw", gangwei.getText() + "");
        params.addBodyParameter("xl", xueliString + "");
        String xiangxidizhiText = xiangxidizhi.getText().toString();
        if (!TextUtils.isEmpty(xiangxidizhiText)){
            String[] split = xiangxidizhiText.split("-");
            params.addBodyParameter("szdq", split[0] + "");
            params.addBodyParameter("szdq1", split[1] + "");
            params.addBodyParameter("szdq2", split[2] + "");
        }
        params.addBodyParameter("dz", dizhiEt.getText() + "");


        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JSONObject object = JSONObject.parseObject(result);
                String code = object.get("code").toString();
                if (code.equals("111111")) {
                    ToastUtil.show("提交成功");
                    finish();
                }else {
                    ToastUtil.show("提交失败");
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
        return R.layout.qiye_zengjiarenyuan_layout;
    }


    @OnClick(R.id.register)
    public void onClick() {
        requestDate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
