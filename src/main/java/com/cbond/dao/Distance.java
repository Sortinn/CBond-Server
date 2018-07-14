package com.cbond.dao;

public interface Distance {

    /**
     * 公交车和用户的距离
     * @return
     */
    Double distanceBetweenCarAndPassenger(Object passengerInfo, Object driverInfo);


    /**
     * 乘客与站点之间的距离
     * @param passengerInfo
     * @param siteInfo
     * @return
     */
    Double distanceBetweenSiteAndPassenger(Object passengerInfo, Object siteInfo);


    String  save(String input);
}
