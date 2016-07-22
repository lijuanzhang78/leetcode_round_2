package Passed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new LinkedList<String>();
        if (tickets == null || tickets.length == 0) return res;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String[] ticket : tickets) {
            if (map.containsKey(ticket[0])) {
                map.get(ticket[0]).add(ticket[1]);
            } else {
                List<String> q = new ArrayList<String>();
                q.add(ticket[1]);
                map.put(ticket[0], q);
            }
        }
        
        for(List<String> q : map.values()) {
            Collections.sort(q);
        }
        
//        res.add('JFK');
        int n = tickets.length + 1;
        
        dfs("JFK", map, res, n);
        return res;
    }
    
    boolean dfs(String curr, Map<String, List<String>> map, List<String> res, int n) {
        res.add(curr);
        if (res.size() >= n) return true;
        
        if (!map.containsKey(curr) || map.get(curr).isEmpty()) return false;
        List<String> arrivals = map.get(curr);
        
        for(int i = 0; i < arrivals.size(); i++) {
            String arrival = arrivals.remove(i);
            if (dfs(arrival, map, res, n)) return true;
            res.remove(res.size()-1);
            arrivals.add(i,arrival);
        }
        return false;    

    }
 
    public static void main(String[] args) {
    	String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
    	new ReconstructItinerary().findItinerary(tickets);    	
    }
}
