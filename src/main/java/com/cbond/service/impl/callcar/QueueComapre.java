package com.cbond.service.impl.callcar;

import java.util.Comparator;

public class QueueComapre implements Comparator<CarDistance> {

    @Override
    public int compare(CarDistance o1, CarDistance o2) {
        if (o1.getDistance() < o2.getDistance())
            return -1;
        else if (o1.getDistance() > o2.getDistance())
            return 1;
        else
            return 0;

    }
}
