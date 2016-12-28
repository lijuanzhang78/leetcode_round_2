package Design;

public class DesignPhoneDirectory {
	Queue<Integer> q;
    Set<Integer> set;
    int max;
    
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        q = new LinkedList<Integer>();
        set = new HashSet<Integer>();
        max = maxNumbers;
        for(int i = 0; i < maxNumbers; i++) {
            q.offer(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (q.size() == 0) return -1;
        int res = q.poll();
        set.add(res);
        return res;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number >= 0 && number < max) {
            return !set.contains(number);
        }
        return false;
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (set.contains(number)) {
            q.add(number);
            set.remove(number);
        }
    }
}
