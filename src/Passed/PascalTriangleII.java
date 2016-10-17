package Passed;

public class PascalTriangleII {
	public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        
        prev.add(1);
        if(rowIndex == 0) return prev;
        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(0,1);
            for(int j = 1; j < prev.size(); j++) {
                curr.add(j,prev.get(j)+prev.get(j-1));
            }
            curr.add(prev.size(),1);
            prev = curr;
        }
        return prev;
    }
	
	public List<Integer> getRow_2nd(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if (rowIndex == 0) return res;
        for(int i = 1; i <= rowIndex; i++) {
            res.add(0,1);
            for(int j = 1; j < res.size()-1; j++) {
                res.set(j,res.get(j)+res.get(j+1));
            }
        }
        return res;
    }
}
