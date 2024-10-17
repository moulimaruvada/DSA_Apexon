package leet;

import java.util.Arrays;
import java.util.HashSet;

public class TripletSumEqualToValue {
    public static void main(String[] args) {
        int[] array = new int[]{12,3,4,9,6,1};
        int target = 24;
        System.out.println(tripletSumEqualToTarget(array, target));
        System.out.println(tripletSumEqualToTargetUsingSort(array, target));

    }

    private static boolean tripletSumEqualToTargetUsingSort(int[] array, int target) {
        Arrays.sort(array);
        for (int i = 0; i < array.length-2; i++) {

            int left = i+1;
            int right = array.length-1;

            while (left < right) {
                if (array[i]+array[left]+array[right] == target) {
                    return true;
                } else if (array[left]+array[right] > target) {
                    right --;
                } else {
                    left++;
                }
            }

        }
        return false;
    }

    private static boolean tripletSumEqualToTarget(int[] array, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i< array.length-2; i++) {

            int currentSum = target-array[i];

            for (int j = i+1; j < array.length; j++) {

                int requiredValue = currentSum-array[j];

                if (set.contains(requiredValue)) {
                    return true;
                }
                set.add(array[i]);
            }
        }
        return false;
    }
}
