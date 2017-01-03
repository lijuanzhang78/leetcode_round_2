package Design;

public class LRUCache {
	int max;
    int count;
    class node {
        int key, value;
        node prev, post;
        public node(int key, int value) {
            this.key = key;
            this.value = value;
            node prev = null;
            node post = null;
        }
    }
    Map<Integer,node> map = new HashMap<Integer,node>();
    node head;
    node tail;
    
    public LRUCache(int capacity) {
        this.max = capacity;
        count = 0;
        head = new node(-1,-1); // psuedo
        tail = new node(-1,-1); // psuedo
        head.post = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            node curr = map.get(key);
            removeNode(curr); // node could be in the middle
            addToHead(curr);
            return map.get(key).value;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            node curr = map.get(key);
            removeNode(curr);
            curr.value = value;
            addToHead(curr);
        } else {
            if (count == max) {
                node last = tail.prev;
                map.remove(last.key);
                removeNode(last);
                count--;
            }
            node newnode = new node(key,value);
            map.put(key,newnode);
            addToHead(newnode);
            count++;
        }
    }
    
    void removeNode(node toremove) {
        toremove.prev.post = toremove.post;
        toremove.post.prev = toremove.prev;
    }
    
    void addToHead(node toadd) {
        node oldhead = head.post;
        toadd.post = oldhead;
        toadd.prev = head;
        oldhead.prev = toadd;
        head.post = toadd;
    }
}
