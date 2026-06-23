class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // If grid is empty or starting cell is blocked, no paths exist
        if (obstacleGrid == null || obstacleGrid[0][0] == 1) {
            return 0;
        }
        
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        
        // 1D DP array to optimize space complexity to O(N)
        int[] dp = new int[cols];
        dp[0] = 1; // Base case: 1 way to stand at the start
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (obstacleGrid[r][c] == 1) {
                    dp[c] = 0; // Obstacle blocks all incoming paths
                } else if (c > 0) {
                    dp[c] += dp[c - 1]; // Paths from top (dp[c]) + paths from left (dp[c-1])
                }
            }
        }
        
        return dp[cols - 1];
    }
}
