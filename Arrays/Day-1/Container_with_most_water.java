/*CONTAINER WITH MOST WATER
    Find two lines, which, together with the x-axis forms a 
    container, such that the container contains the most water.


    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
*/


public class Container_with_most_water {
    
    /*2-pointers method {start-end}
        Time: O(n);
        Space: O(1);
    */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        
        int maxArea = Integer.MIN_VALUE;
        
        while(left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            
            maxArea = Math.max(area, maxArea);
            
            if(height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        
        return maxArea;
    }
    /********************************************************************************** */
}
