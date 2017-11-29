package Heap;

public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0) return new ArrayList<String>();
        List<String> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(String w : words) {
            if(!map.containsKey(w)) {
                map.put(w,0);
            }
            map.put(w,map.get(w)+1);            
        }
        
        Queue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() == b.getValue()? 
        b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());
        
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry);
                continue;
            }
            pq.offer(entry);
            pq.poll();            
        }
        
        while(pq.size() > 0) {
            res.add(0,pq.poll().getKey());
        }
        return res;    
    }
}
