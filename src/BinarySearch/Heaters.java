package BinarySearch;

public class Heaters {
	public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0) return 0;
        if (heaters == null || heaters.length == 0) return 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j = 0;
        int dis = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < houses.length; i++) {
            dis = Math.abs(houses[i] - heaters[j]); j++;
            while(j < heaters.length && Math.abs(houses[i]-heaters[j]) <= dis) {
                dis = Math.abs(houses[i]-heaters[j]);
                j++;
            }
            res = Math.max(res,dis);
            j--;
        }
        return res;
    }
}
