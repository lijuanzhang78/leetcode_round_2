package Passed;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreeII {
	public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (n==0) return res;
        res = helper(1, n);
        return res;
    }
    
    List<TreeNode> helper(int start, int end) {
    	System.out.println("[" + start + "," + end + ']');
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null);
            return result;
        }
        List<TreeNode> leftTree = new ArrayList<TreeNode>();
        List<TreeNode> rightTree = new ArrayList<TreeNode>();
        for (int i = start; i <=end; i++) {
        	leftTree = helper(start,i-1);
            rightTree = helper(i+1, end);
            
            for(TreeNode left : leftTree) {
                for(TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
    	new UniqueBinarySearchTreeII().generateTrees(3);
    		
    }   
}
