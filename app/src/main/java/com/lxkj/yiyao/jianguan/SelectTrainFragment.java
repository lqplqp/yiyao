package com.lxkj.yiyao.jianguan;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.activity.adapter.SelectTrainAdapter;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;

/**
 * Created by liqinpeng on 2017/3/13 0013.
 */

public class SelectTrainFragment extends BaseFragment {
    @BindView(R.id.rb_1_1)
    RadioButton rb11;
    @BindView(R.id.rb_1_2)
    RadioButton rb12;
    @BindView(R.id.rb_2_1)
    RadioButton rb21;
    @BindView(R.id.rb_2_2)
    RadioButton rb22;
    @BindView(R.id.rb_2_3)
    RadioButton rb23;
    @BindView(R.id.rb_3_1)
    RadioButton rb31;
    @BindView(R.id.rb_3_2)
    RadioButton rb32;
    @BindView(R.id.grid_view)
    GridView gridView;
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.top)
    RelativeLayout top;

    private String lingyu = "";
    private String leibie = "";
    private String guize = "1";
    private ProgressDialog progressDialog;


    private void hide1() {
        rb11.setChecked(false);
        rb12.setChecked(false);
        rb11.setBackgroundResource(R.drawable.fillet_white_bg);
        rb12.setBackgroundResource(R.drawable.fillet_white_bg);
    }

    private void hide2() {
        rb21.setChecked(false);
        rb22.setChecked(false);
        rb23.setChecked(false);
        rb21.setBackgroundResource(R.drawable.fillet_white_bg);
        rb22.setBackgroundResource(R.drawable.fillet_white_bg);
        rb23.setBackgroundResource(R.drawable.fillet_white_bg);
    }

    private void hide3() {
        rb31.setChecked(false);
        rb32.setChecked(false);
        rb31.setBackgroundResource(R.drawable.fillet_white_bg);
        rb32.setBackgroundResource(R.drawable.fillet_white_bg);
    }

    protected void init() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("正在加载...");
        progressDialog.setCanceledOnTouchOutside(false);
        requestDate();


        {
            rb11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hide1();
                    rb11.setBackgroundResource(R.drawable.blue_but_bg);
                    rb11.setTextColor(getResources().getColor(R.color.white));
                    rb12.setTextColor(getResources().getColor(R.color.global_black));
                    lingyu = "";
                    progressDialog.show();
                    requestDate();
                }
            });
            rb12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hide1();
                    rb12.setBackgroundResource(R.drawable.blue_but_bg);
                    rb12.setTextColor(getResources().getColor(R.color.white));
                    rb11.setTextColor(getResources().getColor(R.color.global_black));
                    lingyu = "1";
                    progressDialog.show();
                    requestDate();
                }
            });

            rb21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hide2();
                    rb21.setBackgroundResource(R.drawable.blue_but_bg);
                    rb21.setTextColor(getResources().getColor(R.color.white));
                    rb22.setTextColor(getResources().getColor(R.color.global_black));
                    rb23.setTextColor(getResources().getColor(R.color.global_black));
                    leibie = "";
                    progressDialog.show();
                    requestDate();
                }
            });
            rb22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hide2();
                    rb22.setBackgroundResource(R.drawable.blue_but_bg);
                    rb22.setTextColor(getResources().getColor(R.color.white));
                    rb21.setTextColor(getResources().getColor(R.color.global_black));
                    rb23.setTextColor(getResources().getColor(R.color.global_black));
                    leibie = "1";
                    progressDialog.show();
                    requestDate();
                }
            });
            rb23.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hide2();
                    rb23.setBackgroundResource(R.drawable.blue_but_bg);
                    rb23.setTextColor(getResources().getColor(R.color.white));
                    rb21.setTextColor(getResources().getColor(R.color.global_black));
                    rb22.setTextColor(getResources().getColor(R.color.global_black));
                    leibie = "2";
                    progressDialog.show();
                    requestDate();
                }
            });

            rb31.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hide3();
                    rb31.setBackgroundResource(R.drawable.blue_but_bg);
                    rb31.setTextColor(getResources().getColor(R.color.white));
                    rb32.setTextColor(getResources().getColor(R.color.global_black));
                    guize = "1";
                    progressDialog.show();
                    requestDate();
                }
            });
            rb32.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hide3();
                    rb32.setBackgroundResource(R.drawable.blue_but_bg);
                    rb32.setTextColor(getResources().getColor(R.color.white));
                    rb31.setTextColor(getResources().getColor(R.color.global_black));
                    guize = "2";
                    progressDialog.show();
                    requestDate();
                }
            });
        }


    }

    private void requestDate() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + "/admin/fenji5/pxbm");
        params.addBodyParameter("lingyu", lingyu);
        params.addBodyParameter("leibie", leibie);
        params.addBodyParameter("guize", guize);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                SelectTrainAdapter adapter = new SelectTrainAdapter(result, getActivity());
                adapter.setQiye_admin(true);
                gridView.setAdapter(adapter);
                progressDialog.dismiss();

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                ex.printStackTrace();
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(CancelledException cex) {
                progressDialog.dismiss();
            }

            @Override
            public void onFinished() {
                progressDialog.dismiss();
            }
        });

    }

    @Override
    protected void initView() {
        top.setVisibility(View.GONE);
        init();
    }

    @Override
    public int getLayout() {
        return R.layout.shiji_fragment_layout_select_train;
    }


}
