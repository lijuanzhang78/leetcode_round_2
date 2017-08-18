package String;

public class ReverseStringII {
	public String reverseStr(String s, int k) {
        char[] charr = s.toCharArray();
        int len = s.length();
        for(int i = 0; i < len; ) {
            int begin = i;
            int end = begin + 2*k - 1;
            if (end < len) {
                reverse(charr,begin,k);
            } else if (len-begin < k) {
                reverse(charr,begin,len-begin);
            } else {
                reverse(charr,begin,k);    
            }  
            i += 2*k;
        }
        return new String(charr);        
    }
    
    void reverse(char[] arr, int begin, int num) {
        int l = begin;
        int r = begin+num-1;
        
        while(l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;r--;            
        }    
    }
}
