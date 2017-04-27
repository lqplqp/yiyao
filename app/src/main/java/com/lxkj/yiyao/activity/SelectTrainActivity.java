package com.lxkj.yiyao.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.activity.adapter.SelectTrainAdapter;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.global.GlobalString;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liqinpeng on 2017/3/8 0008.
 */

public class SelectTrainActivity extends BaseActivity {
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
    @BindView(R.id.rb_1_3)
    RadioButton rb13;
    @BindView(R.id.rb_1_4)
    RadioButton rb14;
    @BindView(R.id.rb_1_5)
    RadioButton rb15;
    @BindView(R.id.rb_1_6)
    RadioButton rb16;
    @BindView(R.id.rb_1_7)
    RadioButton rb17;
    @BindView(R.id.rb_2_4)
    RadioButton rb24;
    @BindView(R.id.rb_2_5)
    RadioButton rb25;
    @BindView(R.id.rb_2_6)
    RadioButton rb26;
    @BindView(R.id.rb_2_7)
    RadioButton rb27;

    private boolean qiye_admin;

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

        bt1s.add(rb11);
        bt1s.add(rb12);
        bt1s.add(rb13);
        bt1s.add(rb14);
        bt1s.add(rb15);
        bt1s.add(rb16);
        bt1s.add(rb17);


        bt2s.add(rb21);
        bt2s.add(rb22);
        bt2s.add(rb23);
        bt2s.add(rb24);
        bt2s.add(rb25);
        bt2s.add(rb26);
        bt2s.add(rb27);


        progressDialog = new ProgressDialog(this);
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
                    setCheckedToTrue(0);
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
                    setCheckedToTrue(1);
                    progressDialog.show();
                    requestDate();
                }
            });

            rb13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hide1();

                    rb13.setBackgroundResource(R.drawable.blue_but_bg);
                    rb13.setTextColor(getResources().getColor(R.color.white));
                    rb11.setTextColor(getResources().getColor(R.color.global_black));
                    lingyu = "2";
                    setCheckedToTrue(2);
                    progressDialog.show();
                    requestDate();
                }
            });

            rb14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hide1();
                    rb14.setBackgroundResource(R.drawable.blue_but_bg);
                    rb14.setTextColor(getResources().getColor(R.color.white));
                    rb11.setTextColor(getResources().getColor(R.color.global_black));
                    lingyu = "3";
                    setCheckedToTrue(3);
                    progressDialog.show();
                    requestDate();
                }
            });
            rb15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hide1();
                    rb15.setBackgroundResource(R.drawable.blue_but_bg);
                    rb15.setTextColor(getResources().getColor(R.color.white));
                    rb11.setTextColor(getResources().getColor(R.color.global_black));
                    lingyu = "4";
                    setCheckedToTrue(4);
                    progressDialog.show();
                    requestDate();
                }
            });
            rb16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hide1();
                    rb16.setBackgroundResource(R.drawable.blue_but_bg);
                    rb16.setTextColor(getResources().getColor(R.color.white));
                    rb11.setTextColor(getResources().getColor(R.color.global_black));
                    lingyu = "5";
                    setCheckedToTrue(5);
                    progressDialog.show();
                    requestDate();
                }
            });
            rb17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hide1();
                    rb17.setBackgroundResource(R.drawable.blue_but_bg);
                    rb17.setTextColor(getResources().getColor(R.color.white));
                    rb11.setTextColor(getResources().getColor(R.color.global_black));
                    lingyu = "6";
                    setCheckedToTrue(6);
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
                    setCheckedToTrue2(0);
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
                    setCheckedToTrue2(1);
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
                    setCheckedToTrue2(2);
                    progressDialog.show();
                    requestDate();
                }
            });
            rb24.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hide2();
                    rb23.setBackgroundResource(R.drawable.blue_but_bg);
                    rb23.setTextColor(getResources().getColor(R.color.white));
                    rb21.setTextColor(getResources().getColor(R.color.global_black));
                    rb22.setTextColor(getResources().getColor(R.color.global_black));
                    leibie = "3";
                    setCheckedToTrue2(3);
                    progressDialog.show();
                    requestDate();
                }
            });
            rb25.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hide2();
                    rb23.setBackgroundResource(R.drawable.blue_but_bg);
                    rb23.setTextColor(getResources().getColor(R.color.white));
                    rb21.setTextColor(getResources().getColor(R.color.global_black));
                    rb22.setTextColor(getResources().getColor(R.color.global_black));
                    leibie = "4";
                    setCheckedToTrue2(4);
                    progressDialog.show();
                    requestDate();
                }
            });
            rb26.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hide2();
                    rb23.setBackgroundResource(R.drawable.blue_but_bg);
                    rb23.setTextColor(getResources().getColor(R.color.white));
                    rb21.setTextColor(getResources().getColor(R.color.global_black));
                    rb22.setTextColor(getResources().getColor(R.color.global_black));
                    leibie = "5";
                    setCheckedToTrue2(5);
                    progressDialog.show();
                    requestDate();
                }
            });
            rb27.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hide2();
                    rb23.setBackgroundResource(R.drawable.blue_but_bg);
                    rb23.setTextColor(getResources().getColor(R.color.white));
                    rb21.setTextColor(getResources().getColor(R.color.global_black));
                    rb22.setTextColor(getResources().getColor(R.color.global_black));
                    leibie = "6";
                    setCheckedToTrue2(6);
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


    private void initDate() {
        qiye_admin = getIntent().getBooleanExtra("qiye_admin", false);
    }

    private void requestDate() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + "/admin/fenji5/pxbm");
        params.addBodyParameter("lingyu", lingyu);
        params.addBodyParameter("leibie", leibie);
        params.addBodyParameter("guize", guize);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                SelectTrainAdapter adapter = new SelectTrainAdapter(result, SelectTrainActivity.this);
                adapter.setQiye_admin(qiye_admin);
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
    public int getLayout() {
        return R.layout.shiji_fragment_layout_select_train;
    }

    private ArrayList<RadioButton> bt1s = new ArrayList<RadioButton>();

    public void setCheckedToTrue(int index) {
        for (RadioButton radioButton : bt1s) {
            radioButton.setSelected(false);
            radioButton.setBackgroundResource(R.drawable.fillet_white_bg);
            radioButton.setTextColor(getResources().getColor(R.color.global_black));
        }
        bt1s.get(index).setBackgroundResource(R.drawable.blue_but_bg);
        bt1s.get(index).setTextColor(getResources().getColor(R.color.white));

    }

    private ArrayList<RadioButton> bt2s = new ArrayList<RadioButton>();

    public void setCheckedToTrue2(int index) {
        for (RadioButton radioButton : bt2s) {
            radioButton.setSelected(false);
            radioButton.setBackgroundResource(R.drawable.fillet_white_bg);
            radioButton.setTextColor(getResources().getColor(R.color.global_black));
        }
        bt2s.get(index).setBackgroundResource(R.drawable.blue_but_bg);
        bt2s.get(index).setTextColor(getResources().getColor(R.color.white));

    }


}
