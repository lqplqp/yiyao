package com.lxkj.yiyao.gerenyonghu;

import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.utils.ToastUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/3/16.
 */

public class GeRenYongHuAnQuanSheZhiFragment extends BaseFragment {

    @BindView(R.id.commit)
    Button commit;
    @BindView(R.id.old_pwd)
    EditText oldPwd;
    @BindView(R.id.new_pwd)
    EditText newPwd;
    @BindView(R.id.new_pwd2)
    EditText newPwd2;

    @Override
    protected void initView() {

    }

    @OnClick(R.id.commit)
    public void onClick() {
        SharedPreferences sp = getActivity().getSharedPreferences("shiyao", 0);
        int id = sp.getInt("id", 0);
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.gerenyonghu_anquanshezhi);
        params.addBodyParameter("ymm", oldPwd.getText().toString());
        params.addBodyParameter("xmm", newPwd.getText().toString());
        params.addBodyParameter("qrmm", newPwd2.getText().toString());
        params.addBodyParameter("id", id + "");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JSONObject jsonObject = JSONObject.parseObject(result);
                String code = jsonObject.get("code").toString();
                if (code.equals("111111")) {
                    ToastUtil.show("修改成功");
                }else {
                    ToastUtil.show("" + jsonObject.get("message"));
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                ToastUtil.show("修改失败");
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
        return R.layout.gerenyonghu_anquanshezhi;
    }
}
