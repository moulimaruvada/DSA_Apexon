import java.util.Arrays;

public class EqualSidesOfArray {
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,3,2,1};
        int result = -1;

        for (int i = 0; i < arr.length; i++) {
            int[] a1 = new int[i];
            int[] a2 = new int[arr.length-i-1];

            System.arraycopy(arr,0,a1,0,i);
            System.arraycopy(arr,i+1,a2,0,arr.length-i-1);

            if (arraySum(a1) == arraySum(a2)) {
                result = i;
            }

        }
        System.out.println(result);
    }

    public static int arraySum(int [] a) {
        return Arrays.stream(a).sum();
    }

    public static int equalSides(int[] arr, int size) {
        int right_sum = 0, left_sum = 0;
        int i = -1, j = -1;

        for( i = 0, j = size-1 ; i < j ; i++, j-- ){
            left_sum += arr[i];
            right_sum += arr[j];

            // Keep moving i towards center until
            // left_sum is found lesser than right_sum
            while(left_sum < right_sum && i < j){
                i++;
                left_sum += arr[i];
            }
            // Keep moving j towards center until
            // right_sum is found lesser than left_sum
            while(right_sum < left_sum && i < j){
                j--;
                right_sum += arr[j];
            }
        }
        if(left_sum == right_sum && i == j)
            return arr[i];
        else
            return -1;
    }
}
