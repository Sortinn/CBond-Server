package com.cbond.dao;

import com.cbond.dao.SiteInfo.Location;

public interface Distance {


    Double distanceBetweenCarAndPassenger(Location location1, Location location2,String unit);


}
