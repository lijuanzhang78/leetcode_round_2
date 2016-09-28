package Passed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ZigzagIterator {
	Iterator<Integer> v1 = null;
    Iterator<Integer> v2 = null;
    int curr = 0;
    boolean hasnext = false;
    int flag = 1;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1.iterator();
        this.v2 = v2.iterator();
    }

    public int next() {
        if (hasnext) {
            return curr;
        } else {
            return 0;
        }
    }

    public boolean hasNext() {
        if (flag == 1) {
            flag = -1;
            if (v1.hasNext()) {
                curr = v1.next();
                hasnext = true;
                return true;
            } else {
                if (v2.hasNext()) {
                    curr = v2.next();
                    hasnext = true;
                    return true;
                } else {
                    hasnext = false;
                    return false;
                }
            }
        } else {
            flag = 1;
            if (v2.hasNext()) {
                curr = v2.next();
                hasnext = true;
                return true;
            } else {
                if (v1.hasNext()) {
                    curr = v1.next();
                    hasnext = true;
                    return true;
                } else {
                    hasnext = false;
                    return false;
                }
            }
        }
    }
	
    public static void main(String[] args) {
    	//int[] arr1 = new int[]{1,2};
    	//int[] arr2 = new int[]{3,4,5,6};
    	List<Integer> v1 = new ArrayList<>();
    	List<Integer> v2 = new ArrayList<>();
    	v1.add(1); v1.add(2);
    	v2.add(3); v2.add(4); v2.add(5); v2.add(6);
    	
    	ZigzagIterator p = new ZigzagIterator(v1,v2);
    	List<Integer> res = new ArrayList<>();
    	while(p.hasNext()) {
    		res.add(p.next());
    	}	
    }
}
