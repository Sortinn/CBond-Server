package com.cbond.dao.userinfo;

public class Driver extends UserInfo {


    //司机的身份证号码
    private String driverIdentityId;

    private String driverPhoneNumber;

    public String getDriverIdentityId() {
        return driverIdentityId;
    }

    public void setDriverIdentityId(String driverIdentityId) {
        this.driverIdentityId = driverIdentityId;
    }

    public String getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public void setDriverPhoneNumber(String driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
    }
}
