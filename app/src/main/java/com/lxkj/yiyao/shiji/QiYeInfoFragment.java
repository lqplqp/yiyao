package com.lxkj.yiyao.shiji;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class QiYeInfoFragment extends BaseFragment {
    public String TAG = this.getClass().getSimpleName();

    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.danweimingcheng)
    TextView danweimingcheng;
    @BindView(R.id.congyerenshu)
    TextView congyerenshu;
    @BindView(R.id.guanliyuanrenshu)
    TextView guanliyuanrenshu;
    @BindView(R.id.guanliyuan)
    TextView guanliyuan;
    @BindView(R.id.dianhuan)
    TextView dianhuan;
    @BindView(R.id.zhiwu)
    TextView zhiwu;
    @BindView(R.id.youxiang)
    TextView youxiang;
    @BindView(R.id.hangyelingyu)
    TextView hangyelingyu;
    @BindView(R.id.suozaidiqu)
    TextView suozaidiqu;
    @BindView(R.id.danweidizhi)
    TextView danweidizhi;
    @BindView(R.id.commit)
    Button commit;
    Unbinder unbinder;

    @Override
    protected void initView() {
        requestData(null);
    }

    public void requestData(String s){
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.shiji_qygl);

        if(s!=null){
            params.addBodyParameter("cx",s);
        }

        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public boolean onCache(String result) {
                return false;
            }

            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);

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

            }


        });
    }


    @Override
    public int getLayout() {
        return R.layout.shiji_fragment_layout_qyinfo_chakan;
    }



    @OnClick(R.id.commit)
    public void onClick() {
        toast("查询");

        requestData(null);

    }
}
