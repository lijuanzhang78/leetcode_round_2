package Passed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	   public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if (root == null) return res;
	        
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.add(root);
	        
	        while(!queue.isEmpty()) {
	            List<Integer> list = new ArrayList<Integer>();
	            int size = queue.size();
	            for(int i = 0; i < size; i++) {
	                TreeNode curr = queue.poll();
	                list.add(curr.val);
	                if (curr.left != null) queue.add(curr.left);
	                if (curr.right != null) queue.add(curr.right);
	            }
	            res.add(list);
	        }
	        
	        return res;
	    }
}
