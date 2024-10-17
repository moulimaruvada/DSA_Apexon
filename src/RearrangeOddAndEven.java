import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RearrangeOddAndEven {
    public static void main(String[] args) {
        {

            List<Integer> nums = new ArrayList<>();
            nums.add(20);
            nums.add(12);
            nums.add(23);
            nums.add(17);
            nums.add(7);
            nums.add(8);
            nums.add(10);
            nums.add(2);
            nums.add(1);
            nums.add(10);




            // Initialize left and right pointers.
            int left_side = 0, right_side = nums.size() - 1;

            // Continue until the left pointer is less than the right pointer.
            while (left_side < right_side)
            {
                // Move the left pointer to the right until it points to an odd number.
                while (nums.get(left_side) % 2 == 0 && left_side < right_side)
                    left_side++;

                // Move the right pointer to the left until it points to an even number.
                while (nums.get(right_side) % 2 == 1 && left_side < right_side)
                    right_side--;

                // If the left pointer is still less than the right pointer, swap the elements.
                if (left_side < right_side)
                {
                    Collections.swap(nums,left_side,right_side);
                    left_side++;
                    right_side--;
                }
            }

            // Return the modified array.
            System.out.println(nums);
        }


    }
//    public static int[] find(int[] arr) {
//        int[] intA = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] % 2 ==0) {
//                intA[i] = arr[i];
//            }
//        }
//    }
}
