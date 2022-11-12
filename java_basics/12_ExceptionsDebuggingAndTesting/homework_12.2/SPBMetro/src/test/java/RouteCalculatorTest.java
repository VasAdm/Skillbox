import core.Line;
import core.Station;
import junit.framework.TestCase;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    RouteCalculator calculator;

    Line red = new Line(1, "Red");
    Line green = new Line(2, "Green");
    Line blue = new Line(3, "Blue");

    Station r1 = new Station("r1", red);
    Station r2 = new Station("r2", red);
    Station r3 = new Station("r3", red);
    Station r4 = new Station("r4", red);
    Station r5 = new Station("r5", red);

    Station g1 = new Station("g1", green);
    Station g2 = new Station("g2", green);
    Station g3 = new Station("g3", green);
    Station g4 = new Station("g4", green);

    Station b1 = new Station("b1", blue);
    Station b2 = new Station("b2", blue);
    Station b3 = new Station("b3", blue);

    @Override
    protected void setUp() {
        StationIndex stationIndex = new StationIndex();

        route = new ArrayList<>();

        red.addStation(r1);
        red.addStation(r2);
        red.addStation(r3);
        red.addStation(r4);
        red.addStation(r5);

        green.addStation(g1);
        green.addStation(g2);
        green.addStation(g3);
        green.addStation(g4);

        blue.addStation(b1);
        blue.addStation(b2);
        blue.addStation(b3);

        List<Station> rg = new ArrayList<>();
        List<Station> rb = new ArrayList<>();

        rg.add(r2);
        rg.add(g2);

        rb.add(r4);
        rb.add(b2);

        stationIndex.addStation(r1);
        stationIndex.addStation(r2);
        stationIndex.addStation(r3);
        stationIndex.addStation(r4);
        stationIndex.addStation(r5);
        stationIndex.addStation(g1);
        stationIndex.addStation(g2);
        stationIndex.addStation(g3);
        stationIndex.addStation(g4);
        stationIndex.addStation(b1);
        stationIndex.addStation(b2);
        stationIndex.addStation(b3);


        stationIndex.addLine(red);
        stationIndex.addLine(green);
        stationIndex.addLine(blue);

        stationIndex.addConnection(rg);
        stationIndex.addConnection(rb);

        route.add(g1);
        route.add(g2);
        route.add(r2);
        route.add(r3);
        route.add(r4);
        route.add(b2);
        route.add(b3);

        calculator = new RouteCalculator(stationIndex);
    }

    public void testCalculateDurationTest() {
//        double actual = calculator.calculateDuration(route);
        double actual = RouteCalculator.calculateDuration(calculator.getShortestRoute(g1, b3));
        double expected = 17;
        assertEquals(expected, actual);
    }

    public void testRouteOnTheLine() {
        List<Station> actual = calculator.getShortestRoute(r1, r4);
        List<Station> expected = new ArrayList<>(Arrays.asList(r1, r2, r3, r4));
        assertEquals(expected, actual);
    }

    public void testRouteWithOneConnection() {

        List<Station> actual1 = calculator.getShortestRoute(r1, g3);
        List<Station> expected1 = new ArrayList<>(Arrays.asList(r1, r2, g2, g3));
        assertEquals(expected1, actual1);
    }

    public void testRouteWithTwoConnections() {
        List<Station> actual2 = calculator.getShortestRoute(g1, b3);
        List<Station> expected2 = new ArrayList<>(Arrays.asList(g1, g2, r2, r3, r4, b2, b3));
        assertEquals(expected2, actual2);
    }
}
