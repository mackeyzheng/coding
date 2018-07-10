/*
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing all ones and return its area.
 */
public class Solution {
    // divide this problem into several largest_rectangle_in_histogram problems
    // O(n^2), O(n^2)
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        final int M = matrix.length;
        final int N = matrix[0].length;
        
        int[][] rectangle = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0) {
                    rectangle[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    rectangle[i][j] = matrix[i][j] == '1' ? rectangle[i-1][j] + 1 : 0;
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < M; i++) {
            maxArea = Math.max(maxArea, largestRectangle(rectangle[i]));
        }

        return maxArea; 
    }

    private int largestRectangle(int[] height) {
        if (height == null || height.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int[] copy = new int[height.length + 1];
        copy = Arrays.copyOf(height, height.length + 1); // add a 0 to the end of height
        
        int max = 0;
        int i = 0;
        while(i < copy.length) {
            if (stack.isEmpty() || copy[stack.peek()] <= copy[i]) {
                stack.push(i++);
            } else {
                int num = stack.pop();
                // i - 1 - stack.peek(): the no. of bars whose height >= height[stack.peek()]
                // when encountering height[i] (which is < num)
                max = Math.max(max, copy[num] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
            }
        }

        return max;
    }

    
    // iterate all rectangles: O(n^2 m^2)
    // Time Limit Exceed
//    public int maximalRectangle(char[][] matrix) {
//        if (matrix == null || matrix.length == 0) return 0;
//        final int M = matrix.length;
//        final int N = matrix[0].length;
//        int ret = 0;
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                ret = Math.max(ret, maxRect(matrix, i, j));
//            }
//        }
//        return ret;
//    }
//
//    // get the max rect with the upper-left point at (x, y)
//    private int maxRect(char[][] matrix, int x, int y) {
//        final int M = matrix.length;
//        final int N = matrix[0].length;
//        boolean[][] f = new boolean[M-x][N-y]; // record whether it is a rectangle with the bottom-right point at (i, j)
//        f[0][0] = matrix[x][y] == '1';
//        for (int j = 1; j < N-y; j++)
//            f[0][j] = f[0][j-1] && matrix[x][y+j] == '1';
//
//        for (int i = 1; i < M-x; i++)
//            f[i][0] = f[i-1][0] && matrix[x+i][y] == '1';
//
//        for (int i = 1; i < M-x; i++) {
//            for (int j = 1; j < N-y; j++) {
//                f[i][j] = false;
//                if (!f[i][j-1]) continue;
//                for (int k = 0; k <= i; k++) {
//                    if (matrix[x+k][y+j] != '1')
//                        break;
//                    else if (k == i)
//                        f[i][j] = true;
//                }
//            }
//        }
//
//        int max = 0;
//        for (int i = 0; i < M-x; i++) {
//            for (int j = 0; j < N-y; j++) {
//                if (!f[i][j]) continue;
//                max = Math.max(max, (i+1)*(j+1));
//            }
//        }
//
//        return max;
//    }
}
