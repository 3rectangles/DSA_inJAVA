package DSA.prefix;


/**
 * Querying sums in a 2D matrix using a prefix sum (cumulative sum) approach.
 *
 * Example problem statement:
 *   "Given a 2D matrix 'grid' and multiple queries of rectangular subregion (r1, c1) to (r2, c2),
 *    return the sum of all elements within that subregion."
 *
 * Approach (2D Prefix Sum):
 *   1) Precompute a 2D prefix sum array 'prefixSum' such that:
 *      prefixSum[i][j] = sum of all elements from (0,0) to (i,j).
 *      This can be formed by:
 *        prefixSum[i][j] = grid[i][j]
 *                        + prefixSum[i - 1][j]
 *                        + prefixSum[i][j - 1]
 *                        - prefixSum[i - 1][j - 1]
 *      (handle boundaries carefully where i-1 or j-1 might be < 0).
 *
 *   2) To answer a query (r1, c1, r2, c2), we can compute:
 *        regionSum = prefixSum[r2][c2]
 *                    - prefixSum[r1 - 1][c2]
 *                    - prefixSum[r2][c1 - 1]
 *                    + prefixSum[r1 - 1][c1 - 1]
 *      (again carefully handle if r1-1 < 0 or c1-1 < 0).
 *
 * Time Complexity:
 *   - Building the prefix sum array: O(R*C)
 *   - Answer each query in O(1) after prefix sum is built.
 *
 * Space Complexity:
 *   - O(R*C) for the prefix sum array.
 */
public class TwoDMatrixPrefixSum {
    
    private int[][] prefixSum;
    private int rows;
    private int cols;

    /**
     * Constructor: Build prefix sum for the given 2D matrix.
     * @param grid The input matrix for which we want to build prefix sums.
     */
    public TwoDMatrixPrefixSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            // Handle edge cases by storing a minimal prefixSum
            prefixSum = new int[0][0];
            rows = 0;
            cols = 0;
            return;
        }
        
        rows = grid.length;
        cols = grid[0].length;
        prefixSum = new int[rows][cols];
        
        // Build the prefix sum array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                prefixSum[i][j] = grid[i][j]
                                  + ((i > 0) ? prefixSum[i - 1][j] : 0)
                                  + ((j > 0) ? prefixSum[i][j - 1] : 0)
                                  - ((i > 0 && j > 0) ? prefixSum[i - 1][j - 1] : 0);
            }
        }
    }

    /**
     * Get the sum of elements in grid from (r1, c1) to (r2, c2).
     * (Assuming 0-based indexing.)
     * @param r1 row start
     * @param c1 col start
     * @param r2 row end
     * @param c2 col end
     * @return sum of elements in the specified submatrix
     */
    public int querySubmatrix(int r1, int c1, int r2, int c2) {
        if (rows == 0 || cols == 0) {
            return 0; // empty or invalid grid
        }
        
        // Clamp indices in case of invalid inputs
        r1 = Math.max(0, r1);
        c1 = Math.max(0, c1);
        r2 = Math.min(rows - 1, r2);
        c2 = Math.min(cols - 1, c2);
        
        int total = prefixSum[r2][c2];
        int top = (r1 > 0) ? prefixSum[r1 - 1][c2] : 0;
        int left = (c1 > 0) ? prefixSum[r2][c1 - 1] : 0;
        int corner = (r1 > 0 && c1 > 0) ? prefixSum[r1 - 1][c1 - 1] : 0;
        // Subtracting the top and left regions twice, so adding the top-left corner once
        return total - top - left + corner;
    }

    /**
     * Quick test in main().
     */
    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        TwoDMatrixPrefixSum solver = new TwoDMatrixPrefixSum(grid);
        
        // Query entire matrix: sum = 1+2+3 + 4+5+6 + 7+8+9 = 45
        System.out.println("Sum of entire 3x3: " + solver.querySubmatrix(0, 0, 2, 2)); // 45
        
        // Query submatrix top-left corner
        // (r1,c1) = (0,0), (r2,c2) = (1,1): sum = 1+2 + 4+5 = 12
        System.out.println("Sum of submatrix (0,0)-(1,1): " + solver.querySubmatrix(0,0,1,1)); // 12
        
        // Query submatrix (1,2)-(2,2): sum = 6 + 9 = 15
        System.out.println("Sum of submatrix (1,2)-(2,2): " + solver.querySubmatrix(1,2,2,2)); // 15
    }
}