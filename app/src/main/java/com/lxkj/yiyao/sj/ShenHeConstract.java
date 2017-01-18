package com.lxkj.yiyao.sj;

import android.widget.TableRow;

import java.util.List;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class ShenHeConstract {
    public interface ShenHeView{
        void addRow(TableRow row);
        void addRows(List<TableRow> rows);
    }
}
