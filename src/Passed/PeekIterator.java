package Passed;

public class PeekIterator {
	Iterator<Integer> iterator;
    Queue<Integer> queue;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	    queue = new LinkedList<Integer>();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
	    if (!iterator.hasNext() && queue.isEmpty()) return null;
	    
	    if (queue.isEmpty()) {
	        queue.offer(iterator.next());
	    }
	    return queue.peek();
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (peek() == null) return null;
	    return queue.poll();
	}

	@Override
	public boolean hasNext() {
	    if(peek() == null) return false;
	    return true;
	}

}
