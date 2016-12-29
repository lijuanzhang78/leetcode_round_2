package String;

public class FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length-1; i++) {
            if (arr[i] == '+' && arr[i+1] == '+') {
                arr[i] = '-'; arr[i+1] = '-';
                res.add(new String(arr));
                arr[i] = '+'; arr[i+1] = '+';
            }
        }
        return res;
    }
}
