package leet;

import java.util.Arrays;
import java.util.Comparator;

public class Min {
    public static int minimizeLoss(int[] prices, int n) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (prices[i] > prices[j]) {
                    min = Math.min(min, prices[i]-prices[j]);
                }

            }
        }
        return min;
    }
    public static void main(String[] args) {
        int n=3;
        int[] price = {5, 10, 3};
        int n2 = 5;
        int[] price2 = {20,7,8,2,5};
        System.out.println(minimizeLoss(price, n));
        System.out.println(minimizeLoss(price2, n2));
    }
}
