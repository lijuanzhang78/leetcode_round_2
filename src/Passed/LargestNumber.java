package Passed;

public class LargestNumber {
	 public String largestNumber(int[] nums) {
	        if (nums == null || nums.length == 0) return new String("");
	        
	        Comparator<String> comparator = new intcomparator();
	        PriorityQueue<String> pq = new PriorityQueue<String>(comparator);
	        
	        for(int num : nums) {
	            pq.offer(String.valueOf(num));
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        
	        while(pq.size() > 0) {
	            sb.append(pq.poll());
	        }
	        String res = sb.toString();
	        return res.charAt(0)=='0'? "0" : res;
	    }
	    
	    public class intcomparator implements Comparator<String> {
	        public int compare(String str1, String str2) {
	            String s1 = str1 + str2;
	            String s2 = str2 + str1;
	            return s2.compareTo(s1);
	        }
	    }
}
