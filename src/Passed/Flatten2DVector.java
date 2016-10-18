package Passed;

public class Flatten2DVector {
	Iterator<Integer> inner;
    Iterator<List<Integer>> outer;
    public Vector2D(List<List<Integer>> vec2d) {
        outer = vec2d.iterator();
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return inner.next();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while(inner == null || !inner.hasNext()) {
            if (outer.hasNext()) {
                inner = outer.next().iterator();
            } else {
                return false;
            }
        }
        return inner.hasNext();
    }
}
