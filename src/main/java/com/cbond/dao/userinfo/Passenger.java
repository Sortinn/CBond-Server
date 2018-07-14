package com.cbond.dao.userinfo;


import com.cbond.dao.Distance;
import com.cbond.dao.SiteInfo.Location;

import java.util.Date;

public class Passenger extends UserInfo implements Distance {

    //乘客用户名
    private String passengerName;

    //乘客叫车时间
    private Date callTime;

    //乘客叫车地点
    private String callSite;

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Date getCallTime() {
        return callTime;
    }

    public void setCallTime(Date callTime) {
        this.callTime = callTime;
    }

    public String getCallSite() {
        return callSite;
    }

    public void setCallSite(String callSite) {
        this.callSite = callSite;
    }


    public String save(String input) {
        return input;
    }

    @Override
    public Double distanceBetweenCarAndPassenger(Location location1, Location location2,String unit) {
        return null;
    }
}
