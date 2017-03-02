package com.lxkj.yiyao.jianguan;

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
    @BindView(R.id.back)
    TextView back;
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




        listView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onDownPullRefresh() {


                adapter.clear();
                adapter.notifyDataSetChanged();
                page=1;


                requestData();


            }

            @Override
            public void onLoadingMore() {


                requestData();



            }
        });


    }
    // ======================== 模板代码=============================

    // ======================== 模板代码=============================
    public void requestData(){
        // TODO 修改接口地址和参数
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.fenji);
        params.addBodyParameter("page",page+"");

        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                if(adapter == null){
                    adapter = new JGCompanyManAdapter(result);
                    listView.setAdapter(adapter);
                }else{
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

    @OnClick({R.id.select, R.id.back, R.id.add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.select:
                toast("查询");
                // TODO: 2017/1/18 完善查询 
                break;
            case R.id.back:
                toast("返回");
                // TODO: 2017/1/18  
                break;
            case R.id.add:
                toast("添加");
                // TODO: 2017/1/18  
                break;
        }
    }




}
