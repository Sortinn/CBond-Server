package com.cbond.dao.SiteInfo;

import java.util.HashMap;
import java.util.Map;

public class Site {

    private Map<String, Station> siteInfo = new HashMap();


    public void addStation(String stationName, Station stationInfo) {
        siteInfo.put(stationName, stationInfo);
    }

    public void deleteStation(String stationName) {
        siteInfo.remove(stationName);
    }

    public boolean stationExist(String stationName) {
        return siteInfo.containsKey(stationName);
    }

    public void setSiteInfo(Map<String, Station> siteInfo) {
        this.siteInfo = siteInfo;
    }

    public Map<String, Station> getSiteInfo() {
        return siteInfo;
    }
}
