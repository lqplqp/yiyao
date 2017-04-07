package com.lxkj.yiyao.qiye;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.CompanyManagerFragment;
import com.lxkj.yiyao.jianguan.adapter.CompanyManagerAdapter;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.qiye.adapter.QYMessageSearchAdapter;
import com.lxkj.yiyao.utils.ToastUtil;
import com.lxkj.yiyao.view.RefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/19.
 */

public class QYMessageSearchFragment extends BaseFragment {
    private static final String TAG = "QYMessageSearchFragment";
    @BindView(R.id.select)
    TextView select;
    @BindView(R.id.company)
    EditText company;

    @BindView(R.id.message_type)
    Spinner peixuntongzhileixing;
    @BindView(R.id.administrative_type)
    Spinner xingzhengleixing;
    @BindView(R.id.train_type)
    Spinner peixunbanleixing;

    private String peixuntongzhileixingType;
    private String xingzhengleixingType;
    private String peixunbanleixingType;
    private ArrayAdapter<String> mSpinnerAdapter;
    // ======================== 模板代码=============================

    MBaseAdapter adapter;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.list_view)
    RefreshListView listView;
    private int page = 1;


    @Override
    protected void initView() {
        initSpinner1();
        initSpinner2();
        initSpinner3();
        requestData(null,null,null,null);

        listView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onDownPullRefresh() {


                adapter.clear();
                adapter.notifyDataSetChanged();
                page = 1;


                requestData(null,null,null,null);


            }

            @Override
            public void onLoadingMore() {


                requestData(null,null,null,null);


            }
        });


    }
    // ======================== 模板代码=============================


    // ======================== 模板代码=============================
    public void requestData(String s,String peixunyongzhi,String xingzheng,String peixunban) {
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.qiye_tongzhixiaoxi);
        params.addBodyParameter("page", page + "");

        SharedPreferences sp = getActivity().getSharedPreferences("shiyao", getActivity().MODE_PRIVATE);
        params.addBodyParameter("username",sp.getString("username","") + "");
        if(s!=null){
            params.addBodyParameter("fqdw",s);
            params.addBodyParameter("pxtzlx",peixunyongzhi);
            params.addBodyParameter("hylx",xingzheng);
            params.addBodyParameter("pxblx",peixunban);
        }

        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if (adapter == null) {
                    adapter = new QYMessageSearchAdapter(result);
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
        return R.layout.qy_fragment_layout_message_search;
    }


    @OnClick(R.id.select)
    public void onClick() {
        toast("查询");// TODO: 2017/1/19
        requestData(company.getText().toString(),
                peixuntongzhileixingType,
                xingzhengleixingType,
                peixunbanleixingType);
    }
    private void initSpinner1() {
        final List<String> selects = new ArrayList<String>();
        selects.add("食品安全管理员生产领域");
        selects.add("食品安全管理员流通领域");
        selects.add("食品安全管理员餐饮领域");
        selects.add("食品从业人员生产领域");
        selects.add("食品从业人员流通领域");
        selects.add("食品从业人员餐饮领域");

        mSpinnerAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item, selects);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        peixuntongzhileixing.setAdapter(mSpinnerAdapter);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        peixuntongzhileixing.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                peixuntongzhileixingType = selects.get((int)arg3);
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
        selects.add("食品");
        selects.add("药品");
        selects.add("化妆品");
        selects.add("保健品");
        selects.add("医疗器械");
        selects.add("监管队伍");

        mSpinnerAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item, selects);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        xingzhengleixing.setAdapter(mSpinnerAdapter);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        xingzhengleixing.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                xingzhengleixingType = selects.get((int)arg3);
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
    private void initSpinner3() {
        final List<String> selects = new ArrayList<String>();
        selects.add("集中培训");
        selects.add("网上培训");

        mSpinnerAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item, selects);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        peixunbanleixing.setAdapter(mSpinnerAdapter);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        peixunbanleixing.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                peixunbanleixingType = selects.get((int)arg3);
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
