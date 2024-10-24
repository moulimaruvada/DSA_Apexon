public class ArrayMaxPathSum {
        // Function to find the maximum path sum in the matrix using dynamic programming
        static int getMaxPathSum(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;

            int[][] dp = new int[n][m];

            // Initializing the first row - base condition
            System.arraycopy(matrix[0], 0, dp[0], 0, m);

            // Calculate the maximum path sum for each cell in the matrix
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int up = matrix[i][j] + dp[i - 1][j];

                    int leftDiagonal = matrix[i][j];
                    if (j - 1 >= 0) {
                        leftDiagonal += dp[i - 1][j - 1];
                    } else {
                        leftDiagonal += (int) Math.pow(-10, 9);
                    }

                    int rightDiagonal = matrix[i][j];
                    if (j + 1 < m) {
                        rightDiagonal += dp[i - 1][j + 1];
                    } else {
                        rightDiagonal += (int) Math.pow(-10, 9);
                    }

                    // Store the maximum of the three paths in dp
                    dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
                }
            }

            // Find the maximum value in the last row of dp
            int maxi = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                maxi = Math.max(maxi, dp[n - 1][j]);
            }

            return maxi;
        }

        public static void main(String args[]) {
            int matrix[][] = {{1, 2, 10, 4},
                    {100, 3, 2, 1},
                    {1, 1, 20, 2},
                    {1, 2, 2, 1}};

            // Call the getMaxPathSum function and print the result
            System.out.println(getMaxPathSum(matrix));
        }
}
