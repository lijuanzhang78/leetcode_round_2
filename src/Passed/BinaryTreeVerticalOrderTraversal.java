package Passed;

public class BinaryTreeVerticalOrderTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<node> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        queue.add(new node(root, 0));
        
        while(!queue.isEmpty()) {
            node curr = queue.poll();
            if (!map.containsKey(curr.col)) {
                List<Integer> list = new ArrayList<>();
                map.put(curr.col, list);
            }
            map.get(curr.col).add(curr.root.val);
            
            if (curr.root.left != null) queue.add(new node(curr.root.left, curr.col-1));
            if (curr.root.right != null) queue.add(new node(curr.root.right, curr.col+1));
        }
        
        Set<Integer> set = map.keySet();
        for(Integer col : set) {
            res.add(map.get(col));
        }
        return res;
    }
    
    class node {
        TreeNode root;
        int col;
        node(TreeNode root, int col) {
            this.root = root;
            this.col = col;
        }
    }

}
