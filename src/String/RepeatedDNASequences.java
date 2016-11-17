package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 20) return res;
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i <= 9; i++) {
            Map<String,Integer> map = new HashMap<>();
            String first = s.substring(i,i+10);
            map.put(first,1);
            for(int j = i+10; j <= s.length()-10; j+=10) {
                String str = s.substring(j,j+10);
                if (!map.containsKey(str)) map.put(str,0);
                map.put(str,map.get(str)+1);
            }
            for(String key : map.keySet()) {
                if (map.get(key) > 1) set.add(key);
            }
        }
        for(String ss : set) {
            res.add(ss);
        }
        return res;
    }
	
	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> res = new RepeatedDNASequences().findRepeatedDnaSequences(s);		
	}
}
