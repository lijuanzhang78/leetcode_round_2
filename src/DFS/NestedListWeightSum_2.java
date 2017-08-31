package DFS;

public class NestedListWeightSum_2 {
	int sum = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        helper(nestedList,1); 
        return sum;
    }
    
    void helper(List<NestedInteger> nestedList, int level) {
        for(NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += level * ni.getInteger();
            } else {
                helper(ni.getList(), level+1);                
            }            
        }        
    }   
}
