package leetCode.medium;
/*Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.*/

import java.math.BigInteger;

public class Task043MultiplyStrings {


    public static void main(String[] args) {

        String number = "12123123123";
        String number1 = "12123";
        System.out.println(multiply(number, number1));

        System.out.println(new BigInteger(number).multiply(new BigInteger(number1)));

        /*
        123
        123

        369
       246
      123

        */

        /*
        123
        246

        738
       492
      246

        */

        /*
        999
        999

       8991
       8991
       8991
     998001
        */
    }


    public static String multiply(String num1, String num2) {

        if (num1.equals("0")||num2.equals("0")){
            return "0";
        }

        int[][] dp = new int[num2.length()][num1.length() + 1];
        int carry = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            for (int j = num1.length() - 1; j >= 0; j--) {
                int num = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                dp[num2.length() - 1 - i][j + 1] = (num + carry) % 10;
                carry = (num + carry) / 10;
            }
            dp[num2.length() - 1 - i][0] = carry;
            carry = 0;
        }
        int[] resultChars = new int[num1.length() + num2.length()];
        carry = 0;
        for (int i = dp[0].length - 1; i >= 0; i--) {
            int y = 0, x = i;
            while (y < dp.length && x < dp[0].length) {
                carry += dp[y][x];
                x++;
                y++;
            }
            resultChars[dp.length - 1 + i] = carry % 10;
            carry = carry / 10;
        }
        for (int i = 1; i < dp.length; i++) {
            int y = i, x = 0;

            while (y < dp.length && x < dp[0].length) {
                carry += dp[y][x];
                x++;
                y++;
            }
            resultChars[dp.length - 1 - i] = carry % 10;
            carry = carry / 10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int resultChar : resultChars) {
            stringBuilder.append(resultChar);
        }
        while (stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }
        return stringBuilder.toString();
    }
}
