package graphs;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructIternary {
    static List<String> result;

    public static List<String> findIternary(List<List<String>> tickets) {
        // first of all create a adjList.
        result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.put(ticket.get(0), new ArrayList<>());
        }
        for (List<String> ticket : tickets) {
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        // source node ko travel krne keh two options hai
        // first thing is kii woh lexicographically smallest string pr jaaye
        // yaa fir woh ek aise string pr jaaye jo exist kare valid ho.
        // there for meh in doh choices pr sorting kr dunga simplyyyy.

        for (Map.Entry<String, List<String>> m : map.entrySet()) {
            Collections.sort(m.getValue());
        }
        int numberOfTickets = tickets.size() + 1;

        List<String> path = new ArrayList<>();
        dfs("JFK", numberOfTickets, map, path);
        return result;
    }

    public static boolean dfs(String source, int numberOfTickets, HashMap<String, List<String>> map,
            List<String> path) {
        path.add(source);
        if (path.size() == numberOfTickets + 1) {
            result = path;
            return true;
        }
        List<String> neighbour = map.get(source);
        for (int i = 0; neighbour != null && i < neighbour.size(); i++) {
            String toAirPort = neighbour.get(i);
            if (dfs(toAirPort, numberOfTickets, map, path)) {
                return true;
            }
            neighbour.add(i, toAirPort);
        }
        path.remove(path.size() - 1);
        return false;

    }
}
