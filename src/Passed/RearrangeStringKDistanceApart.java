package Passed;

public class RearrangeStringKDistanceApart {
	public String rearrangeString(String str, int k) {
        if (str == null || str.length() == 0) return new String("");
        if(k == 0) return str;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch,1);
            } else {
                map.put(ch, map.get(ch)+1);
            }
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> (b.getValue() - a.getValue()));
        pq.addAll(map.entrySet());
        
        StringBuilder sb = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        while(pq.size() > 0) {
            Map.Entry<Character, Integer> curr = pq.poll();
            sb.append(curr.getKey());
            curr.setValue(curr.getValue()-1);
            queue.add(curr);
            
            if (queue.size() < k) continue;
            
            Map.Entry<Character, Integer> front = queue.poll();
            if (front.getValue() > 0) pq.offer(front);
        }
    
        return sb.length() == str.length()? sb.toString() : new String("");
    }
}
