package Design;

public class Flatten2DVector {
	Iterator<List<Integer>> iter0;
    Iterator<Integer> iter1;

    public Vector2D(List<List<Integer>> vec2d) {
        if (vec2d == null || vec2d.size() == 0) return;
        iter0 = vec2d.iterator();
    }

    @Override
    public Integer next() {
        //hasNext();
        return iter1.next();
    }

    @Override
    public boolean hasNext() {
        if (iter0 == null) return false;
        //if (iter1 == null || !iter1.hasNext()) {
            while (iter0.hasNext() && (iter1 == null || !iter1.hasNext())) {
                iter1 = iter0.next().iterator();
            }
        //}
        return iter1.hasNext(); 
    }
}
