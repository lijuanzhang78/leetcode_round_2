package Design;

// for the follow up: to use a list to store all the K-iterators

public class ZigZagIterator {
	Iterator<Integer> iter1;
    Iterator<Integer> iter2;
    boolean islist1;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iter1 = v1.iterator();
        iter2 = v2.iterator();
        islist1 = true;
    }

    public int next() {
        if(islist1) {
            islist1 = false;
            return iter1.next();
        } else {
            islist1 = true;
            return iter2.next();
        }
    }

    public boolean hasNext() {
        if (islist1) {
            if (iter1.hasNext()) return true;
            if (iter2.hasNext()) {
                islist1 = false;
                return true;
            }
            return false;
        } else {
            if (iter2.hasNext()) return true;
            if (iter1.hasNext()) {
                islist1 = true;
                return true;
            }
            return false;
        }
    }
}
