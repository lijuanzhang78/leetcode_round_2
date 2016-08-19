package Passed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RandomizedCollection {
	List<Integer> nums;
    Map<Integer, Set<Integer>> map;
    java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<Integer>();
        map = new HashMap<Integer, Set<Integer>>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            map.get(val).add(nums.size());
            nums.add(val);
            return false;
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(nums.size());
            map.put(val, set);
            nums.add(val);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        
        Set<Integer> locs = map.get(val);
        Iterator<Integer> iter = locs.iterator();
        Integer index = iter.next();
        
        if (index < nums.size() - 1 && nums.get(index) != nums.get(nums.size()-1)) {
            int lastnum = nums.get(nums.size()-1);
            nums.set(index, lastnum);
            map.get(lastnum).remove(nums.size()-1);
            map.get(lastnum).add(index);
            
            map.get(val).remove(index);
            if(map.get(val).isEmpty()) map.remove(val);
            nums.remove(nums.size()-1);
        } else {
            map.get(val).remove(nums.size()-1);
            nums.remove(nums.size()-1);
            if (map.get(val).isEmpty()) map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
	
	public static void main(String[] args) {
		RandomizedCollection wd = new RandomizedCollection();
		
		wd.insert(0);
	    wd.insert(1);
	    wd.insert(2);
	    wd.insert(3);
	    wd.insert(3);
	    wd.remove(2);
	    wd.remove(3);
	    wd.remove(0);
	    
	    }

}
