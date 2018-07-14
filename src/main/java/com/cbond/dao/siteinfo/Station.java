package com.cbond.dao.SiteInfo;

public class Station {
    private String stationName;
    private Location location;


    public Station(String stationName, Location location) {
        this.stationName = stationName;
        this.location = location;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}


