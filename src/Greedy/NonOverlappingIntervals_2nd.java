package Greedy;

public class NonOverlappingIntervals_2nd {
	public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        int count = 0;
        int minEnd = intervals[0].end;
        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < minEnd) {
                count++;
                minEnd = Math.min(minEnd, intervals[i].end);
            } else {
                minEnd = intervals[i].end;
            }
        }
        return count;
    }
}
