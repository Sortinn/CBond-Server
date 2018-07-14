package com.cbond.controller;


import com.cbond.dao.siteinfo.Location;
import com.cbond.dao.siteinfo.Site;
import com.cbond.dao.siteinfo.Station;
import com.cbond.service.impl.callcar.CarDistance;
import com.cbond.service.impl.callcar.CarHail;
import com.cbond.service.impl.utils.StraightLineDistance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class UserInfoController {
    private ArrayList<Station> driver = new ArrayList<Station>();
    private ArrayList<String> site = new ArrayList<String>();
    private Site sites = new Site();
    private Site carSite = new Site();
    private String[] carNum = {"1", "2", "3", "4", "5"};
    private String[] stationName = {"HT", "DX", "ZY", "ZHL", "DM", "TYG", "FL", "JSQ", "BC", "NC", "DH"};
    private String[] stationNameZh = {"海棠餐厅", "丁香餐厅", "竹园餐厅", "综合楼", "东门", "体育馆", "F楼", "家属区", "北操", "南操", "大活"};
    private Logger logger = Logger.getLogger(String.valueOf(UserInfoController.class));
    private double[] stationLocation = {
            34.1291400000, 108.8338000000,
            34.1280290000, 108.8361050000,
            34.1265133325, 108.8393801451,
            34.1262380106, 108.8378888369,
            34.1221213962, 108.8398414850,
            34.1205137750, 108.8363975286,
            34.1248214205, 108.8360971212,
            34.1216551004, 108.8315963745,
            34.1292665029, 108.8312315941,
            34.1245594153, 108.8282275200,
            34.1265843832, 108.8295149803
    };

    private double[] driverLocation = {
            34.1248791503, 108.8360810280,  //竹园餐厅门口
            34.1274725117, 108.8301587105,  //大学生活动中心门口
            34.1284900000, 108.8293300000,  //游泳馆
            34.1217528007, 108.8397073746,  //东门
            34.1221258371, 108.8312852383   //家属区附近
    };


    private void addStation() {
        for (int i = 0; i < stationName.length; i++) {
            sites.addStation(stationName[i], new Station(stationNameZh[i], new Location(stationLocation[2 * i], stationLocation[2 * i + 1])));
            site.add(stationName[i]);
        }
    }

    private void addCar() {
        for (int i = 0; i < carNum.length; i++) {
            carSite.addStation(carNum[i], new Station(carNum[i], new Location(driverLocation[2 * i], driverLocation[2 * i + 1])));
        }
    }


    private Location getNearestSite(Location location) {
        addStation();
        StraightLineDistance straightLineDistance = new StraightLineDistance();
        CarHail carHail = new CarHail();
        for (String s : site) {
            Double distance = straightLineDistance.distanceBetweenCarAndPassenger(location, sites.getSiteInfo().get(s).getLocation(), "K");
            logger.info(String.valueOf(distance));
            carHail.addDistances(new CarDistance(s, distance));
        }
        return sites.getSiteInfo().get(carHail.callCar()).getLocation();

    }


    private Location getNearestCar(Location location) {

        addCar();
        StraightLineDistance straightLineDistance = new StraightLineDistance();
        CarHail carHail = new CarHail();
        for (String s : carNum) {
            Double distance = straightLineDistance.distanceBetweenCarAndPassenger(location, carSite.getSiteInfo().get(s).getLocation(), "K");
            System.out.println(distance);
            carHail.addDistances(new CarDistance(s, distance));
        }
        return carSite.getSiteInfo().get(carHail.callCar()).getLocation();

    }


    @RequestMapping(value = "/nearestdriverinfo")
    public void getDriverInfo(String callType, String userID, String username, String longitude, String latitude, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        logger.info("callType >> " + callType + " userID >>> " + userID + "  userdname >>> " + username + " longitude >>> " + longitude + " latitude >> " + latitude);
        Location nearestDriverLocation = null;
        if (callType.equals("1")) {
            nearestDriverLocation = getNearestCar(new Location(Double.parseDouble(latitude), Double.parseDouble(longitude)));
        }

        logger.info("最近的公交车位置经纬度为：" + nearestDriverLocation.getLatitude() + ", " + nearestDriverLocation.getLongitude());

        Writer responseToWriter = response.getWriter();
        responseToWriter.write("最近的公交车位置经纬度为：" + nearestDriverLocation.getLatitude() + ", " + nearestDriverLocation.getLongitude());
        responseToWriter.flush();

    }



    @RequestMapping(value = "/nearestsiteinfo")
    public void getSiteInfo(String callType, String userID, String username, String longitude, String latitude, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        logger.info("callType >> " + callType + " userID >>> " + userID + "  userdname >>> " + username + " longitude >>> " + longitude + " latitude >> " + latitude);

        Location nearestSiteLocation = null;
        if (callType.equals("3")) {
            nearestSiteLocation = getNearestSite(new Location(Double.parseDouble(latitude), Double.parseDouble(longitude)));

        }

        logger.info("计算出来的站点位置为：" + nearestSiteLocation.getLatitude() + ", " + nearestSiteLocation.getLongitude());

        Writer responseToWechat = response.getWriter();
        responseToWechat.write("数据已写入后台，请稍后...");
        responseToWechat.write("最近的站点的经纬度坐标为(" + nearestSiteLocation.getLatitude() + ", " + nearestSiteLocation.getLongitude() + ")");
        responseToWechat.flush();

    }




}
