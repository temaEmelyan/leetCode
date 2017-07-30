package medium;

import java.util.HashSet;
import java.util.Set;

/*Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.*/
public class Task003LongSubsWOReapeatChar {

    public static void main(String[] args) {
        int abcdefa = lengthOfLongestSubstring("abadba");

        System.out.println(abcdefa);
    }

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int posOfTail = 0, posOfHead = 0;
        char[] chars = s.toCharArray();

        Set<Character> characterSet = new HashSet<>();

        while (posOfHead < chars.length) {
            boolean wasAdded = characterSet.add(chars[posOfHead]);
            if (wasAdded) {
                posOfHead += 1;
                result = posOfHead - posOfTail > result ? posOfHead - posOfTail : result;
            } else {
                characterSet.remove(chars[posOfTail]);
                posOfTail += 1;
            }
        }
        return result;
    }
}
