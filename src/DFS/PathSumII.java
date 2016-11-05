package DFS;

public class PathSumII {
	 public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        List<List<Integer>> res = new ArrayList<>();
	        List<Integer> list = new ArrayList<>();
	        pathSum(root,sum,res,list);
	        return res;
	    }
	    
	    public void pathSum(TreeNode root, int target, List<List<Integer>> res, List<Integer> list) {
	        if (root == null) return;
	        if (root.left == null && root.right == null && target == root.val) {
	            list.add(root.val);
	            res.add(new ArrayList<Integer>(list));
	            list.remove(list.size()-1);
	            return;
	        }
	        
	        list.add(root.val);
	        pathSum(root.left, target-root.val,res,list);
	        pathSum(root.right,target-root.val,res,list);
	        list.remove(list.size()-1);
	    }
}
