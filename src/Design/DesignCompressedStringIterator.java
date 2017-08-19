package Design;

public class DesignCompressedStringIterator {
	class StringIterator {
	    int index;
	    int count;
	    int prev;
	    String compressedString;
	    public StringIterator(String compressedString) {
	        if (compressedString == null) return;
	        index = 0; 
	        count = 0;
	        prev = 0;
	        this.compressedString = new String(compressedString);
	        return;
	    }
	    
	    public char next() {
	        if (hasNext()) {
	            count--;
	            return compressedString.charAt(index);
	        } else {
	            return ' ';
	        }
	                 
	    }
	    
	    public boolean hasNext() {
	        if (count == 0) {
	            index += prev;
	            if (index >= compressedString.length()) {
	                return false;
	            } else {
	                count = getNum(index);
	                return true;
	            }
	        } else {
	            return true;
	        }
	    }
	    
	    public int getNum(int index) {
	        int num = 0;
	        prev = 0;
	        while(++index < compressedString.length()) {
	            char c = compressedString.charAt(index);
	            if (c >= '0' && c <= '9') {
	                prev++;
	                num = num*10 + (c-'0');
	            } else {
	                break;
	            } 
	        }
	        prev++;
	        return num;
	    }
	}

}
