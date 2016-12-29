package Sort;

public class MeetingRoom {
	public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {return a.start - b.start;}
        });
        for(int i = 0; i < intervals.length-1; i++) {
            if (intervals[i].end > intervals[i+1].start) return false;
        }
        return true;
    }
}
