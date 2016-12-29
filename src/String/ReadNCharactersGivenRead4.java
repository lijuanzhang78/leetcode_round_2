package String;

public class ReadNCharactersGivenRead4 {
	public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int total = 0;
        boolean eof = false;
        
        while(!eof && total < n) {
            int count = read4(temp);
            eof = count < 4;
            
            count = Math.min(count,n-total);
            for(int i = 0; i < count; i++) {
                buf[total++] = temp[i];
            }
        }
        return total;
    }
}
