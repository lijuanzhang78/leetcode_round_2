package BFS;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                list.add(curr.val);
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            res.add(list);
        }
        return res;
    }
}
