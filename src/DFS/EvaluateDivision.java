package DFS;

public class EvaluateDivision {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (equations == null || equations.length == 0 ) return new double[0];
        
        Map<String, Map<String, Double>> map = new HashMap<>();
        for(int i = 0; i < equations.length; i++) {
            String a = equations[i][0];
            String b = equations[i][1];
            if (!map.containsKey(a)) {
                map.put(a, new HashMap<String, Double>());
            }
            map.get(a).put(b,values[i]);
            
            if (!map.containsKey(b)) {
                map.put(b, new HashMap<String, Double>());
            }
            map.get(b).put(a,1.0/values[i]);
        }
        
        double[] res = new double[queries.length];
        for(int i = 0; i < queries.length ; i++) {
            String source = queries[i][0];
            String des = queries[i][1];
            if (map.containsKey(source) && map.containsKey(des)) {
                if (source.equals(des)) {
                    res[i] = 1.0; // 这一步需要注意
                    continue;
                }
                Set<String> set = new HashSet<String>();
                set.add(source);
                res[i] = dfs(source,des,map,set,1.0);
            } else {
                res[i] = -1.0;
            }
        }
        return res;
    }
    
    double dfs(String source, String des, Map<String, Map<String, Double>> map, Set<String> visited, double prev) {
        Map<String, Double> imap = map.get(source);
        for(String adj : imap.keySet()) {
            if (!visited.contains(adj)) {
                if (des.equals(adj)) {
                    return prev * imap.get(adj);
                } else {
                    visited.add(adj);
                    double res = dfs(adj,des,map,visited,prev*imap.get(adj));
                    if (res != -1.0) return res;
                }
            } 
        }
        return -1.0;
    }
}
