package Passed;

public class IntegerToEnglishWords {
	String[] ones = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"}; 
    String[] twos = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] levels = {"Thousand", "Million", "Billion", "Trillion"};

public String numberToWords(int num) {
    ArrayList<String> arr = new ArrayList<>();
    if (num == 0) return new String("Zero");
    
    String str = String.valueOf(num);
    int level = str.length()/3;
    if (str.length()%3 != 0) level++;
    
    int end = str.length();
    for(int i = 1; i <= level; i++) {
        StringBuilder sb = new StringBuilder();
        int start = end - 3;
        if (start < 0) start = 0;
        String curr = build(str.substring(start,end));
        end = start;
        if (curr.equals("")) continue;
        sb.append(curr);
        if (i >= 2) sb.append(" "+ levels[i-2]);
        arr.add(sb.toString());
    }
    StringBuilder sbres = new StringBuilder();
    for(int i = arr.size()-1; i >= 0;i--) {
        sbres.append(arr.get(i) + " ");
    }
    return sbres.toString().trim();
}

String build(String curr) {
    Integer num = Integer.valueOf(curr);
    StringBuilder sb = new StringBuilder();
    int first = num%10;
    num = num/10;
    int second = num%10;
    num = num/10;
    int third = num%10;
    if (third==0 && second==0 && first==0) return new String("");
    
    if(third != 0) sb.append(ones[third] + " " + "Hundred" + " ");
    if (second != 0) {
        if (second*10 + first < 20) {
            sb.append(twos[second*10+first-10]+" ");
            return sb.toString().trim();
        } else {
            sb.append(tens[second]+" ");
        }
    }
    if (first != 0) {
        sb.append(ones[first]);
    }
    return sb.toString().trim();
}

}
