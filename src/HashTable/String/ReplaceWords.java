package HashTable.String;

public class ReplaceWords {
	public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.size() == 0) return sentence;
        Set<String> set = new HashSet<>();
        for(String s : dict) set.add(s);
        
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(String word : words) {
            String prefix = "";
            for(int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0,i);
                if (set.contains(prefix)) break;    
            }
            sb.append(" "+ prefix); 
        }
        return sb.toString().substring(1);      
    }
}
