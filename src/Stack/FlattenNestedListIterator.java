package Stack;

public class FlattenNestedListIterator {
	Stack<Iterator<NestedInteger>> stack = new Stack<Iterator<NestedInteger>>();
    NestedInteger nextInt;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return nextInt.getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            if (!stack.peek().hasNext()) {
                stack.pop();
            } else {
                nextInt = stack.peek().next();
                if (nextInt.isInteger()) return true;
                stack.push(nextInt.getList().iterator()); 
            }
        }
        return false;
    }
}
