import java.util.Arrays;

class Solution { 
    public int minPathSum(int[][] grid) { // method to solve the problem 
        int m = grid.length; 
        int n = grid[0].length; 
        for (int i = 1; i < m; i++) { 
            grid[i][0] += grid[i-1][0]; 
        } 
        for (int j = 1; j < n; j++) { 
            grid[0][j] += grid[0][j-1]; 
        } 
        for (int i = 1; i < m; i++) { 
            for (int j = 1; j < n; j++) { 
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]); 
            } 
        } 
        return grid[m-1][n-1]; 
    } 

    // Public static method to test the code
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Sample 3x3 grid test case
        int[][] testGrid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        System.out.println("Input Grid:");
        for (int[] row : testGrid) {
            System.out.println(Arrays.toString(row));
        }

        // Expected minimum path sum: 1 -> 3 -> 1 -> 1 -> 1 = 7
        int result = solution.minPathSum(testGrid);
        System.out.println("\nMinimum Path Sum: " + result);
    }
}
