package com.lxkj.yiyao.shiji;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.shengji.adapter.TiJianSearchAdapter;
import com.lxkj.yiyao.view.DoubleDatePickerDialog;
import com.lxkj.yiyao.view.RefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/19.
 */

public class ShiJiTiJianSearchFragment extends BaseFragment {

    // ======================== 模板代码=============================

    TiJianSearchAdapter adapter;
    @BindView(R.id.list_view)
    RefreshListView listView;
    @BindView(R.id.chaxun)
    TextView select;
    @BindView(R.id.sousuoneirong)
    EditText sousuoneirong;
    @BindView(R.id.start_time)
    TextView startTime;
    @BindView(R.id.end_time)
    TextView endTime;
    private int page = 1;

    private String TAG = "ShiJiTiJianSearchFragment";


    @Override
    protected void initView() {

        requestData();
        listView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onDownPullRefresh() {


                adapter.clear();
                adapter.notifyDataSetChanged();
                page = 1;


                requestData();


            }

            @Override
            public void onLoadingMore() {


                requestData();


            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.clear();
                adapter.notifyDataSetChanged();
                page = 1;
                requestData();
            }
        });


    }
    // ======================== 模板代码=============================


    // ======================== 模板代码=============================
    public void requestData() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.shiji_tijiansearch);
        params.addBodyParameter("page", page + "");
        params.addBodyParameter("xx", sousuoneirong.getText() + "");


        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if (adapter == null) {
                    adapter = new TiJianSearchAdapter(result);
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
        return R.layout.sjgr_fragment_layout_tijian_search;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
