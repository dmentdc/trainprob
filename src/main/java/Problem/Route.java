package Problem;

/**
 * Created by sariasc on 17-01-17.
 */
public class Route {


    private final int distance;
    private final  City target;

    public Route(City city, int distance) {
        this.target = city;
        this.distance = distance;
    }
    public int getDistance() {
        return distance;
    }

    public City getTarget() {
        return target;
    }
}