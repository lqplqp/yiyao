package com.lxkj.yiyao.jianguan;

import android.media.Image;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.utils.PickViewUtils;
import com.lxkj.yiyao.utils.ToastUtil;

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
    EditText touxiangdizhi;
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

    private ArrayAdapter<String> mSpinnerAdapter;
    private String guanliyuanleixingtType;
    private String hangyelingyuType;

    @Override
    protected void init() {
        initSpinner1();
        initSpinner2();
        /*backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });*/
    }

    @Override
    public int getLayout() {
        return R.layout.jianguan_add_guanliyuan;
    }

    @OnClick({R.id.add_touxiang, R.id.danweidizhi, R.id.commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_touxiang:
                ToastUtil.show("接口待对接");
                break;
            case R.id.danweidizhi:
                new PickViewUtils(this, danweidizhi).pickProvince();
                break;
            case R.id.commit:
                ToastUtil.show("借口待对接");
                commitInfo();

                break;
        }
    }

    private void commitInfo() {
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
                guanliyuanleixingtType = selects.get((int)arg3);
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
                hangyelingyuType = selects.get((int)arg3);
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
}
