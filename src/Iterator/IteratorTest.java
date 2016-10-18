package Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* Tests if the empty collection's iterator is null. */
public class IteratorTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Iterator<Integer> it = list.iterator();
		System.out.println("it has next: " + it.hasNext());
	}
}
