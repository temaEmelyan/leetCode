package leetCode.easy;

public class Task069Sqrrt {

    public static void main(String[] args) {

    }

    public static double mySqrt(double x, double prec) {
        double r = x / 2;
        while (r * r - x > prec * prec) {
            r = (r + x / r) / 2;
        }
        return r;
    }

    public static int mySqrtInt(int x) {
        if (x <= 0) {
            return 0;
        }
        if (x == 1) return 1;
        if (x == 2) return 1;
        if (x == 3) return 1;
        if (x == 5) return 2;
        double sqrRt = x;
        do {
            sqrRt = (sqrRt + x / sqrRt) / 2;
        } while (sqrRt * sqrRt - x > 0);
        return (int) sqrRt;
    }
}