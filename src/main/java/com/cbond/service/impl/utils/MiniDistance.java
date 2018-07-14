package com.cbond.service.impl.callcar;

import com.cbond.dao.Distance;
import com.cbond.dao.SiteInfo.Location;

public class MiniDistance implements Distance {


    @Override
    public Double distanceBetweenCarAndPassenger(Location location1, Location location2) {
        Double latitude1 = location1.getLatitude();
        Double longitude1 = location1.getLongitude();
        Double latitude2 = location2.getLatitude();
        Double longitude2 = location2.getLongitude();

        // Radius of the earth in km
        int R = 6371;
        Double dLat = deg2rad(latitude2 - latitude1);
        Double dLon = deg2rad(longitude2 - longitude1);
        Double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(deg2rad(latitude1)) * Math.cos(deg2rad(latitude2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        Double d = R * c;

        return d;

    }

    private Double deg2rad(Double deg) {
        return deg * (Math.PI / 180);

    }

}
