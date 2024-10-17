package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumbersSumZero {
    public static void main(String[] args) {
        int[] a = new int[]{-5, 2, -1, -2, 3};
        threeNumbersSumZero(a);
    }

    public static void threeNumbersSumZero(int [] array) {
        List<List<Integer>> tripletList = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length-2; i++) {
            if (i > 0 && array[i] == array[i-1]) {
                continue;
            }
            findTheList(array,tripletList, -array[i], i);
        }
        for (int i = 0; i < tripletList.size(); i++) {
            System.out.println(tripletList.get(i));
        }
    }

    private static void findTheList(int[] array, List<List<Integer>> tripletList, int targetSum, int index) {
        int left = index + 1;
        int right = array.length-1;

        while (left < right) {
            if (targetSum == (array[left] + array[right])) {
                tripletList.add(new ArrayList<>(Arrays.asList(-targetSum, left, right)));
                left++;
                right--;
                while (left < right && array[left] == array[left-1]) {
                    left++;
                }
                while (left < right && array[right] == array[right+1]) {
                    right--;
                }
            } else if ((array[left] + array[right]) < targetSum){
                left++;
            } else {
                right--;
            }
        }
    }
}
