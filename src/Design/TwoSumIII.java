package Design;

public class TwoSumIII {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    if (!map.containsKey(number)) map.put(number,0);
	    map.put(number,map.get(number)+1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(Integer num : map.keySet()) {
	        int other = value - num;
	        if (other == num) {
	            if (map.get(num) > 1) return true;
	        } else {
	            if (map.containsKey(other)) return true;
	        }
	    }
	    return false;
	}
}
