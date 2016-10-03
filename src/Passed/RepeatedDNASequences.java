package Passed;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<String>();
        Set<String> repeated = new HashSet<String>();
        
        for(int i = 0; i + 9 < s.length(); i++) {
            String str = s.substring(i, i+10);
            if (!seen.add(str)) {
                repeated.add(str);
            }
        }
        return new ArrayList<String>(repeated);
    }
}
