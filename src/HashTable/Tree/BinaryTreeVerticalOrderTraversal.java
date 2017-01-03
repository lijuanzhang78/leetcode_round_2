package HashTable.Tree;

// use LinkedListHashMap to ensure the inserting order

public class BinaryTreeVerticalOrderTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        
        Map<TreeNode,Integer> map = new LinkedHashMap<>();
        map.put(root,0);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int min = 0;
        int max = 0;
        while(q.size() > 0) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                q.offer(curr.left);
                map.put(curr.left,map.get(curr)-1);
                min = Math.min(min,map.get(curr)-1);
            }
            if (curr.right != null) {
                q.offer(curr.right);
                map.put(curr.right,map.get(curr)+1);
                max = Math.max(max,map.get(curr)+1);
            }
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = min; i <= max; i++) {
            res.add(new ArrayList<Integer>());
        }
        for(TreeNode node : map.keySet()) {
            int level = map.get(node) - min;
            res.get(level).add(node.val);
        }
        return res;
    }
}
