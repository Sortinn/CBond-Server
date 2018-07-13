package com.cbond.service.impl.impl;

public class CarDistance {
    private String num;
    private  Double distance;
    public CarDistance(String num,Double distance)
    {
        this.distance=distance;
        this.num=num;
    }

    public Double getDistance() {
        return distance;
    }

    public String getNum() {
        return num;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
