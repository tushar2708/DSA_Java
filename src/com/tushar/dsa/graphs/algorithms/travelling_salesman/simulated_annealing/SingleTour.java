package com.tushar.dsa.graphs.algorithms.travelling_salesman.simulated_annealing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleTour {

    private List<City> tour = new ArrayList<>();
    private double distance = 0;

    public SingleTour() {
        for (int i = 0; i < Repository.getNumberOfCities(); i++) {
            tour.add(null);
        }
    }

    public SingleTour(List<City> tour) {
        this.tour = new ArrayList<>(tour);
    }

    public List<City> getTour() {
        return tour;
    }

    public void setTour(List<City> tour) {
        this.tour = tour;
    }

    public double getDistance() {

        if (this.distance == 0) {
            double tourDistance = 0;

            for (int i = 0; i < getTour().size(); i++) {

                City fromCity = tour.get(i);
                City toCity;

                if (i < getTour().size() - 1) {
                    toCity = getCity(i + 1);    // take next city
                } else {
                    toCity = getCity(0);    // take first city (tour is circular)
                }

                tourDistance += fromCity.distanceTo(toCity);
            }
            this.distance = tourDistance;
        }

        return this.distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void generateIndividualRandomTour() {

        for (int i = 0; i < Repository.getNumberOfCities(); i++) {
            setCity(i, Repository.getCity(i));
        }

        Collections.shuffle(tour);
    }

    public void setCity(int i, City city) {
        this.tour.set(i, city);
        this.distance = 0;
    }

    public City getCity(int i) {
        return this.tour.get(i);
    }

    @Override
    public String toString() {
        return "SingleTour{" +
                "tour=" + tour +
                ", distance=" + distance +
                '}';
    }
}
