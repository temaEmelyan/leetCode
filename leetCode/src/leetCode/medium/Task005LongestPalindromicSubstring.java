package leetCode.medium;

/*Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"*/


public class Task005LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));

    }





    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int length = 1, centreOfThePalyndrome = 1, longestSoFar = 1;

        for (int posOfCentre = 1; posOfCentre < s.length() - 1; posOfCentre++) {
            while (posOfCentre - length >= 0 && posOfCentre + length < s.length()) {
                if (s.charAt(posOfCentre - length) == s.charAt(posOfCentre + length)) {
                    if (length * 2 + 1 > longestSoFar) {
                        longestSoFar = length * 2 + 1;
                        centreOfThePalyndrome = posOfCentre;
                    }
                } else {
                    break;
                }
                length++;
            }
            length = 1;
        }

        for (int posOfCentre = 1; posOfCentre <= s.length() - 1; posOfCentre++) {
            while (posOfCentre - length >= 0 && posOfCentre + length - 1 <= s.length() - 1) {
                if (s.charAt(posOfCentre - length) == s.charAt(posOfCentre + length - 1)) {
                    if (length * 2 > longestSoFar) {
                        longestSoFar = length * 2;
                        centreOfThePalyndrome = posOfCentre;
                    }
                } else {
                    break;
                }
                length++;
            }
            length = 1;
        }

        if (longestSoFar % 2 == 0) {
            return s.substring(centreOfThePalyndrome - longestSoFar / 2, centreOfThePalyndrome + longestSoFar / 2);
        } else {
            return s.substring(centreOfThePalyndrome - longestSoFar / 2, centreOfThePalyndrome + longestSoFar / 2 + 1);
        }
    }

    private static String longestPalindromeBruteForce(String s) {
        int left = 0, right = s.length() - 1;

        String result = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    String substring = s.substring(i, j + 1);
                    if (checkIfPalindromeForBruteForce(substring)) {
                        if (result.length() < substring.length()) {
                            result = substring;
                        }
                    }
                }
            }
        }
        return result;
    }

    private static boolean checkIfPalindromeForBruteForce(String s) {
        StringBuilder normal = new StringBuilder(s);
        StringBuilder reverse = new StringBuilder(s).reverse();
        if (reverse.toString().equals(normal.toString())) {
            return true;
        }
        return false;
    }
}

