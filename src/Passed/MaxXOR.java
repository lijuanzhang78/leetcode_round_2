package Passed;

public class MaxXOR {
	final int kBits = 32;
	
    class trieNode {
        trieNode[] children;
        public trieNode(){
            children = new trieNode[2];
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        trieNode root = new trieNode();
        for(int num : nums) {
            trieNode curr = root;
            for(int i = kBits - 1; i >= 0; i--) {
                int bit = (num >>> i) & 1; // current bit
                if(curr.children[bit] == null) {
                    trieNode newnode = new trieNode();
                    curr.children[bit] = newnode;
                }
                curr = curr.children[bit];
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
        	trieNode curr = root;
            int sum = 0;
            for(int i = kBits - 1; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                int addition = 0;
                if (bit == 0) {
                    if(curr.children[1] != null) {
                        curr = curr.children[1];
                        addition = 1;
                    } else {
                        curr = curr.children[0];
                    }
                } else {
                    if(curr.children[0] != null) {
                        curr = curr.children[0];
                        addition = 1;
                    } else {
                        curr = curr.children[1];
                    }
                }
                sum = (sum << 1) + addition;
            }
            max = Math.max(sum,max);
        }
        return max;
    }
    
    public static void main(String[] args) {
    	int[] input = {89,102,183,233,175,87,497,350,348,191,136,497,166,420,279,212,269,125,262,74};
    	MaxXOR max_xor = new MaxXOR();
    	int result = max_xor.findMaximumXOR(input);
    	System.out.println("result is " + result);
    }
}
