package com.lxkj.yiyao.sj;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class LoginConstract {
    public interface LoginView{
        public void toLogin();
        public void toRegister();
        public void showCheckCode(String imageUrl);
    }
}
