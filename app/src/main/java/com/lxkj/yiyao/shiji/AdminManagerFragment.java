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
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.shiji.adapter.AdminManagerAdapter;
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
 * Created by Administrator on 2017/1/18 0018.
 */

public class AdminManagerFragment extends BaseFragment {

    public String TAG = this.getClass().getSimpleName();


    // ======================== 模板代码=============================

    MBaseAdapter adapter;
    @BindView(R.id.chaxun)
    TextView chaxun;
    @BindView(R.id.souguoneirong)
    EditText sousuoneirong;
    @BindView(R.id.start_time)
    EditText startTime;
    @BindView(R.id.end_time)
    EditText endTime;
    @BindView(R.id.add)
    TextView add;
    @BindView(R.id.list_view)
    RefreshListView listView;

    private int page = 1;


    @Override
    protected void initView() {

        requestData(null, null, null);


        listView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onDownPullRefresh() {


                adapter.clear();
                adapter.notifyDataSetChanged();
                page = 1;


                requestData(null, null, null);


            }

            @Override
            public void onLoadingMore() {


                requestData(null, null, null);


            }
        });


    }
    // ======================== 模板代码=============================


    // ======================== 模板代码=============================
    public void requestData(String xx, String sj1, String sj2) {
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.shiji_jgrygl);
        params.addBodyParameter("page", page + "");
        if (xx != null && sj1 != null && sj2 != null) {
            params.addBodyParameter("xx", xx);
            params.addBodyParameter("sj1", sj1);
            params.addBodyParameter("sj2", sj2);
        }

        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if (adapter == null) {
                    adapter = new AdminManagerAdapter(result);
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
        return R.layout.shiji_fragment_layout_jianguanmanager;
    }


    @OnClick({R.id.start_time, R.id.end_time, R.id.chaxun, R.id.add})
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
            case R.id.chaxun:
                toast("查询");
                // TODO: 2017/1/18
                if (adapter != null) {
                    adapter.clear();
                    adapter.notifyDataSetChanged();
                    page = 1;
                }
                requestData(sousuoneirong.getText().toString(),
                        startTime.getText().toString(),
                        endTime.getText().toString());

                break;
            case R.id.add:
                toast("新增");
                break;
        }
    }
}
