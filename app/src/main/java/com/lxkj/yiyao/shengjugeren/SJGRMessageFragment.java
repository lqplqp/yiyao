package com.lxkj.yiyao.shengjugeren;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioButton;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.gerenyonghu.Adapter.GrenYongHuShouYePeiXunBanAdapter;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.shengjugeren.Adapter.SJGRGongShigongGaoAdapter;
import com.lxkj.yiyao.shengjugeren.Adapter.SJGRShouYePeiXunBanAdapter;
import com.lxkj.yiyao.shengjugeren.Adapter.SJGRShouYeTongZhiAdapter;
import com.lxkj.yiyao.utils.SPUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/1/19.
 */

public class SJGRMessageFragment extends BaseFragment {
    @BindView(R.id.list_view)
    ListView listView;
    @BindView(R.id.grid_view)
    GridView gridView;
    @BindView(R.id.rb_1)
    RadioButton rb1;
    @BindView(R.id.rb_2)
    RadioButton rb2;
    @BindView(R.id.list_view1)
    ListView listView1;
    Unbinder unbinder;

    private BaseAdapter tongZhiAdapter;
    private BaseAdapter sjgrGongShigongGaoAdapter;
    private BaseAdapter peiXunBanListAdapter;
    private static int userType;

    private void hide1() {
        rb1.setChecked(false);
        rb1.setChecked(false);
        rb1.setBackgroundResource(R.drawable.fillet_white_bg);
        rb2.setBackgroundResource(R.drawable.fillet_white_bg);
    }

    @Override
    protected void initView() {
        String url = "/admin/fenji2/sy";
        requestDate(url);
    }

    private void requestDate(String s) {
        RequestParams params = new RequestParams(GlobalString.BaseURL + s);
        params.addBodyParameter("username", SPUtil.getUserName(getContext()));
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                JSONObject jsonObject = JSONObject.parseObject(result);
                String tongzhixiaoxi = jsonObject.get("tzxx").toString();
                String gongshigonggao = jsonObject.get("gsgg").toString();
                String peixunbanxinxi = jsonObject.get("pxxx").toString();
                //通知消息
                tongZhiAdapter = new SJGRShouYeTongZhiAdapter(tongzhixiaoxi);
                listView.setAdapter(tongZhiAdapter);


                userType = -1;
                //培训课程
                peiXunBanListAdapter = new SJGRShouYePeiXunBanAdapter(userType, peixunbanxinxi, getActivity());
                gridView.setAdapter(peiXunBanListAdapter);
                //公示公告
                sjgrGongShigongGaoAdapter = new SJGRGongShigongGaoAdapter(gongshigonggao);
                listView1.setAdapter(sjgrGongShigongGaoAdapter);
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
        return R.layout.sjgr_fragment_layout_message;
    }

    @OnClick({R.id.rb_1, R.id.rb_2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_1:
                hide1();
                rb1.setBackgroundResource(R.drawable.blue_but_bg);
                rb1.setTextColor(getResources().getColor(R.color.white));
                rb2.setTextColor(getResources().getColor(R.color.global_black));
                requestDate("/admin/fenji2/sy");
                break;
            case R.id.rb_2:
                hide1();
                rb2.setBackgroundResource(R.drawable.blue_but_bg);
                rb2.setTextColor(getResources().getColor(R.color.white));
                rb1.setTextColor(getResources().getColor(R.color.global_black));
                requestDate("/admin/fenji2/sy1");
                break;
        }
    }


}
