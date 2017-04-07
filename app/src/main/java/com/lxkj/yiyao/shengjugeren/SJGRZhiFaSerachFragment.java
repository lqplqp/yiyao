package com.lxkj.yiyao.shengjugeren;

import android.content.SharedPreferences;
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
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.shengjugeren.Adapter.SJGRZhiFaSearch;
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
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/1/19.
 */

public class SJGRZhiFaSerachFragment extends BaseFragment {
    public String TAG = this.getClass().getSimpleName();
    @BindView(R.id.chaxun)
    TextView chaxun;
    @BindView(R.id.zhifabianhao)
    EditText zhifabianhao;
    @BindView(R.id.star_time)
    EditText starTime;
    @BindView(R.id.end_time)
    EditText endTime;
    @BindView(R.id.list_view)
    RefreshListView listView;
    Unbinder unbinder;

    // ======================== 模板代码=============================

    private ArrayAdapter<String> mSpinnerAdapter;
    private String zhifaType;

    MBaseAdapter adapter;
    @BindView(R.id.zhifaleixing)
    Spinner type;
    Unbinder unbinder1;
    private int page = 1;


    @Override
    protected void initView() {
        initSpinner();
        requestData("", "", "", "");


        listView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onDownPullRefresh() {


                adapter.clear();
                adapter.notifyDataSetChanged();
                page = 1;


                requestData("", "", "", "");


            }

            @Override
            public void onLoadingMore() {


                requestData("", "", "", "");


            }
        });


    }
    // ======================== 模板代码=============================


    // ======================== 模板代码=============================
    public void requestData(String zhifabianhao, String zhifaleixing, String star_time, String end_time) {
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.sjgr_wdzf);
        params.addBodyParameter("page", page + "");
        if (zhifabianhao != null) {
            SharedPreferences sp = getActivity().getSharedPreferences("shiyao", getActivity().MODE_PRIVATE);
            params.addBodyParameter("username",sp.getString("username","") + "");
            params.addBodyParameter("xx", zhifabianhao);
            params.addBodyParameter("xz", zhifaleixing);
            params.addBodyParameter("sj1", star_time);
            params.addBodyParameter("sj2 ", end_time);

        }

        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if (adapter == null) {
                    adapter = new SJGRZhiFaSearch(result);
                    listView.setAdapter(adapter);
                } else {
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
        return R.layout.sjgr_fragment_layout_zhifa_search;
    }

    @OnClick({R.id.chaxun, R.id.star_time, R.id.end_time})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.chaxun:
                if (adapter != null) {
                    adapter.clear();
                    adapter.notifyDataSetChanged();
                    page = 1;
                }
                requestData(zhifabianhao.getText().toString(),
                        zhifaType,
                        starTime.getText().toString(),
                        endTime.getText().toString());

                break;
            case R.id.start_time:
                starTime.setOnClickListener(new View.OnClickListener() {
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
                                starTime.setText(textString);
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

        mSpinnerAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item, selects);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        type.setAdapter(mSpinnerAdapter);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        type.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub

                zhifaType = selects.get((int)arg3);
                /* 将mySpinner 显示*/
                //arg0.setVisibility(View.VISIBLE);
                ToastUtil.show("" + zhifaType);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                //arg0.setVisibility(View.VISIBLE);
                ToastUtil.show("12332");
            }
        });

    }
}
