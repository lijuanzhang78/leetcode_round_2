package Greedy;

public class RearrangeStringkDistanceApart {
	public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) return "";
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length();i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c,0);
            }
            map.put(c,map.get(c)+1);    
        }
        Queue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b) -> (b.getValue() - a.getValue()));
        pq.addAll(map.entrySet());
        
        Queue<Map.Entry<Character,Integer>> wait = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 0) {
            Map.Entry<Character,Integer> curr = pq.poll();
            sb.append(curr.getKey());
            curr.setValue(curr.getValue()-1);
            wait.offer(curr);
            
            if (wait.size() < k) {
                continue;
            }
            Map.Entry<Character,Integer> front = wait.poll();
            if (front.getValue() > 0) {
                pq.offer(front);
            }
        }
        return sb.length() == s.length()? sb.toString() : "";    
    }

}
