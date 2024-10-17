import java.util.Arrays;
import java.util.List;

public class MinSortedRotated {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,5,1,1,2,3);
        // System.out.println(findMinimum(arr));
        int[] array1 = new int[]{4,5,6,1,2,3};
        System.out.println("Minimum in rotated array "+sorted(array1));
    }

    public static int findMinimum(int[] arr) {

        int low = 0;
        int high = arr.length-1;

        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low+high)/2;
            if (arr[mid] == arr[low] && arr[mid] == arr[high]) {
                min = Math.min(arr[mid],min);
                low++;
                high--;
            }

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                min = Math.min(arr[mid],min);
                high = mid - 1;
            }
        }
        return min;
    }

    public static int sorted(int [] s) {
        int low = 0;
        int high = s.length-1;

        int min = Integer.MAX_VALUE;

        if (s[low] <= s[high]) {
            return s[low];
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (s[mid] == s[low] && s[mid] == s[high]) {
                min = Math.min(min, s[mid]);
                low++;
                high--;
            }

            if (s[mid] > s[high]) {
                low = mid + 1;
            } else {
                min = Math.min(min, s[mid]);
                high = mid - 1;
            }
        }
        return min;
    }



}
