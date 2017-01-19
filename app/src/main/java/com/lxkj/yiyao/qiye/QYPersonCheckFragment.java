package com.lxkj.yiyao.qiye;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/19.
 */

public class QYPersonCheckFragment extends BaseFragment {


    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.id_number)
    EditText idNumber;
    @BindView(R.id.next)
    Button next;
    @BindView(R.id.back)
    Button back;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.qy_fragment_layout_person_manage_check;
    }


    @OnClick({R.id.next, R.id.back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next:
                toast("上一步");// TODO: 2017/1/19  
                break;
            case R.id.back:
                toast("下一步");//// TODO: 2017/1/19
                break;
        }
    }
}
