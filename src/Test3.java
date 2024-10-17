import java.util.HashMap;
import java.util.Map;

public class Test3 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,4,6,9,11,13,17};
        int[] arr2 = new int[]{7,9,13,17,18,21,22};
        int[] arr3 = new int[]{9,1,3,-1,5,3,6,7};
        int k = 3;

        System.out.println(medianSorted(arr1,arr2));
        String s = "aaaaddddaaasddssssss";
        int max = Integer.MIN_VALUE;
        int count = 1;
        for (int i = 1; i < s.length(); i++)    {
            if (s.charAt(i) != s.charAt(i-1)) {
                max = Math.max(max, count);
                count = 1;
            } else {
                count++;
            }
        }
        max = Math.max(max, count);
        System.out.println(max);
        printPascalTriangle(5);
        minimumSlidingWindow(arr3, k);
        System.out.println(fractionValue(1,3));
    }

    private static void minimumSlidingWindow(int[] arr3, int k) {
        int min = Integer.MAX_VALUE;
        int[] outputArray = new int[arr3.length-k+1];


        for (int i = 0; i <= arr3.length-k; i++) {
            for (int j = i; j < k+i; j++) {
                min = Math.min(arr3[j],min);
            }
            outputArray[i] = min;
            min = Integer.MAX_VALUE;

        }
        for (int f: outputArray) {
            System.out.print(f+ " ");
        }
    }

    private static void printPascalTriangle(int value) {
        for (int i = 1; i <=value; i++) {
            for (int j = 0; j < value-i; j++) {
                System.out.print(" ");
            }

            int c = 1;
            for (int k = 1; k <= i; k++) {
                System.out.print(c+" ");
                c = c * (i-k) / k;
            }
            System.out.println(" ");
        }
    }

    private static double medianSorted(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        if (n1 > n2) {
            return medianSorted(arr2, arr1);
        }

        int median = (n1+n2+1)/2;

        int low = 0;
        int high = arr1.length;



        while (low <= high) {
            int lMid = (low+high)/2;
            int rMid = median-lMid;


            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if (lMid < n1) {
                r1 = arr1[lMid];
            }
            if (rMid < n2) {
                r2 = arr2[rMid];
            }
            if (lMid-1 < n1) {
                l1 = arr1[lMid-1];
            }
            if (rMid-1 < n2) {
                l2 = arr2[rMid-1];
            }

            if (l1<=r2 && l2 <=r1) {
                if ((n1+n2) % 2 == 1) {
                    return Math.max(l1,l2);
                } else {
                    return ((double) Math.max(l1,l2) + Math.max(r1,r2)) / 2.0;
                }
            } else if (l1 > r2){
                high = lMid -1 ;
            } else {
                low = lMid +1;
            }

        }
        return 0;

    }

    private static String fractionValue(int num, int den) {
        StringBuilder result = new StringBuilder();

        if (num == 0)
            return "0";
        if (den == 0)
            return "";

        if (num <0 || den <0) {
            result.append("-");
        }

        num = Math.abs(num);

        den = Math.abs(den);

        int quo = num / den;
        int rem = num % den;

        result.append(quo);
        result.append(".");
        if (rem == 0)
            return result.toString();

        rem = rem*10;
        Map<Integer, Integer> map = new HashMap<>();
        while (rem != 0) {
            if (map.containsKey(rem)) {
                int index = map.get(rem);
                String part1 = result.substring(0,index);
                String part2 = "("+result.substring(index,result.length())+")";
                return part1+part2;
            } else {
                map.put(rem,result.length());
                quo = rem / den;
                result.append(quo);

                rem = (rem % den) *10;
            }
        }
        return result.toString();



    }

}
