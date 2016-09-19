package Passed;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        int len = queries.length;
        double[] res = new double[len];
        Map<String, Map<String, Double>> map = new HashMap<>();
        
        for(int i = 0; i < equations.length; i++) {
            String[] e = equations[i];
            if (!map.containsKey(e[0])) {
                map.put(e[0], new HashMap<String, Double>());
            }
            map.get(e[0]).put(e[1], values[i]);
            
            if (!map.containsKey(e[1])) {
                map.put(e[1], new HashMap<String, Double>());
            }
            map.get(e[1]).put(e[0], 1/values[i]);
        }
        
        Set<String> visited = new HashSet<>();
        int j = 0;
        for(String[] q : queries) {
            String source = q[0];
            String des = q[1];
            double r = 0.0;
            if (!source.equals(des)) {
                r = helper(source, des, 1.0, visited, map);
            } else {
                if (map.containsKey(source)) {
                    r = 1.0;
                } else {
                    r = -1.0;
                }
            }
            res[j++] = r;
        }
        return res;
    }
    
    double helper(String source, String des, double prev, Set<String> visited, 
    Map<String, Map<String, Double> > map) {
        
        visited.add(source);
        Map<String, Double> adj = map.get(source);
        
        if (adj != null) {
            for(String key : adj.keySet()) {
                if (key.equals(des)) {
                    visited.remove(source);
                    return prev*adj.get(key);
                }
                if (!visited.contains(key)) {
                    double r = helper(key,des,prev*adj.get(key),visited,map);
                    if (r != -1.0) {
                        visited.remove(source);
                        return r;
                    } 
                    
                }
            }
        } 
        visited.remove(source);
        return -1.0;
    }
    
    public static void main(String[] args) {
    	String[][] equations = {{"x1","x2"},{"x2","x3"},{"x3","x4"},{"x4","x5"}};
    	double[] values = {3.0, 4.0, 5.0, 6.0};
    	String[][] queries = {{"x1","x5"},{"x5","x2"},{"x2","x4"},{"x2","x2"},{"x2","x9"},{"x9","x9"}};
    	
    	double[] res = new double[queries.length];
    	res = new EvaluateDivision().calcEquation(equations, values, queries);	
    }
}
