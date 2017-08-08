package leetCode.notLeetCode;

import java.math.BigDecimal;

public class DimanAppleBananaPineapple {

    private static double func(int apple, int banana, int pineapple) {
        double one = apple * 1.0 / (banana + pineapple);
        double two = banana * 1.0 / (apple + pineapple);
        double three = pineapple * 1.0 / (banana + apple);

        return one + two + three;
    }

    private static BigDecimal funcBigDec(int apple, int banana, int pineapple) {
        BigDecimal a = new BigDecimal(apple);
        BigDecimal b = new BigDecimal(banana);
        BigDecimal c = new BigDecimal(pineapple);

        BigDecimal x = a.divide(b.add(c), 20, BigDecimal.ROUND_UP);
        BigDecimal y = b.divide(a.add(c), 20, BigDecimal.ROUND_UP);
        BigDecimal z = c.divide(b.add(a), 20, BigDecimal.ROUND_UP);

        return x.add(y).add(z);
    }

    public static void main(String[] args) {
        int lim = 10000;

        BigDecimal big = new BigDecimal(4.000000001);
        BigDecimal small = new BigDecimal(3.999999999);

        for (int i = 1; i <= lim; i++) {
            for (int j = 1; j <= lim; j++) {
                for (int k = 1; k <= lim; k++) {
                    if (funcBigDec(i, j, k).compareTo(big)<0 && funcBigDec(i, j, k).compareTo(small)>0) {
                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
    }
}
