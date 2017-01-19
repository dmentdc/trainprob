package Problem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by sariasc on 14-01-17.
 */
public class City {

    private  List<Route> routes = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<Route> getRoutes(){
        return  routes;
    }

    private String name;

    public City(String name) {
        this.name = name;
    }


    public int distanceTo(City city) {
        for (Route route : routes){
            if(route.getTarget().equals(city)){
                return route.getDistance();
            }
        }
        return 0;
    }

    public void connectTo(City city, int distance) {
        routes.add(new Route(city, distance));
    }

    public int getRouteDistance(List<City> cities) {
        int sum = 0;

        for(int i=0;i<cities.size();i++){
            if(cities.size()==i +1){
                return sum;
            }
            City origin = cities.get(i);
            City destination = cities.get(i+1);
            sum += origin.getDistance(destination);
        }

        return sum;
    }

    private int getDistance(City destination){
        for(Route route : this.routes)
            if (route.getTarget().getName().equals(destination.getName())) return route.getDistance();
        throw new NotSuchRouteException("NOT SUCH ROUTE");
    }

    public  int getShortestRouteDistance(List<City> cityMap, City target) {
        return this.getShortestRouteDistance(cityMap,target,noVisitedCities());
    }

    private int getShortestRouteDistance(List<Route> map, City target, int cost) {
        //int shortWay = Integer.MAX_VALUE;
        for(int i = 0; i < map.size(); i++){
            Route r = map.get(i);
            if(r.getTarget().getName().equals(target.getName())){
                return cost += r.getDistance();
            }else{
                return cost + getShortestRouteDistance(r.getTarget().getRoutes(),  target,  cost);
            }

        }
        return 0;
    }

    int sum(List<Route> r, City target, int i, int min){
        if(r == null){
            return 0;
        }
        if( r.get(i) == null){
            return 0;
        }
        else{
            if(r.get(i).getTarget().getName().equals(target.getName())){
                return r.get(i).getDistance();  
            }else{
                return r.get(i).getDistance() + sum(r,target,i+1);
            }
        }
    }

    int getShortWay(Route origin, City target, int cost){
        if(origin.getTarget().getName() == target.getName()){
            return origin.getDistance();
        }else{
            getShortestRouteDistance(origin.getTarget().getRoutes(),target, cost + origin.getDistance());
        }
    }

    private Collection<City> noVisitedCities() {
        return new ArrayList<City>();
    }
}
