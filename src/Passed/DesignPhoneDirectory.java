package Passed;

public class DesignPhoneDirectory {
	Set<Integer> used;
    Queue<Integer> unused;
    int max;
    
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        unused = new LinkedList<Integer>();
        used = new HashSet<Integer>();
        max = maxNumbers;
        for(int i = 0; i < maxNumbers; i++) {
            unused.offer(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (unused.size() == 0) return -1;
        int res = unused.poll();
        used.add(res);
        return res;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number < 0 && number >= max) return false; 
        return !used.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (used.contains(number)) {
            used.remove(number);
            unused.offer(number);
        }
    }
}
