/*
 * Tour.java
 * Stores a candidate tour
 */
package tsp4;
import tsp5.TourManager;
import tsp.Location;

import java.util.ArrayList;
import java.util.Collections;

public class Tour{

    // Holds our tour of cities
    private ArrayList tour = new ArrayList<tsp.Location>();
    // Cache
    private double fitness = 0;
    private int distance = 0;

    // Constructs a blank tour
    public Tour(){
        for (int i = 0; i < TourManager.numberOfCities(); i++) {
            tour.add(null);
        }
    }

    public Tour(ArrayList tour){
        this.tour = tour;
    }

    // Creates a random individual
    public void generateIndividual() {
        // Loop through all our destination cities and add them to our tour
        for (int spotIndex = 0; spotIndex < TourManager.numberOfCities(); spotIndex++) {
            setCity(spotIndex, TourManager.getCity(spotIndex));
        }
        // Randomly reorder the tour
        Collections.shuffle(tour);
    }

    // Gets a spot from the tour
    public tsp.Location getCity(int tourPosition) {
        return (tsp.Location)tour.get(tourPosition);
    }

    // Sets a spot in a certain position within a tour
    public void setCity(int tourPosition, tsp.Location spot) {
        tour.set(tourPosition, spot);
        // If the tours been altered we need to reset the fitness and distance
        fitness = 0;
        distance = 0;
    }

    // Gets the tours fitness
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getDistance();
        }
        return fitness;
    }

    // Gets the total distance of the tour
    public int getDistance(){
        if (distance == 0) {
            int tourDistance = 0;
            // Loop through our tour's cities
            for (int spotIndex=0; spotIndex < tourSize(); spotIndex++) {
                // Get spot we're travelling from
                tsp.Location fromCity = getCity(spotIndex);
                // City we're travelling to
                tsp.Location destinationCity;
                // Check we're not on our tour's last spot, if we are set our
                // tour's final destination spot to our starting spot
                if(spotIndex+1 < tourSize()){
                    destinationCity = getCity(spotIndex+1);
                }
                else{
                    destinationCity = getCity(0);
                }
                // Get the distance between the two cities
                tourDistance += fromCity.distanceTo(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }

    // Get number of cities on our tour
    public int tourSize() {
        return tour.size();
    }

    // Check if the tour contains a spot
    public boolean containsCity(tsp.Location spot){
        return tour.contains(spot);
    }

    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getCity(i)+"|";
        }
        return geneString;
    }
}
