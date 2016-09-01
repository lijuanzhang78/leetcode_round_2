package Passed;

public class DataStreamAsDisjointIntervals {
	ArrayList<Integer> list;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        list = new ArrayList<Integer>();
    }
    
    public void addNum(int val) {
        list.add(val); list.add(val);
        Collections.sort(list);
        int start = list.indexOf(val);
        int end = start+1;
        if (start % 2 != 0) {
            list.remove(start);
            list.remove(start);
            return;
        }
        
        boolean mergeF = false;
        boolean mergeB = false;
        if (start-1 >= 1 && (list.get(start-1) + 1 == val || list.get(start-1) == val)) {
            list.set(start-1,val);
            mergeF = true;
        }
        if (end + 1 <= list.size() - 2 && (list.get(end+1) - 1 == val || list.get(end+1) == val)) {
            list.set(end+1,val);
            mergeB = true;
        }
        if (mergeF && mergeB ) {
            list.remove(start-1);
            list.remove(start-1);
            list.remove(start-1);
            list.remove(start-1);
        }  else if (mergeF || mergeB) {
            list.remove(start);
            list.remove(start);
        } else {
            return;
        }
    }
    
    public List<Interval> getIntervals() {
        List<Interval> res = new ArrayList<>();
        for(int i = 0; i <= list.size()-2; i+=2) {
            Interval itv = new Interval(list.get(i), list.get(i+1));
            res.add(itv);
        }
        return res;
    }

}
