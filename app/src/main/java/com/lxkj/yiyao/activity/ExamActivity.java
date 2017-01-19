package com.lxkj.yiyao.activity;

import android.util.Log;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.db.MyRealm;
import com.lxkj.yiyao.db.QuestionDBBean;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by sun on 2017/1/19.
 */

public class ExamActivity extends BaseActivity{
    @Override
    public int getLayout() {
        return R.layout.exam_layout;
    }

    @Override
    protected void init() {
        super.init();
        Realm realm = MyRealm.getInstance();

            final QuestionDBBean bean = new QuestionDBBean();
            bean.setNum(new Long(4));
            bean.setType(0);
            bean.setQuestion("asdf编译原理一般分为哪几个阶段？编译原理一般分为哪几个阶段？");
            bean.setAnswer(2);
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.copyToRealmOrUpdate(bean);
                }
            });
        final QuestionDBBean bean1 = new QuestionDBBean();
        bean1.setNum(new Long(5));
        bean1.setType(0);
        bean1.setQuestion("afgdhfgh编译原理一般分为哪几个阶段？编译原理一般分为哪几个阶段？");
        bean1.setAnswer(2);
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(bean1);
            }
        });


        /*realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                QuestionDBBean bean = realm.createObject(QuestionDBBean.class);
                bean.setType(0);
                bean.setQuestion("2  编译原理一般分为哪几个阶段？编译原理一般分为哪几个阶段？");
                bean.setAnswer(2);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.d("ExamActivity", "插入成功");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.d("ExamActivity", "插入失败");
            }
        });*/
        RealmResults<QuestionDBBean> all = realm.where(QuestionDBBean.class).findAll();
        Log.d("ExamActivity", "查到 " + all.size());
        Log.d("ExamActivity", "查到 " + all.get(1).getQuestion());
        Log.d("ExamActivity", "查到 " + all.get(1).getNum());
    }
}
