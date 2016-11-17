package Heap;

// PriorityQueue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>((a,b) -> (a.getValue()-b.getValue()));
// map.entrySet();
// entry.getKey(); 
// entry.getValue();
public class TopKFrequentElement {
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return res;
        
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num,1);
            } else {
                map.put(num, map.get(num)+1);
            }
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>((a,b) -> (a.getValue()-b.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            q.offer(entry);
            while (q.size() > k) {
                q.poll();
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : q) {
            res.add(0,entry.getKey());
        }
        return res;
    }
}
