/**BOX STACKING- (GFG)
    You are given a set of N types of rectangular 3-D boxes, where the 
    ith box has height h, width w and length l. You task is to create a 
    stack of boxes which is as tall as possible.

    Note: 
    Base of the lower box should be strictly larger than that of the new 
    box we're going to place. This is in terms of both length and width, 
    not just in terms of area. So, two boxes with same base cannot be placed one over the other.
*/

import java.util.*;
class Geeks 
{
    static class cube implements Comparable<cube> {
        int h;
        int w;
        int l;
        
        cube(int a, int b, int c) {
            h = a;
            w = b;
            l = c;
        }
        
        public int compareTo(cube other) {      //sorting on the basis of length side of cubes.
            if(this.l < other.l) {
                return -1;
            }
            else if(this.l > other.l) {
                return 1;
            }
            else {          //if length is similar, sort reverse on width (as if length is same, we can't stack those two boxes over each other)
                if(this.w < other.w) {
                    return 1;
                }            
                else {
                    return -1;
                }
            }
        }
    }
        
    
    /* LIS BASED {Trying out all 6 faces of cube}

        Time: O((6n).log(6n) + (6n)^2) => for sorting and LIS respectively.
        Space: O(6n)
    */
    public static int maxHeight_1(int height[], int width[], int length[], int n) {
       
        cube[] arr = new cube[n * 6];
        int j = 0;
        for(int i = 0; i < n; i++) {   //using all the six faces, as per probability.
            
            arr[j++] = new cube(height[i], width[i], length[i]);
            arr[j++] = new cube(height[i], length[i], width[i]);
        
            arr[j++] = new cube(width[i], height[i], length[i]);
            arr[j++] = new cube(width[i], length[i], height[i]);
        
            arr[j++] = new cube(length[i], width[i], height[i]);
            arr[j++] = new cube(length[i], height[i], width[i]);
        
        }
        
        Arrays.sort(arr);
        
        int[] lis = new int[arr.length];
        lis[0] = arr[0].h;
        for(int i = 1; i < arr.length; i++) {    //applying LCS on width & storing max height possible till i'th index.
            int idx = i - 1;
            int val = 0;
            
            while(idx >= 0) {
                if(arr[idx].w < arr[i].w) {
                    val = Math.max(val, lis[idx]);
                }
                
                idx--;
            }
            
            lis[i] = val + arr[i].h;
        }
        
        int ans = 0;
        for(int x: lis) {
            ans = Math.max(x, ans);
        }
        
        return ans;
   }

   /******************************************************************************** */



   /*LIS BASED {trying only 3 face, with proper evaluation}
        Time: O((3n).log(3n) + (3n)^2) => for sorting and LIS respectively.
        
        Space: O(3n)
    */
    public static int maxHeight_2(int height[], int width[], int length[], int n) {
       
        cube[] arr = new cube[n * 3];
        int j = 0;
        for(int i = 0; i < n; i++) {   //using only tree faces of a cube, such that "w" is >= "l". 
                                        //(only one face of any two oposite faces in a cube, with above condition)).
            
            if(width[i] > length[i]) {
                arr[j++] = new cube(height[i], width[i], length[i]);
            }
            else {
                arr[j++] = new cube(height[i], length[i], width[i]);
            }
        
            if(height[i] > length[i]) {
                arr[j++] = new cube(width[i], height[i], length[i]);
            }
            else {
                arr[j++] = new cube(width[i], length[i], height[i]);
            }
        
            if(width[i] > height[i]) {
                arr[j++] = new cube(length[i], width[i], height[i]);
            }
            else {
                arr[j++] = new cube(length[i], height[i], width[i]);
            }
        
        }
        
        Arrays.sort(arr);
        
        int[] lis = new int[arr.length];
        lis[0] = arr[0].h;
        for(int i = 1; i < arr.length; i++) {    //applying LCS on width & storing max height possible till i'th index.
            int idx = i - 1;
            int val = 0;
            
            while(idx >= 0) {
                if(arr[idx].w < arr[i].w) {
                    val = Math.max(val, lis[idx]);
                }
                
                idx--;
            }
            
            lis[i] = val + arr[i].h;
        }
        
        int ans = 0;
        for(int x: lis) {
            ans = Math.max(x, ans);
        }
        
        return ans;
   }

   /************************************************************************ */
}