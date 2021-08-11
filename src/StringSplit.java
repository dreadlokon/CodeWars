/*
Complete the solution so that it splits the string into pairs of two characters. If the string contains an odd number
of characters then it should replace the missing second character of the final pair with an underscore ('_').

Examples:
 */

import java.util.Arrays;

public class StringSplit {

    public static String[] solution(String s) {
        if (s.length() % 2 ==1) s +="_";
        String[] sub = new String[s.length()/2];
        int j=0;
        for (int i = 0; i < s.length(); i+=2, j++) {
            sub[j] = s.substring(i,i+2);
        }
        return sub;
    }
}
