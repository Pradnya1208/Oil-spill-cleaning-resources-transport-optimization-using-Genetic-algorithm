/*
 * TSP_GA.java
 * Create a tour and evolve a solution
 */
package tsp6;
import tsp5.TourManager;
import tsp3.Population;
import tsp2.GA;
import tsp.Location;

public class TSP_GA {

    public static void main(String[] args) {

        // Create and add our cities
        tsp.Location spot = new tsp.Location(100, 30);
        TourManager.addLocation(spot);
        tsp.Location spot2 = new tsp.Location(20, 60);
        TourManager.addLocation(spot2);
        tsp.Location spot3 = new tsp.Location(40, 120);
        TourManager.addLocation(spot3);
        tsp.Location spot4 = new tsp.Location(160, 80);
        TourManager.addLocation(spot4);
        tsp.Location spot5 = new tsp.Location(80, 200);
        TourManager.addLocation(spot5);
        tsp.Location spot6 = new tsp.Location(50, 90);
        TourManager.addLocation(spot6);
        tsp.Location spot7 = new tsp.Location(120, 150);
        TourManager.addLocation(spot7);
        tsp.Location spot8 = new tsp.Location(120, 100);
        TourManager.addLocation(spot8);


        // Initialize population
        Population pop = new Population(50, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());

        // Evolve population for 100 generations
        pop = GA.evolvePopulation(pop);
        for (int i = 0; i < 100; i++) {
            pop = GA.evolvePopulation(pop);
        }

        // Print final results
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
    }
}