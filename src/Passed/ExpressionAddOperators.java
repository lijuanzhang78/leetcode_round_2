package Passed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        Map<Integer, List<String>> map = new HashMap<>();
        helper(map, num);
        return map.get(target) == null? res : map.get(target); 
    }
    
    void helper(Map<Integer, List<String>> res, String num) {
        if (num.length() == 1) {
            List<String> list = new ArrayList<>();
            list.add(num);
            res.put(Integer.valueOf(num), list);
            return;
        }
        
        for(int i = 1; i < num.length(); i++) {
            Integer part1 = Integer.valueOf(num.substring(0,i));
            Map<Integer, List<String>> part2 = new HashMap<>();
            
            helper(part2, num.substring(i));
            for(Integer p2 : part2.keySet()) {
                buildRes(res, part1, part2, p2);
            }
        }
    }
    
    void buildRes(Map<Integer, List<String>> res, Integer p1, Map<Integer, List<String>> part2, Integer p2) {
        List<String> list2 = part2.get(p2);
       
        for(String l2 : list2) {
        	if (!res.containsKey(p1+p2)) {
        		res.put(p1+p2, new ArrayList<String>());
             }
            if (!res.containsKey(p1-p2)) {
            	res.put(p1-p2, new ArrayList<String>());
            }
            if (!res.containsKey(p1*p2)) {
                res.put(p1*p2, new ArrayList<String>());
            }
            res.get(p1+p2).add(p1+"+"+l2);
            res.get(p1-p2).add(p1+"-"+l2);
            res.get(p1*p2).add(p1+"*"+l2);
        }    
    }
    
    public static void main(String[] args) {
    	List<String> res = new ArrayList<>();
    	res = new ExpressionAddOperators().addOperators("232", 8); 	
    }
}
