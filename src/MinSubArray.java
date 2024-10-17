import java.util.HashMap;
import java.util.Map;

public class MinSubArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,5,1,1,2,3};
        System.out.println(minSubArray(arr1,3));


    }

    public static int minSubArray(int[] arr,int a) {
        int currentPrefixSum = 0;
        int minLength = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            currentPrefixSum +=arr[i];

            if (currentPrefixSum == a) {
                minLength = Math.min(minLength, i+1);
            }

            int prefixSum =  currentPrefixSum - a;

            if (map.containsKey(prefixSum)) {
                int foundIndex = map.get(prefixSum);
                int currentIndex = i;
                minLength = Math.min(minLength, currentIndex-foundIndex);
            }

            map.put(currentPrefixSum, i);

        }
        if (minLength == Integer.MAX_VALUE) return -1;
        return minLength;
    }


}
