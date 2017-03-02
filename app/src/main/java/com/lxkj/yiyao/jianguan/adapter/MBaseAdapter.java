package com.lxkj.yiyao.jianguan.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.utils.ToastUtil;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public abstract class MBaseAdapter<T> extends BaseAdapter {

    com.alibaba.fastjson.JSONObject json;
    JSONArray datas;
    com.alibaba.fastjson.JSONObject jsonObject;


    public MBaseAdapter(String bean) {
        json = com.alibaba.fastjson.JSONObject.parseObject(bean);
        jsonObject = json.getJSONObject("data");
        datas = jsonObject.getJSONArray("data");
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        T holder;
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), getItemLayout(), null);
            holder = getHolder(view);
            view.setTag(holder);
        } else {
            holder = (T) view.getTag();
        }

        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSONObject.parseObject(datas.get(i).toString());
        fillData(i,holder,object);

        return view;
    }

    /**
     * 填充数据
     */
    protected abstract void fillData(int i , T holder,JSONObject result);


    /**
     * 获取item布局
     * @return
     */
    protected abstract int getItemLayout();

    /**
     * 获取holder
     * @param view
     * @return
     */
    protected abstract T getHolder(View view);

    public void clear(){
        datas.clear();
    }


    public void addData(String bean){
        json = com.alibaba.fastjson.JSONObject.parseObject(bean);
        jsonObject = json.getJSONObject("data");
        JSONArray array = jsonObject.getJSONArray("data");
        if(array.size()==0){
            ToastUtil.show("没有更多数据了");
            return;
        }
        datas.addAll(array);


    }






    @Override
    public int getCount() {

        if( datas == null || datas.size() == 0){
            return 0;
        }
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    
}
