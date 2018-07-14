package com.cbond.service.impl.utils;

import com.cbond.dao.Distance;
import com.cbond.dao.SiteInfo.Location;

public class StraightLineDistance implements Distance {


    @Override
    public Double distanceBetweenCarAndPassenger(Location location1, Location location2, String unit) {
        Double latitude1 = location1.getLatitude();
        Double longitude1 = location1.getLongitude();
        Double latitude2 = location2.getLatitude();
        Double longitude2 = location2.getLongitude();

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(latitude2 - latitude1);
        double lonDistance = Math.toRadians(longitude2 - longitude1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters


        distance = Math.pow(distance, 2);

        return Math.sqrt(distance);
    }
}
