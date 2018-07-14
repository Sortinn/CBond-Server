package com.cbond.dao;

import com.cbond.service.impl.User;

import java.util.HashMap;
import java.util.Map;

public class UserInfo {

    //公交车或乘客的ID
    private Integer userID;

    //公交车或乘客的经纬度位置,以键值对的形式保存
    //<经度：**>
    //<纬度：**>
    private Map<String, String> location = new HashMap<String, String>();


    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }



    public Map<String, String> getLocation() {
        return location;
    }

    public void setLocation(Map<String, String> location) {
        this.location = location;
    }
    
}
