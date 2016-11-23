package Greedy;

public class AssignCookie {
	public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0 || s == null || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0, res = 0;
        for(int i = 0; i < s.length; i++) {
            if (s[i] >= g[j]) {
                res++;
                j++;
            }
            if (j >= g.length) break;
        }
        return res;
    }
}
