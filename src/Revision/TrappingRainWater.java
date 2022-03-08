package Revision;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] height) {

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            leftMax[i] = Math.max(max, height[i]);
        }

        max = Integer.MIN_VALUE;

        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            rightMax[i] = Math.max(max, height[i]);
        }

        int res = 0;

        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;
    }
}
