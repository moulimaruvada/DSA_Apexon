public class MaximumPathSum {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{10,10,2,0,20,4},{1,0,0,30,2,5},{0,10,4,0,2,0},{1,0,2,20,0,4}};
       // System.out.println(minPathSum(arr));
        System.out.println(findMaxPath(arr));
    }
    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        return find(grid, m - 1, n - 1, dp);
    }
    public static int find(int[][] grid, int m, int n, int[][] dp) {
        if (m == 0 && n == 0)    return grid[m][n];
        else if (m < 0 || n < 0)    return Integer.MIN_VALUE;
        else if (dp[m][n] != 0)    return dp[m][n];
        return dp[m][n] = grid[m][n] + Math.max(find(grid, m - 1, n, dp), find(grid, m, n - 1, dp));
    }

    public static int findMaxPath(int[][] mat)

    {
        int N = mat.length;
        int M = mat[0].length;
        // To find max val in first row
        int res = -1;
        for (int i = 0; i < M; i++)
            res = Math.max(res, mat[0][i]);

        for (int i = 1; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                // When all paths are possible
                if (j > 0 && j < M - 1)
                    mat[i][j] += Math.max(mat[i - 1][j],
                            Math.max(mat[i - 1][j - 1],
                                    mat[i - 1][j + 1]));

                    // When diagonal right is not possible
                else if (j > 0)
                    mat[i][j] += Math.max(mat[i - 1][j],
                            mat[i - 1][j - 1]);

                    // When diagonal left is not possible
                else if (j < M - 1)
                    mat[i][j] += Math.max(mat[i - 1][j],
                            mat[i - 1][j + 1]);
                

                // Store max path sum
                res = Math.max(mat[i][j], res);
            }
        }
        return res;
    }
}