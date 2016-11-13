package HashTable.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// java array instance has no implementation of equals !!!!
//
public class NumberOfBoomerangs {
	public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) return 0;
        
        checkHashSet();
        Set<int[]> set = new HashSet<int[]>();
        for(int[] pt : points) {
            set.add(pt);
        }
        int res = 0;
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if (i == j) continue;
                if ((points[i][0]+points[j][0])%2 == 0 && (points[i][1]+points[j][1])%2 == 0) {
                    int x = (points[i][0]+points[j][0])/2;
                    int y = (points[i][1]+points[j][1])/2;
                    int[] mid = new int[]{x,y};
                    if (set.contains(mid)) res++;
                }
            }
        }
        return res;
    }
	
	void checkHashSet() {
		Set<int[]> set = new HashSet<int[]>();
		Set<List<Integer>> set2 = new HashSet<>();
		List<Integer> list1 = new ArrayList<>();
		list1.add(0);list1.add(0); 
		set2.add(list1);
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);list2.add(1); 
		set2.add(list2);
	
		List<Integer> list3 = new ArrayList<>();
		list3.add(0);list3.add(0); set2.add(list3);
		boolean test = set2.contains(list3);
		
		
		set.add(new int[]{0,0});
		set.add(new int[]{1,1});
		
		int[] xx = new int[]{0,0};
		int[] yy = new int[]{0,0};
		boolean res = set.contains(xx);
		
		boolean aaa = xx.equals(yy);
		boolean ccc = Arrays.equals(xx, yy);
		boolean bbb= true;
	}
	
	
	public static void main(String[] args) {
		int[][] points = {{0,0}, {1,0}, {2,0}};
		int res = new NumberOfBoomerangs().numberOfBoomerangs(points);
	}
}
