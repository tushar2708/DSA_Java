package com.tushar.dsa.graphs.algorithms.travelling_salesman.simulated_annealing;

public class TspBySimulatedAnnealing {

    private SingleTour bestSolution;

    public void simulation() {

        double temperature = 10_000;
        double coolingRate = 0.003;

        SingleTour currentSolution = new SingleTour();
        currentSolution.generateIndividualRandomTour();

        System.out.println("initial solution distance: " + currentSolution.getDistance());

        bestSolution = new SingleTour(currentSolution.getTour());

        while (temperature > 1) {
            SingleTour newSolution = new SingleTour(currentSolution.getTour());

            // pick 2 cities at random, and swap them.
            int rnd1 = (int) (Math.random() * (newSolution.getTour().size() - 1));
            int rnd2 = (int) (Math.random() * (newSolution.getTour().size() - 1));

            // swap the cities on the 2 indices
            City swap = newSolution.getCity(rnd1);
            newSolution.setCity(rnd1, newSolution.getCity(rnd2));
            newSolution.setCity(rnd2, swap);

            double currentEnergy = currentSolution.getDistance();   // current solution
            double neighbourEnergy = newSolution.getDistance(); // neighbour solution

            // accept one solution randomly
            if (acceptanceProbability(currentEnergy, neighbourEnergy, temperature) > Math.random()) {
                currentSolution = new SingleTour(newSolution.getTour());        // current solution would be updated
            }

            if (currentSolution.getDistance() < bestSolution.getDistance()) {
                bestSolution = new SingleTour(currentSolution.getTour());
            }

            temperature *= (1 - coolingRate);

        }

    }

    private double acceptanceProbability(double currentEnergy, double neighbourEnergy, double temperature) {

        // if we found a better solution, accept it
        if (neighbourEnergy < currentEnergy) {
            return 1;
        }

        return Math.exp((currentEnergy - neighbourEnergy) / temperature);
    }

    public SingleTour getBestSolution() {
        return bestSolution;
    }
}
