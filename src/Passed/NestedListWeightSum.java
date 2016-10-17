package Passed;

public class NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        int sum = 0;
        for(NestedInteger nInt : nestedList) {
            sum += depthSumHelper(nInt, 1);
        }
        return sum;
    }
    
    int depthSumHelper(NestedInteger nestInt, int level) {
        if (nestInt.isInteger()) {
            return level*nestInt.getInteger();
        } else {
            int sum = 0;
            for(NestedInteger nInt : nestInt.getList()) {
                sum += depthSumHelper(nInt, level+1);
            }
            return sum;
        }
    }
}
