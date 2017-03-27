package com.lxkj.yiyao.xianji;

import android.widget.Button;
import android.widget.EditText;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/3/16.
 */

public class XianJiYongHuXinXiFragment extends BaseFragment {
    @BindView(R.id.username_tv)
    EditText usernameTv;
    @BindView(R.id.commit)
    Button commit;
    Unbinder unbinder;
    private String username;

    @Override
    protected void initView() {
        usernameTv.setText("eee");
    }

    @Override
    public int getLayout() {
        return R.layout.xianjiyonghu_yonghuxinxi;
    }

    @OnClick(R.id.commit)
    public void onClick() {
        ToastUtil.show("修改成功");
    }
}
