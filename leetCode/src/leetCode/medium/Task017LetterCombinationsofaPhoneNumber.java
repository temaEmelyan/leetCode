package leetCode.medium;

import java.util.*;

/*Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
 2 abc
 3 def
 4 ghi
 5 jkl
 6 mno
 7 pqrs
 8 tuv
 9 wxyz


Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.

*/
public class Task017LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        int ofsSet = 2;

        Set<String> resultSet = new HashSet<>();

        new ArrayList<>(resultSet);

        String[] numberLetters = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        int[] pointers = new int[digits.length()];
        int[] numbers = new int[digits.length()];

        for (int i = 0; i < digits.length(); i++) {
            numbers[i] = digits.charAt(i) - '0';
        }

        boolean finished = false;

        while (!finished) {
            StringBuilder s = new StringBuilder();

            for (int i = 0; i < numbers.length; i++) {
                s.append(numberLetters[numbers[i] - ofsSet].charAt(pointers[i]));
            }
            resultSet.add(s.toString());

            int i = pointers.length - 1;
            while (i >= 0) {
                if (pointers[i] + 1 == numberLetters[numbers[i] - ofsSet].length()) {
                    pointers[i] = 0;
                    i--;
                    if (i < 0) {
                        finished = true;
                    }
                } else {
                    pointers[i]++;
                    break;
                }
            }
        }
        return new ArrayList<>(resultSet);
    }
}
