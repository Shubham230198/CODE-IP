/* Largest Rectangle in Histogram

    Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, 
    return the area of the largest rectangle in the histogram.

    Input: heights = [2,1,5,6,2,3]
    Output: 10
    Explanation: The above is a histogram where width of each bar is 1.
    The largest rectangle is shown in the red area, which has an area = 10 units.
*/

public class largestRectangleArea_histogram {

    /*Stack Based. {Two traversals, 1.Left-to-right. & 2.Right-to-left}
        Time: O(n);
        Space: O(2*n);
    */
    public static int[] getNextSmallOnRight(int[] rowArea) {
        int[] results = new int[rowArea.length];
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < rowArea.length; i++) {
            
            while(!st.isEmpty() && rowArea[st.peek()] > rowArea[i]) {
                results[st.pop()] = i;
            }
            
            st.push(i);
        }
        
        while(!st.isEmpty()) {
            results[st.pop()] = rowArea.length;
        }
        
        return results;
    }
    
    
    public static int[] getNextSmallOnLeft(int[] rowArea) {
        int[] results = new int[rowArea.length];
        
        Stack<Integer> st = new Stack<>();
        for(int i = rowArea.length - 1; i >= 0; i--) {
            
            while(!st.isEmpty() && rowArea[st.peek()] > rowArea[i]) {
                results[st.pop()] = i;
            }
            
            st.push(i);
        }
        
        while(!st.isEmpty()) {
            results[st.pop()] = -1;
        }
        
        return results;
    }
    
    public int largestRectangleArea_1(int[] heights) {
        int[] nextSmallOnRight = getNextSmallOnRight(heights);
        int[] nextSmallOnLeft = getNextSmallOnLeft(heights);
        
        int area = 0;
        for(int i = 0; i < heights.length; i++) {
            area = Math.max(area, (nextSmallOnRight[i] - nextSmallOnLeft[i] - 1)*heights[i]);
        }
        
        return area;
    }
    /**************************************************************************************************************** */
    







    /*Single traversal Only.
        Time: O(n);
        Space: O(n);
    */
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        
        //the traversal moves till heights.length, {every element is being processed when we encounter next smaller element}.
        for(int i = 0; i <= heights.length; i++) {
            int val = (i == heights.length ? -1 : heights[i]);      //if (i==heights.length), set value as -1; so that every element in the height array got processed with it {if any remaining}.
            
            while(!st.isEmpty() && heights[st.peek()] > val) {
                int nowHeight = heights[st.pop()];
                
                int rightLimit = i;
                int leftLimit = st.isEmpty() == true ? -1 : st.peek();
                
                int nowArea = nowHeight * (rightLimit - leftLimit - 1);
                maxArea = Math.max(maxArea, nowArea);
            }
            
            st.push(i);
        }
        
        return maxArea;
    }
    /***************************************************************************************** */
}
