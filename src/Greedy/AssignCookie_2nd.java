package Greedy;

public class AssignCookie_2nd {
	public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0 || s == null || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0,j = 0;
        int count = 0;
        while(i < g.length) {
            if (j >= s.length) return count;
            if (s[j] >= g[i]) {
                count++; j++; i++;
            } else {
                j++;
            }
        }
        return count;
    }
}
