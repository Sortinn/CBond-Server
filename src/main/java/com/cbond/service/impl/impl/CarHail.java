package com.cbond.service.impl.impl;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class CarHail {
    Queue<CarDistance> dstance=new PriorityQueue<CarDistance>(10,new QueueComapre());
    public  CarHail(PriorityQueue<CarDistance> distance)
    {
        this.dstance=distance;
    }

    public String callCar()
    {
        return dstance.peek().getNum();
    }


}
