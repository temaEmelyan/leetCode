package leetCode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class task064MinSumInMatrix {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1) {
            return grid[0][0];
        }
        int[][] dp = new int[m][n];
        for (int y = 0; y < dp.length; y++) {
            for (int x = 0; x < dp[y].length; x++) {

                int distanceToHere;
                if (y == 0 && x == 0) {
                    distanceToHere = 0;
                } else if (y == 0) {
                    distanceToHere = dp[y][x - 1];
                } else if (x == 0) {
                    distanceToHere = dp[y - 1][x];
                } else {
                    distanceToHere = Math.min(dp[y][x - 1], dp[y - 1][x]);
                }
                dp[y][x] = distanceToHere + grid[y][x];
            }
        }
        return dp[m - 1][n - 1];
    }


    public int minPathSum_timeLimitExceeded(int[][] grid) {
        @SuppressWarnings("Duplicates")
        int m = grid.length;
        int n = grid[0].length;

        if (m == 1 && n == 1) {
            return grid[0][0];
        }

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparing(array -> array[0]));
        queue.add(new int[]{grid[0][0], 0, 0});

        while (true) {
            int[] remove = queue.remove();
            int y = remove[1];
            int x = remove[2];
            int sum = remove[0];
            if (y == m - 1 && x == n - 1) {
                return sum;
            }
            if (y + 1 < m) {
                int bottomCell = grid[y + 1][x];
                queue.add(new int[]{sum + bottomCell, y + 1, x});
            }
            if (x + 1 < n) {
                int rightCell = grid[y][x + 1];
                queue.add(new int[]{sum + rightCell, y, x + 1});
            }
        }
    }
}
