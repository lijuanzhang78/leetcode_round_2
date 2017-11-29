package Sort;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return new ArrayList<Interval>();
        intervals.sort((a,b)->(a.start - b.start));
        List<Interval> res = new ArrayList<>();
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval interval : intervals) {
            if (interval.start <= end) {
                end = Integer.max(interval.end,end);
            } else {
                res.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }    
        }
        res.add(new Interval(start,end)); 
        return res;
    }
}
