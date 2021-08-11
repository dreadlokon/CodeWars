/*
Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.

Notes:

    Only lower case letters will be used (a-z). No punctuation or digits will be included.
    Performance needs to be considered

Input strings s1 and s2 are null terminated.

Examples

scramble('rkqodlw', 'world') ==> True
scramble('cedewaraaossoqqyt', 'codewars') ==> True
scramble('katas', 'steak') ==> False


 */

public class Scramblies {
    public static void main(String[] args) {
        System.out.println(scramble("scriptingjava","javascript"));
    }

    public static boolean scramble(String str1, String str2) {
        if (str1.equals(str2)) return true;
        String[] strings = str2.split("");
        for (String s:strings){
            if (!str1.contains(s)) return false;
            str1 = str1.replaceFirst(s,"");
        }
        return true;
    }
}
