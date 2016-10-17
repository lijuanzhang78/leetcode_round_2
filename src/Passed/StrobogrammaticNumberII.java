package Passed;

public class StrobogrammaticNumberII {
	Map<Character, Character> map = new HashMap<>();
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        char[] single = {'0', '1', '8'};
        map.put('0','0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        char[] temp = new char[n];
        helper(temp,res,map,single,0,n-1,n);
        return res;
    }
    
    void helper(char[] temp, List<String> res, Map<Character, Character> map, char[] single, int start, int end, int n) {
        if (n == 0) {
            if (temp.length == 1 || temp[0] != '0') res.add(new String(temp));
            return;
        } else if (n == 1) {
            for(int i = 0; i < single.length; i++) {
                temp[temp.length/2] = single[i];
                if (temp.length == 1 || temp[0] != '0') res.add(new String(temp));
            }
            return;
        } else {
            for(Character ch : map.keySet()) {
                temp[start] = ch;
                temp[end] = map.get(ch);
                helper(temp,res,map,single,start+1,end-1,n-2);
            }
        }
    }
}
