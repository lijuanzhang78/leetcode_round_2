package BinaryTree;

// it is about translating the problem - to get the height of each node 

public class FindAllLeavesOfBinaryTree {
	public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,root);
        return res;
    }
    
    int dfs(List<List<Integer>> res, TreeNode root) {
        if (root == null) return -1;
        
        int hleft = dfs(res, root.left);
        int hright = dfs(res, root.right);
        int h = 1 + Math.max(hleft,hright);
        if (res.size() == h) {
            res.add(new ArrayList<Integer>());
        }
        res.get(h).add(root.val);
        return h;
    }
}
