package com.example.aon_attapon.live500px.manager;

import android.content.Context;
import android.os.Bundle;

import com.example.aon_attapon.live500px.dao.PhotoItemCollectionDao;
import com.example.aon_attapon.live500px.dao.PhotoItemDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.util.ArrayList;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class PhotoListManager {

    private Context mContext;
    private PhotoItemCollectionDao dao;

    public PhotoListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public PhotoItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(PhotoItemCollectionDao dao) {
        this.dao = dao;
    }

    public void insertDaoAtTopPosition(PhotoItemCollectionDao newDao){
        if(dao == null)
            dao = new PhotoItemCollectionDao();
        if(dao.getData() == null)
            dao.setData(new ArrayList<PhotoItemDao>());
        dao.getData().addAll(0,newDao.getData()); //save new dao to top position
    }

    public void appendDaoAtBottomPosition(PhotoItemCollectionDao newDao){
        if(dao == null)
            dao = new PhotoItemCollectionDao();
        if(dao.getData() == null)
            dao.setData(new ArrayList<PhotoItemDao>());
        dao.getData().addAll(dao.getData().size(), newDao.getData()); //save new dao to top position
    }

    public int getMaximumId(){
        if (dao == null)
            return 0;
        if (dao.getData() == null)
            return 0;
        if (dao.getData().size() == 0)
            return 0;
        int maxId = dao.getData().get(0).getId();
        for(int i=1; i < dao.getData().size(); i++)
            maxId = Math.max(maxId, dao.getData().get(i).getId());

        return maxId;
    }

    public int getMinimumId(){
        if (dao == null)
            return 0;
        if (dao.getData() == null)
            return 0;
        if (dao.getData().size() == 0)
            return 0;
        int minId = dao.getData().get(0).getId();
        for(int i=1; i < dao.getData().size(); i++)
            minId = Math.min(minId, dao.getData().get(i).getId());

        return minId;
    }

    public int getCount(){
        if (dao == null)
            return 0;
        if (dao.getData() == null)
            return 0;
        return dao.getData().size();
    }

    public Bundle onSaveInstanceState(){
        Bundle bundle = new Bundle();
        bundle.putParcelable("dao",dao);
        return bundle;
    }

    public void onRestoreInstance(Bundle saveInstanceState){
        dao = saveInstanceState.getParcelable("dao");
    }
}
