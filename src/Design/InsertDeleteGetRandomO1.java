package Design;

// list.set(index,element);
// rand.nextInt(range);

public class InsertDeleteGetRandomO1 {
	java.util.Random rand = new java.util.Random();
    Map<Integer,Integer> map;
    List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer,Integer>();
        list = new LinkedList<Integer>(); 
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        if (index == list.size()-1) {
            list.remove(index);
            map.remove(val);
            return true;
        }
        int last = list.get(list.size()-1);
        map.put(last,index);
        map.remove(val);
        list.set(index,last);
        list.remove(list.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}
