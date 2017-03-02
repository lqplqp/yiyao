package com.lxkj.yiyao.jianguan.bean;

/**
 * Created by Administrator on 2017/3/1 0001.
 */

import java.util.List;



public class CompanyManagerBean
{
    private String code;

    private String message;

    private List<Data> data;

    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
    public void setData(List<Data> data){
        this.data = data;
    }
    public List<Data> getData(){
        return this.data;
    }



    public class Data
    {
        private int id;

        private int qyid;

        private String qymc;

        private String cyrs;

        private String tjhgrs;

        private String pxhgrs;

        private String hdxxkrs;

        private String gqtx;

        private String bz;

        private String yhm;

        private String dwmc;

        private String glrys;

        private String gly;

        private String dh;

        private String zw;

        private String yx;

        private String hyly;

        private String szdq1;

        private String szdq2;

        private String szdq3;

        private String dwdz;

        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return this.id;
        }
        public void setQyid(int qyid){
            this.qyid = qyid;
        }
        public int getQyid(){
            return this.qyid;
        }
        public void setQymc(String qymc){
            this.qymc = qymc;
        }
        public String getQymc(){
            return this.qymc;
        }
        public void setCyrs(String cyrs){
            this.cyrs = cyrs;
        }
        public String getCyrs(){
            return this.cyrs;
        }
        public void setTjhgrs(String tjhgrs){
            this.tjhgrs = tjhgrs;
        }
        public String getTjhgrs(){
            return this.tjhgrs;
        }
        public void setPxhgrs(String pxhgrs){
            this.pxhgrs = pxhgrs;
        }
        public String getPxhgrs(){
            return this.pxhgrs;
        }
        public void setHdxxkrs(String hdxxkrs){
            this.hdxxkrs = hdxxkrs;
        }
        public String getHdxxkrs(){
            return this.hdxxkrs;
        }
        public void setGqtx(String gqtx){
            this.gqtx = gqtx;
        }
        public String getGqtx(){
            return this.gqtx;
        }
        public void setBz(String bz){
            this.bz = bz;
        }
        public String getBz(){
            return this.bz;
        }
        public void setYhm(String yhm){
            this.yhm = yhm;
        }
        public String getYhm(){
            return this.yhm;
        }
        public void setDwmc(String dwmc){
            this.dwmc = dwmc;
        }
        public String getDwmc(){
            return this.dwmc;
        }
        public void setGlrys(String glrys){
            this.glrys = glrys;
        }
        public String getGlrys(){
            return this.glrys;
        }
        public void setGly(String gly){
            this.gly = gly;
        }
        public String getGly(){
            return this.gly;
        }
        public void setDh(String dh){
            this.dh = dh;
        }
        public String getDh(){
            return this.dh;
        }
        public void setZw(String zw){
            this.zw = zw;
        }
        public String getZw(){
            return this.zw;
        }
        public void setYx(String yx){
            this.yx = yx;
        }
        public String getYx(){
            return this.yx;
        }
        public void setHyly(String hyly){
            this.hyly = hyly;
        }
        public String getHyly(){
            return this.hyly;
        }
        public void setSzdq1(String szdq1){
            this.szdq1 = szdq1;
        }
        public String getSzdq1(){
            return this.szdq1;
        }
        public void setSzdq2(String szdq2){
            this.szdq2 = szdq2;
        }
        public String getSzdq2(){
            return this.szdq2;
        }
        public void setSzdq3(String szdq3){
            this.szdq3 = szdq3;
        }
        public String getSzdq3(){
            return this.szdq3;
        }
        public void setDwdz(String dwdz){
            this.dwdz = dwdz;
        }
        public String getDwdz(){
            return this.dwdz;
        }
    }

}

