package TwoPointers;

public class PermutationInAString {
	 public boolean checkInclusion(String s1, String s2) {
	        int len1 = s1.length(), len2 = s2.length();
	        if (len2 < len1) return false;
	        int[] map1 = new int[26];
	        int[] map2 = new int[26];
	        int count = 0;
	        
	        char[] arr1 = s1.toCharArray(), arr2 = s2.toCharArray(); 
	        for(int i = 0; i < len1; i++) {
	            map1[arr1[i] - 'a']++;
	        }
	        for(int i = 0; i < len1; i++) {
	            if (map1[arr2[i]-'a'] > 0) {
	                if (map2[arr2[i]-'a'] < map1[arr2[i] - 'a']) {
	                    count++;
	                }
	                map2[arr2[i]-'a']++;
	            }
	        }
	        if(count == len1) return true;
	        int left = 0;
	        for(int i  = len1; i < len2; i++) {
	            if(map1[arr2[left]-'a'] > 0) {
	                if (map2[arr2[left]-'a'] <= map1[arr2[left]-'a']) {
	                    count--;
	                }
	                map2[arr2[left]-'a']--;
	            }
	             
	            if (map1[arr2[i]-'a'] > 0) {
	                if (map2[arr2[i]-'a'] < map1[arr2[i] - 'a']) {
	                    count++;
	                }
	                map2[arr2[i]-'a']++;
	            }
	            if (count == len1) return true;
	            left++;
	            
	        }
	        return false;
	    }
	
	public static void main(String[] args) {
		PermutationInAString test = new PermutationInAString();
		String s1 = "ky", s2 = "ainwkckifykxlribaypk";
		boolean res = test.checkInclusion(s1, s2);	
		return;
	}
}
