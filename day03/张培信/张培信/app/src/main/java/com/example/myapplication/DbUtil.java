package com.example.myapplication;

import com.example.greendao.db.DaoMaster;
import com.example.greendao.db.DaoSession;
import com.example.greendao.db.MyDbBeanDao;

import java.util.List;

public class DbUtil {
    public static DbUtil dbUtil;
    private final MyDbBeanDao myDbBeanDao;


    public synchronized static DbUtil getDbUtil() {
        if (dbUtil == null) {
            synchronized (DbUtil.class) {
                if (dbUtil == null) {
                    dbUtil = new DbUtil();
                }
            }
        }
        return dbUtil;
    }

    private DbUtil() {
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(Myapp.getMyapp(), "foodm");
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();

        myDbBeanDao = daoSession.getMyDbBeanDao();
    }

    public long insert(MyDbBean foodBdBean){
        boolean isl= Isinser(foodBdBean);
        if (!isl){
            long insert = myDbBeanDao.insert(foodBdBean);
            return insert;
        }
        return -1;

    }

    private boolean Isinser(MyDbBean foodBdBean) {

        List<MyDbBean> list = myDbBeanDao.queryBuilder().
                where(MyDbBeanDao.Properties.Title.eq(foodBdBean.getTitle())).list();
        if (list!=null&&list.size()>0){
            return true;
        }else {
            return false;
        }

    }

    public void delete(MyDbBean smartDbBean) {
        myDbBeanDao.delete(smartDbBean);
    }

    public void uqdate(MyDbBean smartDbBean) {
        myDbBeanDao.update(smartDbBean);
    }

    public List<MyDbBean> quary() {
        List<MyDbBean> list = myDbBeanDao.queryBuilder().list();
        return list;
    }

    public List<MyDbBean> selectSmart(MyDbBean smartDbBean) {
        List<MyDbBean> list = myDbBeanDao.queryBuilder().where(MyDbBeanDao.Properties.Title.eq(smartDbBean.getTitle()),
                MyDbBeanDao.Properties.Url.eq(smartDbBean.getUrl())).list();
        return list;
    }
}
