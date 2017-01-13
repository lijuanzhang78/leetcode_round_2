package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomII {
	public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        PriorityQueue<Interval> q = new PriorityQueue<Interval>((a,b)->(a.end - b.end));
        q.offer(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++) {
            Interval first = q.poll();
            if (intervals[i].start >= first.end) {
                first.end = intervals[i].end;
            } else {
                q.offer(intervals[i]);
            }
            q.offer(first);
        }
        return q.size();
    }	
}
