package com.tushar.dsa.graphs.algorithms.travelling_salesman.simulated_annealing;

import java.util.Map;

public class City {
    private int x;
    private int y;

    private String name;

    public City(String name) {

        this.name = name;
        this.x = (int) (Math.random() * 100);
        this.y = (int) (Math.random() * 100);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distanceTo(City other){

        int xDis = Math.abs(this.getX()) - Math.abs(other.getX());
        int yDis = Math.abs(this.getY()) - Math.abs(other.getY());

        return Math.sqrt(xDis*xDis + yDis*yDis);
    }

    public String toString() {
        return this.name + "(" + this.x + "," + this.y + ")";
    }

}
