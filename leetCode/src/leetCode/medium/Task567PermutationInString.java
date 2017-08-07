package leetCode.medium;

import java.util.Arrays;

public class Task567PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("jopa", "fsdgfsthbahb"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int[] numberOfCharacters = new int[26];

        for (char c : chars1) {
            numberOfCharacters[c - 'a']++;
        }

        for (int i = 0; i < chars2.length; i++) {
            int[] tempNumberOfCharacters = Arrays.copyOf(numberOfCharacters, numberOfCharacters.length);

            int j = 0;

            while (i + j < chars2.length) {
                if (tempNumberOfCharacters[chars2[i + j] - 'a'] > 0) {
                    tempNumberOfCharacters[chars2[i + j] - 'a']--;

                    j++;
                    if (j == chars1.length) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }

        return false;
    }
}
