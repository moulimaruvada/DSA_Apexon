package leet;

public class MaxPointsFromCards {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(getMaxPointsFromCards(arr, k));
    }

    private static int getMaxPointsFromCards(int[] C, int K) {
        int total = 0;
        for (int i = 0; i < K; i++) total += C[i];
        int best = total;
        for (int i = K - 1, j = C.length - 1; i >= 0; i--, j--) {
            total += C[j] - C[i];
            best = Math.max(best, total);
        }
        return best;
    }
}
