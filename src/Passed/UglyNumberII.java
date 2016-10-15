package Passed;

import java.util.TreeSet;

public class UglyNumberII {
	public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<Long>();
        set.add(1l);
        int count = 0;
        Long curr = 0l;
        while(count < n) {
            curr = set.pollFirst();
            System.out.println(curr);
            count++;
            set.add(curr*2);
            set.add(curr*3);
            set.add(curr*5);
        }
        return curr.intValue();
    }
	
	public static void main(String[] args) {
		int res = new UglyNumberII().nthUglyNumber(40);	
	}
}
