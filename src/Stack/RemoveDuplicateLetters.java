package Stack;

public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return new String("");
        boolean[] visited = new boolean[26];
        int[] counts = new int[26];
        char[] arr = s.toCharArray();
        for(char c : arr) {
            counts[c-'a']++;
        }
        Stack<Character> stack = new Stack<>();
        
        for(char c : arr) {
            counts[c-'a']--;
            if (visited[c-'a']) continue;
            
            while(stack.size() > 0 && stack.peek() > c && counts[stack.peek()-'a'] > 0) {
                visited[stack.pop()-'a'] = false;
            }
            stack.push(c);
            visited[c-'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while(stack.size() > 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();    
    }
}
