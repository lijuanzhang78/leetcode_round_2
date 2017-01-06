package Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
        Stack < Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        int lastIndex = stack.peek();
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (lastIndex - stack.peek()));
        return maxarea;
    }
	
	public static void main(String[] args) {
		int[] heights = {2,1,5,6,2,3};
		int res = new LargestRectangleInHistogram().largestRectangleArea(heights);		
	}
}
