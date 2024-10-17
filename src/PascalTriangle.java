public class PascalTriangle {
    public static void main(String[] args) {
        int n = 5;
        printPascalTriangle(n);
    }

    private static void printPascalTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int u = 0; u <= n-i; u++) {
                System.out.print(" ");
            }

            int c = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(c+ " ");
                c = c * (i - j) / j;
            }
            System.out.println(" ");
        }
    }
}
