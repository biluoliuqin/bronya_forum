package com.bronya.service.impl;

import com.bronya.dao.ManagerDao;
import com.bronya.dao.UserDao;
import com.bronya.dao.impl.ManagerDaoImpl;
import com.bronya.dao.impl.UserDaoImpl;
import com.bronya.module.Discussion;
import com.bronya.module.Manager;
import com.bronya.module.News;
import com.bronya.module.User;
import com.bronya.service.ManagerService;


import java.util.List;

public class ManagerServiceIpml implements ManagerService {
    //泛型
    ManagerDao managerDao=new ManagerDaoImpl();
    UserDao userDao=new UserDaoImpl();

    @Override
    public Manager checkLogin(String name, String pwd) {
        return managerDao.checkLogin(name, pwd);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> findAllUserByPage(int page, int pageSize) {
        return page>0?userDao.findByPage((page-1)*pageSize,pageSize):userDao.findByPage(0,pageSize);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public List<News> findAllNewsByPage(int page, int pageSize) {
        return page>0?managerDao.findAllNewsByPage((page-1)*pageSize,pageSize):managerDao.findAllNewsByPage(0,pageSize);
    }

    @Override
    public int getNewsCount() {
        return managerDao.getNewsCount();
    }

    @Override
    public boolean newsIsExcellent(int newsId) {
        return managerDao.newsIsExcellent(newsId)==1?true:false;
    }

    @Override
    public boolean newsIsTop(int newsId) {
        return managerDao.newsIsTop(newsId)==1?true:false;
    }

    @Override
    public boolean deleteNews(int newsId) {
        return managerDao.deleteNews(newsId)==1?true:false;
    }

    @Override
    public List<Discussion> findAllDisByPage(int page, int pageSize) {
        return page>0?managerDao.findAllDisByPage((page-1)*pageSize,pageSize):managerDao.findAllDisByPage(0,pageSize);
    }

    @Override
    public int getDisCount() {
        return managerDao.getDisCount();
    }

    @Override
    public boolean deleteDis(int disId) {
        return managerDao.deleteDis(disId)==1?true:false;
    }
}
