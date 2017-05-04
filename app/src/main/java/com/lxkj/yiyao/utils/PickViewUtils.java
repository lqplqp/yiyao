package com.lxkj.yiyao.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;

import cn.qqtheme.framework.entity.City;
import cn.qqtheme.framework.entity.County;
import cn.qqtheme.framework.entity.Province;
import cn.qqtheme.framework.picker.AddressPicker;
import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.NumberPicker;
import cn.qqtheme.framework.picker.OptionPicker;
import cn.qqtheme.framework.picker.TimePicker;
import cn.qqtheme.framework.util.ConvertUtils;

/**
 * Created by apple on 2016/10/27.
 * 选择器工具类
 */

public class PickViewUtils {
    private Activity activity;
    private TextView textView;

    public PickViewUtils(Activity activity, TextView textView) {
        this.activity = activity;
        this.textView = textView;
    }

    //字符数组选择
    public void pickOther(String[] items) {
        OptionPicker picker = new OptionPicker(activity, items);
        picker.setOffset(1);
        picker.setSelectedIndex(0);
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(int position, String option) {
                textView.setText(option);
            }
        });
        picker.show();
    }

    //身高选择
    public void pickHeight() {
        NumberPicker picker = new NumberPicker(activity);
        picker.setOffset(2);//偏移量
        picker.setRange(130, 210, 1);//数字范围
        picker.setSelectedItem(170);
        picker.setLabel("cm");
        picker.setOnNumberPickListener(new NumberPicker.OnNumberPickListener() {
            @Override
            public void onNumberPicked(int index, Number item) {
                textView.setText(item + "cm");
            }
        });
        /*picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(int position, String option) {
                textView.setText(option + "cm");
            }
        });*/
        picker.show();
    }

    //日期选择
    public void pickDate(){
        DatePicker picker = new DatePicker(activity, DatePicker.YEAR_MONTH_DAY);
        picker.setRangeStart(1980, 1, 1);//开始范围
        picker.setRangeEnd(2025, 1, 1);//结束范围
        Calendar calendar = Calendar.getInstance();
        picker.setSelectedItem(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DATE));
        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
                textView.setText(year + "-" + month + "-" + day);
            }
        });
        picker.show();
    }
    //时间选择
    public void pickTime() {
        TimePicker picker = new TimePicker(activity, TimePicker.HOUR_24);
        picker.setRangeStart(0, 0);//
        picker.setRangeEnd(23, 59);//
        picker.setTopLineVisible(false);
        picker.setOnTimePickListener(new TimePicker.OnTimePickListener() {
            @Override
            public void onTimePicked(String hour, String minute) {

            }
        });
        picker.show();
    }

    //地区选择
    public void pickProvince() {
        try {
            ArrayList<Province> data = new ArrayList<Province>();
            InputStream inputStream = activity.getResources().getAssets().open("city.json");
            String json = ConvertUtils.toString(inputStream);
            Gson gson = new Gson();
            ArrayList<Province> list = gson.fromJson(json, new TypeToken<ArrayList<Province>>() {
            }.getType());
            data.addAll(list);
            AddressPicker picker = new AddressPicker(activity, data);
            picker.setOnAddressPickListener(new AddressPicker.OnAddressPickListener() {
                @Override
                public void onAddressPicked(Province province, City city, County county) {
                    textView.setText(province.getAreaName() + "-" + city.getAreaName() + "-" + county.getAreaName());
                }
            });
//            picker.setHideProvince(true);//加上此句举将只显示地级及县级
            //picker.setHideCounty(true);//加上此句举将只显示省级及地级
            //picker.setColumnWeight(2/8.0, 3/8.0, 3/8.0);//省级、地级和县级的比例为2:3:3
            picker.show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
