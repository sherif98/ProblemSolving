package arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotelBookingsPossible {

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int k) {
        List<Pair> arrivals = arrive.stream()
                .map(ar -> new Pair(ar, 1))
                .collect(Collectors.toList());

        List<Pair> departures = depart.stream()
                .map(de -> new Pair(de, -1))
                .collect(Collectors.toList());

        List<Integer> rate = Stream.concat(departures.stream(), arrivals.stream())
                .sorted(Comparator.comparingInt(a -> a.time))
                .map(p -> p.type)
                .collect(Collectors.toList());

        int needed = 0;
        int acc = 0;
        for (int i = 0; i < rate.size(); i++) {
            acc += rate.get(i);
            needed = Math.max(needed, acc);
        }
        return needed <= k;
    }

    class Pair {
        int time;
        int type;

        Pair(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }
}
