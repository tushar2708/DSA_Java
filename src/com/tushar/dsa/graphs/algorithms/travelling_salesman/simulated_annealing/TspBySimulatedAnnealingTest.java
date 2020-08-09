package com.tushar.dsa.graphs.algorithms.travelling_salesman.simulated_annealing;

import org.junit.Before;
import org.junit.Test;

public class TspBySimulatedAnnealingTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void simulationTest() {
        for (int i = 0; i < 100; i++) {
            City city = new City("city-" + i);
            Repository.addCity(city);
        }

        TspBySimulatedAnnealing annealing = new TspBySimulatedAnnealing();
        annealing.simulation();

        System.out.println(
                "Final approximate solution's distance is: " +
                        annealing.getBestSolution().getDistance() +
                        "\nAnd the best tour is:\n" +
                        annealing.getBestSolution().getTour()
        );
    }
}
