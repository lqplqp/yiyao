package com.lxkj.yiyao.sj;

import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.lxkj.yiyao.R;

import org.w3c.dom.Text;

import java.util.List;


/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class ShenHe extends BaseFragment implements ShenHeConstract.ShenHeView,View.OnClickListener{

    //查询按钮
    private TextView select;
    //输入关键字框
    private EditText input_key;
    //表格布局
    private TableLayout tableLayout;


    @Override
    protected void initView() {
        select = (TextView) findViewById(R.id.select);
        input_key = (EditText) findViewById(R.id.input_key);
        tableLayout = (TableLayout) findViewById(R.id.table);

        select.setOnClickListener(this);
    }

    @Override
    public int getLayout() {
        return R.layout.sj_fragment_layout_shenhe;
    }

    @Override
    public void addRow(TableRow row) {
        // TODO: 2017/1/18 0018 需要加入参数信息
        tableLayout.addView(row,null);
    }

    @Override
    public void addRows(List<TableRow> rows) {
        for(TableRow row : rows){
            addRow(row);
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.select:
                onClickSelect();
                break;
        }
    }

    //点击了查询按钮
    private void onClickSelect() {
        if(input_key.getText().equals("") || input_key.getText()==null){
            toast("关键字不可以为空");
            return;
        }
        // TODO: 2017/1/18 0018 搜索 
    }
}
