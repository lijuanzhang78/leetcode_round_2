package Passed;

public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> a[0] != b[0]? b[0]-a[0] : a[1]-b[1]);
        List<int[]> ans = new ArrayList<>();
        for(int[] cur : people) {
            ans.add(cur[1], cur);
        }
        return ans.toArray(new int[people.length][]);
    }
}
