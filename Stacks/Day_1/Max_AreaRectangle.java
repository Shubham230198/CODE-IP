/*Largest Rectngular Area in 2-D array.
    Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

    Input: matrix = [
        ["1","0","1","0","0"],
        ["1","0","1","1","1"],
        ["1","1","1","1","1"],
        ["1","0","0","1","0"]
    ]
    Output: 6
    Explanation: The maximal rectangle is shown in the above picture.
*/
public class largestRectangularArea {
    
    /*Special Stack Method {single traversal, without array space}
        Time: O(n);
        Space: O(n); {Only for stack, No extra array}
    */
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        
        //creating the baseline array,
        int[] baseLine = new int[matrix[0].length];
        
        int largest_rectangle_area = 0;
        for(int i = matrix.length - 1; i >= 0; i--) {
            
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    baseLine[j]++;
                }
                else {
                    baseLine[j] = 0;
                }
            }
            
            int nowArea = histogramArea(baseLine);
            largest_rectangle_area = Math.max(largest_rectangle_area, nowArea);
        }
        
        return largest_rectangle_area;
    }
    
    //helper function to find largest rectangle area, from a histogram
    public static int histogramArea(int[] arr) {
        Stack<Integer> st = new Stack();
        
        int maxArea = 0;
        for(int i = 0; i <= arr.length; i++) {
            int val = (i == arr.length ? -1 : arr[i]);
            
            while(st.isEmpty() == false && val < arr[st.peek()]) {
                int remIdx = st.pop();
                
                //height
                int height = arr[remIdx];
                
                //width
                int rightSmallerIdx = i;
                int leftSmallerIdx = (st.isEmpty() == false ? st.peek() : -1);
                int width = rightSmallerIdx - leftSmallerIdx - 1;
                
                //update the maxArea
                maxArea = Math.max(height*width, maxArea);
            }
            
            st.push(i);
        }
        
        return maxArea;
    }
    /**************************************************************************************** */
}
