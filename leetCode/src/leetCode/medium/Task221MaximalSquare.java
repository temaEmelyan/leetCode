package leetCode.medium;

public class Task221MaximalSquare {

    public static void main(String[] args) {
//        char[][] matrix = new char[4][5];

//        matrix[0] = "10100".toCharArray();
//        matrix[1] = "10111".toCharArray();
//        matrix[2] = "11111".toCharArray();
//        matrix[3] = "10010".toCharArray();
//
        char[][] matrix = new char[2][2];

        matrix[0] = "11".toCharArray();
        matrix[1] = "10".toCharArray();

        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix) {
        //TODO solve with dp
    }
}
