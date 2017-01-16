package Stack;

public class LongestAbsoluteFilePath {
	public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);
        String[] arr = input.split("\n");
        int res = 0;
        for(String s : arr) {
            int level = s.lastIndexOf("\t")+1;
            while(stack.size() > level + 1) stack.pop();
            int len = stack.peek() + s.length() - level + 1;
            stack.push(len);
            if (s.contains(".")) res = Math.max(len-1, res);
        }
        return res;
    }
}
