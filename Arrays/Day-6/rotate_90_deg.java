/*Rotate Image by 90 Degree

    You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
    
*/

public class rotate_90_deg {
    
    /*First transpose then swap colums.

        Time: O(n^2);
        Space: O(1);
    */
    public void rotate(int[][] matrix) {
        //transpose
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //swapping the cols.
        for(int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[0].length - 1;
            
            while(left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                
                left++;
                right--;
            }
        }

    }

    /******************************************************************** */
}
