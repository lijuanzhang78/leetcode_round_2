package HashTable.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 错误原因： break/continue的用法。需要加一个flag。
public class KeyboardRow {
	char[][] ch = {{'Q','W','E','R','T','Y','U','I','O','P'},
            {'A','S','D','F','G','H','J','K','L'},
            {'Z','X','C','V','B','N','M'}};
	public String[] findWords(String[] words) {
		List<String> res = new ArrayList<String>();
		if (words == null || words.length == 0) return new String[0];

		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < ch[i].length; j++) {
				map.put(ch[i][j],i);
			}
		}

		for(String w : words) {
			String W = w.toUpperCase();
			int row = -1;
			boolean flag = true;
			for(int i = 0; i < W.length(); i++) {
				int curr = map.get(W.charAt(i));
				if (row == -1) {
					row = curr;
					continue;
				}
				if (row != curr) {
					flag = false;
					break;
				}
			}
			
		}

		String[] ress = new String[res.size()];
		for(int i = 0; i < res.size(); i++) {
			ress[i] = res.get(i);
		}
		return ress;
	}
	
	public static void main(String[] args) {
		String[] words = {"Hello","Alaska","Dad","Peace"};
		String[] res = new KeyboardRow().findWords(words);
	}

}
