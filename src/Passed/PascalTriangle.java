package Passed;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        List<Integer> old = new ArrayList<>();
        
        for(int i = 0; i < numRows; i++) {
            if (i == 0) {
                old.add(1);
                res.add(new ArrayList<Integer>(old));
                continue;
            }
            
            List<Integer> curr = new ArrayList<Integer>();
            old = res.get(i-1);
            for(int j = 0; j <= i; j++) {
                if (j == 0) {
                    curr.add(old.get(0));
                } else if ( j == i) {
                    curr.add(1);
                } else {
                    curr.add(old.get(j) + old.get(j-1));
                }
            }
            res.add(curr);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		List<List<Integer>> res = new ArrayList<>();
		res = new PascalTriangle().generate(3);	
	}

}
