import java.util.*;

public class LatestTest {
    public static void main(String[] args) {
        String s = "aaabbaac";
        int[] ar = {5,6,1,2,3,4};
        int[] ar1 = {5,8,50,4};
        runlengthencoding(s);
        minimumelementrotatedarray(ar);
        shortestsubarray(ar1, 50);
        lengthOfLongestsubstring("aabbbbCCddd");
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(sodukuValidator(board));
        int[] arr = new int[]{3,0,1,0,4,0,2};
        System.out.println(maxWater(arr, arr.length));

    }

    private static int maxWater(int[] arr, int length) {
        int size = arr.length - 1;

        int prev = arr[0];

        int prevIndex = 0;
        int water = 0;
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > prev) {
                prev = arr[i];
                temp = 0;
                prevIndex = i;
            } else {
                water += prev - arr[i];
                temp += prev - arr[i];
            }
        }

       return 1;

    }

    private static boolean sodukuValidator(char[][] board) {
        return false;
    }

    private static void lengthOfLongestsubstring(String s) {
        int count = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < s.length(); i++) {
            if (i < s.length()-1 && s.charAt(i) == s.charAt(i-1)) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        System.out.println("length of longest substring = "+max);

    }

    private static void shortestsubarray(int[] ar1, int i) {
        int currentsum = 0;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < ar1.length; j++) {
            currentsum +=ar1[j];

            if (currentsum == i) {
                min = Math.min(min, j+1);
            }

            int previousSum = currentsum-ar1[j];

            if (map.containsKey(previousSum)) {
                int foundIndex = map.get(previousSum);
                int currentIndex = j;
                min = Math.min(min, currentIndex-foundIndex);
            }

            map.put(currentsum,j);
        }
        System.out.println("shortest sub array length = "+min);
    }

    private static void minimumelementrotatedarray(int[] ar) {
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = ar.length -1;

        while (low <= high) {
            int mid = low+high/2;

            if (ar[low] == ar[mid] && ar[high] == ar[mid]) {
                min = Math.min(ar[mid],min);
                low++;
                high--;
            } else {
                if (ar[mid] > ar[high]) {
                    low = mid +1;
                } else {
                    min = Math.min(min, ar[mid]);
                    high = mid -1;
                }
            }
        }
        System.out.println("minimum element rotated array ="+min);

    }

    private static void runlengthencoding(String s) {
        StringBuilder sv = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            while (i < s.length()-1 && s.charAt(i) == s.charAt(i+1)) {
                count++;
                i++;
            }
            sv.append(s.charAt(i)).append(count);
        }
        System.out.println(sv);
    }


}