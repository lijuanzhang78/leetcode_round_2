package Backtracking;

public class PalindromePermutationII_2nd {public List<String> generatePalindromes(String s) {
    if (s == null || s.length() == 0) return new ArrayList<String>();
    Map<Character,Integer> map = new HashMap<>();
    for(int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (!map.containsKey(c)) map.put(c,0);
        map.put(c,map.get(c)+1);
    }
    
    boolean single = false;
    char csin = 'a';
    StringBuilder half = new StringBuilder();
    for(char c : map.keySet()) {
        int num = map.get(c);
        if (num % 2 > 0) {
            if (single) return new ArrayList<String>();
            single = true;
            csin = c;
        }
        for(int i = 0; i < num/2; i++) {
            half.append(c);
        }
    }
    
    List<String> res = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();
    boolean[] visited = new boolean[half.toString().length()];
    char[] arr = half.toString().toCharArray();
    Arrays.sort(arr);
    dfs(res,sb,arr,csin,single,visited);
    return res;
}

void dfs(List<String> res, StringBuilder sb, char[] arr, char csin, boolean single, boolean[] visited) {
    if (sb.length() == arr.length) {
       buildfull(sb,csin,single,res);
       return;
    }

    for(int i = 0; i < arr.length; i++) {
        if (visited[i]) continue;
        if (i > 0 && arr[i] == arr[i-1] && !visited[i-1]) continue;
        sb.append(arr[i]);
        visited[i] = true;
        dfs(res,sb,arr,csin,single,visited);
        visited[i] = false;
        sb.setLength(sb.length()-1);
    }
}

void buildfull(StringBuilder sb, char csin, boolean single, List<String> res) {
    int len = sb.length();
    String temp = sb.toString();
    if(single) temp += csin;
    for(int i = len-1; i>=0; i--) {
        char c = sb.charAt(i);
        temp += c;
    }
    res.add(temp);
}
}
