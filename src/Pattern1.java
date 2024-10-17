import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pattern1 {
    public static void main(String[] args) {
        //7,8,77,78,87,88,777,778,787,877.878,888
        int n = 8;
        int[] arr = new int[]{7,8};

        Arrays.sort(arr);
        List<Integer> result = new ArrayList<>();

        for (int i : arr) {
            result.add(i);
        }

        int i = 0;
        int j = 0;
        recursion(arr,result,i,j,n);
        System.out.println(result);
    }

    private static void recursion(int[] arr, List<Integer> result, int i, int j, int n) {
        if (n >0) {
            if (j == arr.length) {
                i++;
                j = 0;
            }
            String num = String.valueOf(result.get(i))+arr[j];
            result.add(Integer.parseInt(num));
            recursion(arr,result,i,j+1,--n);
        }
    }
}
