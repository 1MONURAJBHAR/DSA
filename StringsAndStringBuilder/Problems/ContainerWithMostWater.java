public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {

            int width = right - left;
            int currentArea = Math.min(height[left], height[right]) * width;

            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        // Predefined example
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = maxArea(height);

        System.out.print("Height Array: ");
        for (int h : height) {
            System.out.print(h + " ");
        }

        System.out.println();
        System.out.println("Maximum Area = " + result);
    }
}