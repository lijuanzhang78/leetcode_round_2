package Passed;

import java.util.HashMap;
import java.util.Map;

public class TwoSumDesign {
	Map<Integer, Integer> map = new HashMap<>();
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    if (map.containsKey(number)) {
	        map.put(number, map.get(number)+1);
	    } else {
	        map.put(number,1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(Integer num : map.keySet()) {
	        int other = value - num;
	        if (num == other) {
	            if(map.get(num) > 1) return true;
	        } else {
	            if(map.containsKey(other)) return true;
	        }
	    }
	    return false;
	}
	
	public static void main(String[] args) {
		TwoSumDesign ts = new TwoSumDesign();
		ts.add(0);
		ts.add(-1);
		ts.add(1);
		ts.find(0);
	}
	

}
