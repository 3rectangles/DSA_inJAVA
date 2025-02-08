package DSA;

import java.util.Stack;

public class stack {

    
     public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;

        for (int i = heights.length - 1; i >= 0; i--) {
            int startIndex = i;
            // Pop until top of stack is smaller than current height
            while (!stack.isEmpty() && stack.peek()[1] >= heights[i]) {
                int[] top = stack.pop();
                int height = top[1];
                // The width is (previous index - current index - 1)
                maxArea = Math.max(maxArea, height * (top[0] - i - 1));
                startIndex = top[0];
            }
            stack.push(new int[]{startIndex, heights[i]});
        }

        // Clear remaining bars in stack
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int height = top[1];
            // The width is (top index - (-1) - 1) = top index
            maxArea = Math.max(maxArea, height * (top[0]));
        }

        return maxArea;
    }
    // [2,1,5,6,2,3]

    
}

