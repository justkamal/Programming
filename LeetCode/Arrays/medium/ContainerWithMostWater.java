package Arrays.medium;

/**
 * Problem link: https://leetcode.com/problems/container-with-most-water/
 * Companies: bloomberg, microsoft, amazon, google, facebook, adobe, GM sachs, Airbnb, Alibaba
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater mainObj = new ContainerWithMostWater();
        System.out.println(mainObj.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(mainObj.maxArea(new int[]{1, 1}));
    }

    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE, i = 0, j = height.length - 1;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                ++i;
            } else {
                --j;
            }
        }
        return maxArea;
    }
}
