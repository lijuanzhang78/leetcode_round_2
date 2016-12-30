package HashTable.String;

// charValue()

public class StrabogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
        Map<Character,Character> map = new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        map.put('8','8');
        map.put('6','9');
        map.put('9','6');
        
        char[] arr = num.toCharArray();
        int low = 0, high = arr.length - 1;
        while(low <= high) {
            char ch = arr[low];
            if (!map.containsKey(ch)) return false;
            if (map.get(ch).charValue() != arr[high]) return false;
            low++;
            high--;
        }
        return true;
    }
}
