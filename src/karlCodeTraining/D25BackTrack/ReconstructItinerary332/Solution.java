package karlCodeTraining.D25BackTrack.ReconstructItinerary332;

import java.util.*;

public class Solution {

    List<String> res = new ArrayList<>();
    Map<String, Map<String, Integer>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String departure = ticket.getFirst();
            String destination = ticket.getLast();
            Map<String, Integer> tempMap;
            if (map.containsKey(departure)) {
                tempMap = map.get(departure);
                tempMap.put(destination, tempMap.getOrDefault(destination, 0) + 1);
            } else {
                tempMap = new TreeMap<>();
                tempMap.put(destination, 1);
            }
            map.put(departure, tempMap);
        }
        res.add("JFK");
        backtrack(tickets.size());
        return new ArrayList<>(res);
    }

    private boolean backtrack(int ticketSize) {

        if (res.size() == ticketSize + 1) {
            return true;
        }
        String lastDestination = res.getLast();
        if (map.containsKey(lastDestination)) {
            Map<String, Integer> destinationMap = map.get(lastDestination);
            for (Map.Entry<String, Integer> nextDestinationMap : destinationMap.entrySet()) {
                String nextDestination = nextDestinationMap.getKey();
                Integer remainingTickets = nextDestinationMap.getValue();

                if (remainingTickets > 0) {
                    nextDestinationMap.setValue(remainingTickets - 1);
                    res.add(nextDestination);
                    if (backtrack(ticketSize)) {
                        return true;
                    };
                    res.removeLast();
                    nextDestinationMap.setValue(remainingTickets);
                }

            }
        }
        return false;
    }
}
