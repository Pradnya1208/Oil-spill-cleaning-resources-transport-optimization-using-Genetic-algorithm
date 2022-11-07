
package tsp;

public class Location {
    int x;
    int y;

    // Constructs a randomly placed spot
    public Location(){
        this.x = (int)(Math.random()*200);
        this.y = (int)(Math.random()*200);
    }

    // Constructs a spot at chosen x, y location
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Gets spot's x coordinate
    public int getX(){
        return this.x;
    }

    // Gets spot's y coordinate
    public int getY(){
        return this.y;
    }

    // Gets the distance to given spot
    public double distanceTo(tsp.Location spot){
        int xDistance = Math.abs(getX() - spot.getX());
        int yDistance = Math.abs(getY() - spot.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );

        return distance;
    }

    @Override
    public String toString(){
        return getX()+", "+getY();
    }
}


