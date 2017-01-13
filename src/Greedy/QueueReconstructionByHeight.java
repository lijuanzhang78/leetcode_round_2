package Greedy;

public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) return new int[0][0];
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int a[], int b[]) {
                if (a[0] != b[0]) {
                    return b[0]-a[0];
                } else {
                    return a[1]-b[1];
                }
            }
        });
        List<int[]> res = new ArrayList<int[]>();
        for(int[] p : people) {
            res.add(p[1],p);
        }
        return res.toArray(new int[res.size()][]);
    }
}
