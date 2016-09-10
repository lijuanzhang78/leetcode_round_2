package Passed;

public class BullsAndCows {
	public String getHint(String secret, String guess) {
        if (secret == null || secret.length() == 0 ||
            guess == null || guess.length() == 0) return new String("");
            
        int bull = 0;
        int[] c1 = new int[10];
        int[] c2 = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            char ch1 = secret.charAt(i);
            char ch2 = guess.charAt(i);
            if (ch1 == ch2) {
                bull++;
                continue;
            }
            c1[ch1-'0']++;
            c2[ch2-'0']++;
        }
        
        int cow = 0;
        for(int i = 0; i < 10; i++) {
            cow += Math.min(c1[i], c2[i]);
        }
        String res = "";
        res += bull + "A";
        res += cow + "B";
        return res;
    }
}
