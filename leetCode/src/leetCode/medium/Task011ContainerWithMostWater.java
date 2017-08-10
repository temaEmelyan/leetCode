package leetCode.medium;

public class Task011ContainerWithMostWater {

    public static int maxAreaNaive(int[] height) {
        int biggestArea = 0;

        for (int i = 0; i < height.length; i++) {
            for (int i1 = 0; i1 < height.length; i1++) {
                if (i1 == i) {
                    continue;
                }

                int area = Math.abs(i - i1) * Math.min(height[i], height[i1]);
                biggestArea = area > biggestArea ? area : biggestArea;
            }
        }

        return biggestArea;
    }

    public static int maxArea(int[] height) {
        int biggestArea = 0;

        int left = 0, right = height.length - 1;

        while (left != right) {
            int area = (right - left) * (height[left] < height[right] ? height[left] : height[right]);
            if (area > biggestArea) {
                biggestArea = area;
            }

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return biggestArea;
    }
}
