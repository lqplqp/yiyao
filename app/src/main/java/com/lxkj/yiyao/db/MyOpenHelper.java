package com.lxkj.yiyao.db;

import android.content.Context;
import android.util.Log;

import com.lxkj.yiyao.dao.DaoMaster;
import com.lxkj.yiyao.dao.QuestionBeanDao;

import org.greenrobot.greendao.database.Database;

/**
 * Created by apple on 2016/10/17.
 */

public class MyOpenHelper extends DaoMaster.OpenHelper {
    private String TAG = "MyOpenHelper";
    public MyOpenHelper(Context context, String name) {
        super(context, name);
    }


    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        Log.d(TAG, "db version update from " + oldVersion + " to " + newVersion);

        switch (oldVersion) {
            case 1:

                //不能先删除表，否则数据都木了
//                StudentDao.dropTable(db, true);

                QuestionBeanDao.createTable(db, true);

                // 加入新字段 score
                db.execSQL("ALTER TABLE 'STUDENT' ADD 'SCORE' TEXT;");

                break;
        }

    }
}
