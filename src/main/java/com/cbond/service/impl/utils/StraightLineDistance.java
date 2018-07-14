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

        // Radius of the earth in km
//        int R = 6371;
//        Double dLat = deg2rad(latitude2 - latitude1);
//        Double dLon = deg2rad(longitude2 - longitude1);
//        Double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
//                Math.cos(deg2rad(latitude1)) * Math.cos(deg2rad(latitude2)) *
//                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
//        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
//        Double d = R * c;
//
//        return d;

//        double theta = longitude1 - longitude2;
//        double dist = Math.sin(deg2rad(latitude1)) * Math.sin(deg2rad(latitude2)) + Math.cos(deg2rad(latitude1)) * Math.cos(deg2rad(latitude2)) * Math.cos(deg2rad(theta));
//        dist = Math.acos(dist);
//        dist = rad2deg(dist);
//        dist = dist * 60 * 1.1515;
//        if (unit.equals("K")) {
//            dist = dist * 1.609344;
//        } else if (unit.equals("N")) {
//            dist = dist * 0.8684;
//        }
//
//        return (dist);

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


    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

}
