package Passed;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
	   public String serialize(TreeNode root) {
	        if (root == null) return "";
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.add(root);
	        StringBuilder sb = new StringBuilder();
	        sb.append(root.val + "@");
	        
	        while(!queue.isEmpty()) {
	            int size = queue.size();
	            for(int i = 0; i < size; i++) {
	                TreeNode curr = queue.poll();
	                
	                if (curr.left != null) {
	                    queue.add(curr.left);
	                    sb.append(curr.left.val + " ");
	                } else {
	                    sb.append("#" + " ");
	                }
	                
	                if (curr.right != null) {
	                    queue.add(curr.right);
	                    sb.append(curr.right.val + " ");
	                } else {
	                    sb.append("#" + " ");
	                }
	            }
	            sb.deleteCharAt(sb.length() - 1);
	            sb.append("@");
	        }
	        return sb.toString();
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        if(data == "") return null;
	        String[] str = data.split("@");
	        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
	        
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.add(root);
	        
	        for(int i = 1; i < str.length; i++) {
	            String[] levelstr = str[i].split(" ");
	            for(int k = 0; k < levelstr.length; k++) {
	                TreeNode curr = queue.poll();
	                if (!levelstr[k].equals("#")) {
	                    TreeNode left = new TreeNode(Integer.parseInt(levelstr[k]));
	                    curr.left = left;
	                    queue.add(left);
	                } else {
	                    curr.left = null;
	                }
	                k++;
	                
	                if (!levelstr[k].equals("#")) {
	                    TreeNode right = new TreeNode(Integer.parseInt(levelstr[k]));
	                    curr.right = right;
	                    queue.add(right);
	                } else {
	                    curr.right = null;
	                }
	            }
	        }
	        return root;
	    }
	 
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	root.right = new TreeNode(2);
    	root.left = null;
    	
    	SerializeAndDeserializeBinaryTree tree = new SerializeAndDeserializeBinaryTree();
    	tree.deserialize(tree.serialize(root));   	
    }

}
