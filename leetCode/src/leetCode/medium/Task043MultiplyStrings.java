package leetCode.medium;
/*Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.*/

public class Task043MultiplyStrings {
    public static String multiply(String num1, String num2) {
//        999
//       *999
//        ---
//       8991
//      8991
//      -----
//     253746

        int[][] dp = new int[num2.length()][num1.length() + 1];

        int carry = 0;

        for (int i = num2.length() - 1; i > 0; i--) {
            for (int j = num1.length() - 1; j > 0; j--) {
                int num = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                dp[i][j] = (num % 10 + carry) % 10;
                carry = (num % 10 + carry) / 10;
            }
            dp[i][0] = carry;
        }


        return null;
    }
}
