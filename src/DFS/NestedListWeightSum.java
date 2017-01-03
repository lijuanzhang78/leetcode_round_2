package DFS;

public class NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        return depthSum(nestedList,1);
    }
    
    int depthSum(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for(NestedInteger nint : nestedList) {
            if (nint.isInteger()) {
                sum += nint.getInteger()*level;
            } else {
                sum += depthSum(nint.getList(),level+1);
            }
        }
        return sum;
    }
}
