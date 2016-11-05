package BFS;

// 不能只变化跟end不一样的字符位，每一位都需要变化。
// 例如： ACB --》 AEF
// CCB -> CCF -> CEF -> AEF

public class MinimumGeneticMutation {
	public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0) return -1;
        Set<String> visited = new HashSet<>();
        Set<String> bankset = new HashSet<>();
        for(String s : bank) bankset.add(s);
        if (!bankset.contains(end)) return -1;
        visited.add(start);
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        List<Character> list = new ArrayList<>();
        list.add('A');list.add('C');list.add('G');list.add('T');
        
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            for(int isize = 0; isize < size; isize++) {
                String curr = q.poll();
                for(int i = 0; i < curr.length(); i++) {
                    char[] arr = curr.toCharArray();
                    
                        for(char ch : list) {
                            if (arr[i] != ch) {
                                arr[i] = ch;
                                String newstr = new String(arr);
                                if (end.equals(newstr)) return level;
                                if (!visited.contains(newstr) && bankset.contains(newstr)) {
                                    q.add(newstr);
                                    visited.add(newstr);
                                }
                            }
                        }
                }
            }
        }
        return -1;
    }
}
