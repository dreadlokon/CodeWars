/*
Task
Count the number of Duplicates

Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric
 digits that occur more than once in the input string. The input string can be assumed to contain only
 alphabets (both uppercase and lowercase) and numeric digits.
Example

"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice

 */


import java.util.ArrayList;

public class CountingDuplicates {
    public static void main(String[] args) {
        System.out.println(duplicateCount("aabbcde"));
    }
    public static int duplicateCount(String text) {
        text = text.toLowerCase()+" ";
        int count = 0;
        ArrayList<Character> chars = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            String[] split = text.split(String.valueOf(text.charAt(i)));
            if ((split.length > 2) && !chars.contains(text.charAt(i))) {
                count++;
                chars.add(text.charAt(i));
            }
        }
        return count;
    }
}