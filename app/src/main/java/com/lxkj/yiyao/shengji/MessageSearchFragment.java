package com.lxkj.yiyao.shengji;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.shengji.adapter.MessageSearchAdapter;
import com.lxkj.yiyao.utils.SPUtil;
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

public class MessageSearchFragment extends BaseFragment {

    // ======================== 模板代码=============================

    MessageSearchAdapter adapter;
    @BindView(R.id.list_view)
    RefreshListView listView;
    @BindView(R.id.chaxun)
    TextView chaxun;
    @BindView(R.id.faqidanwei)
    EditText faqidanwei;
    @BindView(R.id.peixuntongzhileixing)
    Spinner peixuntongzhileixing;
    @BindView(R.id.xingzhengleixing)
    Spinner xingzhengleixing;
    @BindView(R.id.peixunbanleixing)
    Spinner peixunbanleixing;
    private int page = 1;

    private String TAG = "CompanyManageyFragment";
    private ArrayAdapter<String> mSpinnerAdapter;
    private String peixuntongzhileixingType;
    private String xingzhengleixingType;
    private String peixunbanleixingType;

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
    public void requestData(String mfaqidanwei, String mpeixuntongzhileixing,String mxingzhengleixing,String mpeixunbanleixing) {
        RequestParams params = new RequestParams("http://af.0101hr.com/admin/fenji1/tzxx");
        params.addBodyParameter("page", page + "");

        params.addBodyParameter("fqdw",mfaqidanwei);
        params.addBodyParameter("pxtzlx" ,mpeixuntongzhileixing);
        params.addBodyParameter("hylx",mxingzhengleixing);
        params.addBodyParameter("pxblx",mpeixunbanleixing);

        params.addBodyParameter("username", SPUtil.getUserName(getContext()));

        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if (adapter == null) {
                    adapter = new MessageSearchAdapter(result);
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
        return R.layout.sjgr_fragment_layout_message_search;
    }


    @OnClick(R.id.chaxun)
    public void onClick() {
        if(adapter!=null){
            adapter.clear();
            adapter.notifyDataSetChanged();
            page=1;
        }
        requestData(faqidanwei.getText().toString(),
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
