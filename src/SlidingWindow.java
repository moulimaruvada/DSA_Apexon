public class SlidingWindow {
    public static void main(String[] args) {
        int [] array = new int[]{5,1,3,1,2,2};
        int k = 3;

        System.out.println(maximumSum(array,k));
    }

    private static int maximumSum(int[] array, int k) {
        int currentSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            currentSum += array[i];
        }

        for (int i = k; i < array.length; i++) {
            max = Math.max(currentSum,max);
            currentSum += array[i] - array[i-k];
            max = Math.max(currentSum,max);
        }

        return max;
    }
}
