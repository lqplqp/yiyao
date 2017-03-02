package com.lxkj.yiyao.jianguan.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.bean.CompanyManagerBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class CompanyManagerAdapter extends BaseAdapter {

    CompanyManagerBean bean;

    public CompanyManagerAdapter(CompanyManagerBean bean) {
        this.bean = bean;
    }

    @Override
    public int getCount() {
        if(bean.getData() == null || bean.getData().size() ==0){
            return 0;
        }
        return bean.getData().size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder(View.inflate(viewGroup.getContext(), R.layout.qiyeguanli_table_item, null));
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        CompanyManagerBean.Data data = bean.getData().get(i);
        holder.beizhu.setText(data.getBz());
        holder.qiyeName.setText(data.getQymc());
        holder.tijianhegePeople.setText(data.getTjhgrs());
        holder.peixunhegeRenshu.setText(data.getPxhgrs());
        holder.infocardRenshu.setText(data.getHdxxkrs());
        //holder.guoqitixing.set







        return view;
    }



    static class ViewHolder {
        @BindView(R.id.chakan)
        TextView chakan;
        @BindView(R.id.qiyerenyuan)
        TextView qiyerenyuan;
        @BindView(R.id.qiye_name)
        TextView qiyeName;
        @BindView(R.id.tijianhege_people)
        TextView tijianhegePeople;
        @BindView(R.id.peixunhege_renshu)
        TextView peixunhegeRenshu;
        @BindView(R.id.infocard_renshu)
        TextView infocardRenshu;
        @BindView(R.id.guoqitixing)
        LinearLayout guoqitixing;
        @BindView(R.id.beizhu)
        TextView beizhu;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
