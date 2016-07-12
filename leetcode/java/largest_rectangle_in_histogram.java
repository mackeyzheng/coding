public class Solution {
    // using a non-decreasing stack
    // O(n), O(n)
    public int largestRectangleArea(int[] height) {
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
                // when stack.isEmpty(), it means copy[num] is the smallest until now
            }
        }

        return max;
    }
}
