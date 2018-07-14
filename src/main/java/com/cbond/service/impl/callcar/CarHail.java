package com.cbond.service.impl.callcar;

import java.util.PriorityQueue;
import java.util.Queue;

public class CarHail {
    private  Queue<CarDistance> distances = new PriorityQueue<CarDistance>(10, new QueueComapre());

    public String callCar() {
        return distances.peek().getNum();
    }

    public void addDistances(CarDistance carDistance) {
        distances.add(carDistance);
    }

    public Queue<CarDistance> getDistances() {
        return distances;
    }

    public void setDistances(Queue<CarDistance> distances) {
        this.distances = distances;
    }
}
