package com.lxkj.yiyao.tijian;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.utils.SPUtil;
import com.lxkj.yiyao.utils.ToastUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liqinpeng on 2017/5/2 0002.
 *
 * @author 李秦鹏
 *         -------------------------------
 */

public class UpdateHospatilFragment extends BaseFragment {
    @BindView(R.id.tijianjigoumingcheng)
    EditText tijianjigoumingcheng;
    @BindView(R.id.tijianjigoudizhi)
    EditText tijianjigoudizhi;
    @BindView(R.id.faren)
    EditText faren;
    @BindView(R.id.dianhua)
    EditText dianhua;
    @BindView(R.id.tijianjigouxukezheng)
    EditText tijianjigouxukezheng;
    @BindView(R.id.commit_but)
    Button commitBut;

    @Override
    protected void initView() {
        requestDataInfo();
    }

    @Override
    public int getLayout() {
        return R.layout.update_hospatil;
    }



    @OnClick(R.id.commit_but)
    public void onClick() {
        requestData();
    }


    void requestDataInfo(){
        RequestParams params = new RequestParams("http://af.0101hr.com/admin/fenji6/tjyyxx");
        params.addBodyParameter("username", SPUtil.getUserName(getContext()));
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JSONObject json = JSONObject.parseObject(result);
                //Object data1 = json.get("data");

                //JSONObject data = json.getJSONObject("data");
                JSONArray jsonArray = json.getJSONArray("data");
                JSONObject jsonObject = jsonArray.getJSONObject(0);

                tijianjigoumingcheng.setText("" + jsonObject.get("tjglmc"));
                tijianjigoudizhi.setText("" + jsonObject.get("tjjgdz"));
                faren.setText("" + jsonObject.get("fr"));
                dianhua.setText("" + jsonObject.get("lxdh"));
                tijianjigouxukezheng.setText("" + jsonObject.get("tjjgxkz"));
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

    private void requestData() {
        RequestParams params = new RequestParams("http://af.0101hr.com/admin/fenji6/uptjyyxx");
        params.addBodyParameter("username", SPUtil.getUserName(getContext()));
        params.addBodyParameter("tjjgmc",tijianjigoumingcheng.getText().toString());
        params.addBodyParameter("tjjgdz",tijianjigoudizhi.getText().toString());
        params.addBodyParameter("fr",faren.getText().toString());
        params.addBodyParameter("lxdh",dianhua.getText().toString());
        params.addBodyParameter("tjjgxkz",tijianjigouxukezheng.getText().toString());
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                String s = result;
                JSONObject jsonObject = JSONObject.parseObject(result);
                ToastUtil.show("" + jsonObject.get("message"));
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
}
