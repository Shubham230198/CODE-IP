/*Asteroids Collision problem.
    For each asteroid, the absolute value represents its size, and the sign represents its direction 
    (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

    Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. 
    If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

    Input: asteroids = [5,10,-5]
    Output: [5,10]
    Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
*/


import java.util.*;
public class asteroidCollision {
    
    /*Stack Based, {Collision Occurs only when left is positive and right is negative}
        Time: O(n);
        Space: O(1);
    */
    public int[] asteroidCollision_1(int[] asteroids) {
        
        Stack<Integer> st = new Stack<>();
        int idx = 0;
        
        //Feels special case, have to use while, instead of for. 
        while(idx < asteroids.length) {
            
            //only case of collision.
            if(!st.isEmpty() && st.peek() > 0 && asteroids[idx] < 0) {
                
                //if left is smaller than right.
                if(Math.abs(st.peek()) < Math.abs(asteroids[idx])) {
                    st.pop();
                }
                //if left and right are same
                else if(Math.abs(st.peek()) == Math.abs(asteroids[idx])) {
                    st.pop();
                    idx++;
                }
                //if left is greater than right one.
                else {
                    idx++;
                }
            }
            else {   // in all other 3-cases, just push. (as there won't be any collisions)
                st.push(asteroids[idx]);
                idx++;
            }
                               
        }
        
        
        //storing the final state; {But in reverse order}
        int[] finalState = new int[st.size()];
        idx = finalState.length - 1;
        
        while(!st.isEmpty()) {
            finalState[idx] = st.pop();
            idx--;
        }
        
        //return the final state;
        return finalState;
    }
    /************************************************************************* */




    /* Same Approach, {with different implementation}
        Time: O(n);
        Space: O(n);
    */
    public int[] asteroidCollision_2(int[] asteroids) {
        
        Stack<Integer> st = new Stack<>();
        int idx = 0;
        
        //Feels special case, have to use while, instead of for. 
        for(int i = 0; i < asteroids.length; i++) {
            
            collision : {
                while(!st.isEmpty() && st.peek() > 0 && asteroids[i] < 0) {

                    if(st.peek() < Math.abs(asteroids[i])) {
                        st.pop();
                    }
                    else if(st.peek() == Math.abs(asteroids[i])) {
                        st.pop();
                        break collision;
                    }
                    else {
                        break collision;
                    }
                }

                st.push(asteroids[i]);    
            }
                                       
        }
        
        
        //storing the final state; {But in reverse order}
        int[] finalState = new int[st.size()];
        idx = finalState.length - 1;
        
        while(!st.isEmpty()) {
            finalState[idx] = st.pop();
            idx--;
        }
        
        //return the final state;
        return finalState;
    }


    /******************************************************************************************************* */


}
