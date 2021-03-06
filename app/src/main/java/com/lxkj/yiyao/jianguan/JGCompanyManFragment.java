package com.lxkj.yiyao.jianguan;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.CompanyManagerAdapter;
import com.lxkj.yiyao.jianguan.adapter.JGCompanyManAdapter;
import com.lxkj.yiyao.utils.SPUtil;
import com.lxkj.yiyao.view.RefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/1/18.
 */
// 我做一个你看看
public class JGCompanyManFragment extends BaseFragment {
    private  final String TAG = this.getClass().getSimpleName();
    @BindView(R.id.select)
    TextView select;
    @BindView(R.id.input_name)
    EditText inputName;
    @BindView(R.id.add)
    TextView add;
    @BindView(R.id.list_view)
    RefreshListView listView;

    private JGCompanyManAdapter adapter;
    private int page = 1;

    // ======================== 模板代码=============================
    @Override
    protected void initView() {


        requestData(null);

        listView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onDownPullRefresh() {


                adapter.clear();
                adapter.notifyDataSetChanged();
                page=1;


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
    public void requestData(String s){
        // TODO 修改接口地址和参数
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.jg_jgdwgl);
        params.addBodyParameter("page",page+"");
        params.addBodyParameter("username", SPUtil.getUserName(getContext()));
        if(s!=null){
            params.addBodyParameter("xx",s);
        }

        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if(adapter == null){
                    adapter = new JGCompanyManAdapter(result);
                    listView.setAdapter(adapter);
                }else{
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
        return R.layout.jg_fragment_layout_jiangguanrenyuan;
    }

    @OnClick({R.id.select, R.id.add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.select:
                toast("查询");
                // TODO: 2017/1/18 完善查询
                if(adapter!=null){
                    adapter.clear();
                    adapter.notifyDataSetChanged();
                    page=1;
                }
                requestData(inputName.getText().toString());
                break;
            case R.id.add:
                toast("添加");
                // TODO: 2017/1/18
                Intent intent = new Intent(getActivity(),JianGuanAddGuanLiYuanActivity.class);
                startActivity(intent);
                break;
        }
    }




}
