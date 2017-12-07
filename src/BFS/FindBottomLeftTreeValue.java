package BFS;

public class FindBottomLeftTreeValue {
	public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int res = 0;
        while(q.size() > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (i == 0) res = curr.val;
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
        } 
        return res;    
    }

}
