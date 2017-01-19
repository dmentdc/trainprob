package Problem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sariasc on 13-01-17.
 */
public class TrainTest {

    private final City a, b, c, d, e ;
    {
        a = new City("a");
        b = new City("b");
        c = new City("c");
        d = new City("d");
        e = new City("e");
        a.connectTo(b,5);
        b.connectTo(c,4);
        c.connectTo(d,8);
        d.connectTo(c,8);
        d.connectTo(e,6);
        a.connectTo(d,5);
        c.connectTo(e,2);
        e.connectTo(b,3);
        a.connectTo(e,7);
    }




    @Test
    public final void testCreateStation()  {
        //AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7

        Assert.assertEquals(5, a.distanceTo(b));
        Assert.assertEquals(4, b.distanceTo(c));
        Assert.assertEquals(8, c.distanceTo(d));

    }

    @Test
     public final void testGetDistance()  {

        List<City> routeToEvaluate = Arrays.asList(a,b,c);
        Assert.assertEquals(9, a.getRouteDistance(routeToEvaluate));
        routeToEvaluate = Arrays.asList(a,d);
        Assert.assertEquals(5, a.getRouteDistance(routeToEvaluate));
        routeToEvaluate = Arrays.asList(a,d,c);
        Assert.assertEquals(13, a.getRouteDistance(routeToEvaluate));
        routeToEvaluate = Arrays.asList(a,e,b,c,d);
        Assert.assertEquals(22, a.getRouteDistance(routeToEvaluate));
    }

    @Test(expected = Exception.class)
    public final void testNotFoundRoute()  {
        List<City> routeToEvaluate = Arrays.asList(a,e,d);
        a.getRouteDistance(routeToEvaluate);
    }

    @Test
    public final void testShortestRouteDistance() {
        List<City> cityMap = Arrays.asList(a,b,c,d,e);
        Assert.assertEquals(9, a.getShortestRouteDistance(cityMap, c));
        Assert.assertEquals(9, b.getShortestRouteDistance(cityMap, b));
    }

    @Test
    public final void distanceRouteABC(){

    }
}
