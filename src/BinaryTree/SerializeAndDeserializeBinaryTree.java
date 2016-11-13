package BinaryTree;

public class SerializeAndDeserializeBinaryTree {
	 // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr != null) {
                    sb.append(curr.val+" ");
                    q.offer(curr.left);
                    q.offer(curr.right);
                } else {
                    sb.append("n ");
                }
            }
            sb.append("#");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] strs = data.split("#");
        TreeNode root = new TreeNode(Integer.valueOf(strs[0].trim()));
        q.offer(root);
        
        for(int i = 1; i < strs.length; i++) {
            int size = q.size();
            String[] currlevel = strs[i].split(" ");
            for(int j = 0; j < size; j++) {
                TreeNode parent = q.poll();
                TreeNode left = null, right = null;
                if (currlevel[j*2].equals("n")) {
                    parent.left = null;
                } else {
                    left = new TreeNode(Integer.valueOf(currlevel[j*2].trim()));
                    parent.left = left;
                }
                if (currlevel[j*2+1].equals("n")) {
                    parent.right = null;
                } else {
                    right = new TreeNode(Integer.valueOf(currlevel[j*2+1].trim()));
                    parent.right = right;
                }
                if (left != null) q.offer(left);
                if (right != null) q.offer(right);
            }
        }
        return root;
    }
}
