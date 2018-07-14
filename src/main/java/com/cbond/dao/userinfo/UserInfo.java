package com.cbond.dao.userinfo;

import java.util.HashMap;
import java.util.Map;

public  class UserInfo {

    //公交车或乘客的ID
    private String userID;

    //公交车或乘客的经纬度位置,以键值对的形式保存
    //<经度p：**>
    //<纬度：**>
    private Map<String, String> location = new HashMap<String, String>();


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }


    public Map<String, String> getLocation() {
        return location;
    }

    public void setLocation(Map<String, String> location) {
        this.location = location;
    }

    public  Double distanceBetweenCarAndPassenger(Object passengerInfo, Object driverInfo){
        return null;
    };

    public Double distanceBetweenSiteAndPassenger(Object passengerInfo, Object siteInfo) {
        return null;
    }
}
