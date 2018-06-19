package com.example.aon_attapon.live500px.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aon_attapon.live500px.R;
import com.example.aon_attapon.live500px.dao.PhotoItemCollectionDao;
import com.example.aon_attapon.live500px.dao.PhotoItemDao;
import com.example.aon_attapon.live500px.manager.PhotoListManager;
import com.example.aon_attapon.live500px.view.PhotoListItem;

public class PhotoListAdapter extends BaseAdapter {

    PhotoItemCollectionDao dao;
    int lastPosition = -1; //Current position that I here

    public void setDao(PhotoItemCollectionDao dao) {
        this.dao = dao;
    }

    @Override
    public int getCount() {
        if(dao == null)
            return 0;
        if(dao == null)
            return 0;

        return dao.getData().size();
    }

    @Override
    public Object getItem(int position) {
        return dao.getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PhotoListItem item;
        if (convertView != null)
            item = (PhotoListItem) convertView;
        else
            item = new PhotoListItem(parent.getContext());

        PhotoItemDao dao = (PhotoItemDao) getItem(position);
        item.setNameText(dao.getCaption());
        item.setDescriptionText(dao.getUsername()+"\n"+dao.getCamera());
        item.setImageUrl(dao.getImageUrl());

        if(position > lastPosition){
            Animation anim = AnimationUtils.loadAnimation(parent.getContext(),
                    R.anim.up_from_bottom);

            item.startAnimation(anim);
            lastPosition = position;
        }
        return item;
    }

    public void increaseLastPosition(int amount){
        lastPosition += amount;
    }
}
