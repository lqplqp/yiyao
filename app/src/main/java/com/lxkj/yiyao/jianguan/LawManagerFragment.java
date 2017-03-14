package com.lxkj.yiyao.jianguan;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.LawManagerAdapter;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.utils.ToastUtil;
import com.lxkj.yiyao.view.DoubleDatePickerDialog;
import com.lxkj.yiyao.view.RefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class LawManagerFragment extends BaseFragment {
    private static final String TAG = "LawManagerFragment";
    @BindView(R.id.select)
    TextView select;
    @BindView(R.id.number)
    EditText number;
    @BindView(R.id.type)
    Spinner type;

    // ======================== 模板代码=============================

    MBaseAdapter adapter;
    @BindView(R.id.list_view)
    RefreshListView listView;
    @BindView(R.id.start_time)
    TextView startTime;
    @BindView(R.id.end_time)
    TextView endTime;
    private int page = 1;

    private ArrayAdapter<String> mSpinnerAdapter;
    private int userType;


    @Override
    protected void initView() {


        initSpinner();


        Log.i("BaseFragment" , "initView");
        requestData(null);


        listView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onDownPullRefresh() {


                adapter.clear();
                adapter.notifyDataSetChanged();
                page = 1;


                requestData(null);


            }

            @Override
            public void onLoadingMore() {


                requestData(null);


            }
        });


    }
    // ======================== 模板代码=============================


    // ======================== 模板代码=============================
    public void requestData(String s) {
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.jg_zfjlgl);
        params.addBodyParameter("page", page + "");
        // TODO: 2017/3/14 0014 传递下拉参数 
        params.addBodyParameter("","");

        if (s != null) {
            params.addBodyParameter("cx", s);
        }


        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if (adapter == null) {
                    adapter = new LawManagerAdapter(result);
                    listView.setAdapter(adapter);
                } else {
                    listView.setAdapter(adapter);
                    adapter.addData(result);
                    listView.deferNotifyDataSetChanged();
                }
                page++;

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
                listView.onRefreshComplete();
                listView.loadMoreComplete();
            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }


    // ======================== 模板代码=============================

    @Override
    public int getLayout() {
        return R.layout.jg_fragment_layout_law_update;
    }


    @OnClick(R.id.select)
    public void onClick() {

        if (adapter != null) {
            adapter.clear();
            adapter.notifyDataSetChanged();
            page = 1;
        }
        requestData(null);
    }




    @OnClick({R.id.start_time, R.id.end_time})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_time:
                startTime.setOnClickListener(new View.OnClickListener() {
                    Calendar c = Calendar.getInstance();
                    @Override
                    public void onClick(View view) {
                        // 最后一个false表示不显示日期，如果要显示日期，最后参数可以是true或者不用输入
                        new DoubleDatePickerDialog(getContext(), 0, new DoubleDatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker startDatePicker, int startYear, int startMonthOfYear,
                                                  int startDayOfMonth) {
                                String textString = String.format("%d-%d-%d", startYear,
                                        startMonthOfYear + 1, startDayOfMonth);
                                startTime.setText(textString);
                            }
                        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), true).show();
                    }
                });
                break;
            case R.id.end_time:
                endTime.setOnClickListener(new View.OnClickListener() {
                    Calendar c = Calendar.getInstance();
                    @Override
                    public void onClick(View view) {
                        // 最后一个false表示不显示日期，如果要显示日期，最后参数可以是true或者不用输入
                        new DoubleDatePickerDialog(getContext(), 0, new DoubleDatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker startDatePicker, int startYear, int startMonthOfYear,
                                                  int startDayOfMonth) {
                                String textString = String.format("%d-%d-%d", startYear,
                                        startMonthOfYear + 1, startDayOfMonth);
                                endTime.setText(textString);
                            }
                        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), true).show();
                    }
                });
                break;
        }
    }


    private List<String> selects = new ArrayList<String>();


    private void initSpinner() {

        selects.add("行政许可");
        selects.add("行政处罚");
        selects.add("行政强制");
        selects.add("行政确认");
        selects.add("行政奖励");
        selects.add("其他行政权力");

        mSpinnerAdapter = new ArrayAdapter<String>(getActivity(),R.layout.spinner_item,selects);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        type.setAdapter(mSpinnerAdapter);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        type.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                userType = (int) arg3;
                /* 将mySpinner 显示*/
                //arg0.setVisibility(View.VISIBLE);
                ToastUtil.show("  " + userType);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                //arg0.setVisibility(View.VISIBLE);
                ToastUtil.show("12332");
            }
        });

    }
}
