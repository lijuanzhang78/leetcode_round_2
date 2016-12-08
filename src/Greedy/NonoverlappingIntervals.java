package Greedy;

public class NonoverlappingIntervals {
	public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new myComparator());
        int end = intervals[0].end;
        int count = 1;
        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                count++;
                end = intervals[i].end;
            }
        }
        return intervals.length - count;
    }
    
    class myComparator implements Comparator<Interval> {
        public int compare (Interval a, Interval b) {
            return a.end - b.end;
        }
    }
}
