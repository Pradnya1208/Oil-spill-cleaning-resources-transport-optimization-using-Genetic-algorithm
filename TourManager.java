
/*
 * TourManager.java
 * Holds the cities of a tour
 */


package tsp5;
import java.util.ArrayList;
import tsp.Location;

public class TourManager {

    // Holds our cities
    private static ArrayList destinationCities = new ArrayList<tsp.Location>();

    // Adds a destination spot
    public static void addLocation(tsp.Location spot) {
        destinationCities.add(spot);
    }

    // Get a spot
    public static tsp.Location getCity(int index){
        return (tsp.Location)destinationCities.get(index);
    }

    // Get the number of destination cities
    public static int numberOfCities(){
        return destinationCities.size();
    }
}
