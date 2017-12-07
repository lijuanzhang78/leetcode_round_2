package BFS;

public class FindLargestValueInEachTreeRow {
	public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(q.size() > 0) {
            int large = Integer.MIN_VALUE;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                large = Math.max(large, curr.val);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            res.add(large);            
        }
        return res;
    }
}
