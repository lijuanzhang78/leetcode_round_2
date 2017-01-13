package Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
        Stack < Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
            	int curr = heights[stack.pop()] * (i - stack.peek() - 1);
                maxarea = Math.max(maxarea, curr);
            }
            stack.push(i);
        }
        int lastIndex = stack.peek();
        while (stack.peek() != -1) {
        	int curr = heights[stack.pop()] * (lastIndex - stack.peek());
            maxarea = Math.max(maxarea, curr);
        }
        return maxarea;
    }
	
	public static void main(String[] args) {
		int[] heights = {2,1,5,6,3,4};
		int res = new LargestRectangleInHistogram().largestRectangleArea(heights);		
	}
}
