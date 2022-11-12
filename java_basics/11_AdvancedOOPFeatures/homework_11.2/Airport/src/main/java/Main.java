import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        List<Flight> test = findPlanesLeavingInTheNextTwoHours(airport);
        System.out.println("a");
        for (Flight flight:test) System.out.println(flight);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        Date now = new Date();
        Calendar nowCall = Calendar.getInstance();
        nowCall.setTime(now);
        nowCall.add(Calendar.HOUR, 2);
        Date twoHoursLater = nowCall.getTime();
        Stream<Flight> stream = airport.getTerminals().stream().flatMap(s -> s.getFlights().stream());
        stream.forEach(System.out::println);


        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        return airport.getTerminals().stream()
                .flatMap(s -> s.getFlights().stream())
                .filter(flight -> flight.getDate().after(now) &&
                        flight.getDate().before(twoHoursLater) &&
                        flight.getType() != Flight.Type.ARRIVAL)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

}