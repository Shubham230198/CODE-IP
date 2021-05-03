/* MIN Stack.

    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    Implement the MinStack class:
        MinStack() initializes the stack object.
        void push(val) pushes the element val onto the stack.
        void pop() removes the element on the top of the stack.
        int top() gets the top element of the stack.
        int getMin() retrieves the minimum element in the stack.


    Input
    ["MinStack","push","push","push","getMin","pop","top","getMin"]
    [[],[-2],[0],[-3],[],[],[],[]]

    Output
    [null,null,null,null,-3,null,0,-2]

    Explanation
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin(); // return -3
    minStack.pop();
    minStack.top();    // return 0
    minStack.getMin(); // return -2
*/


//Note: there is chance that stack is meant to contain Integer.MAX_VALUE, then we have to adjust the condition, because of formula we are using.
//      simply way will be to make the stack and minVal variable, of type long.

public class minStack {
    
    /*Using a Stack and a variable.
        Time: O(1) {all functions}
        Space: O(1); {no extra space, just one original stack}
    */
    
    Stack<Integer> st;
    int minVal;

    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        minVal = Integer.MAX_VALUE;
    }
    


    public void push(int val) {
        
        if(st.isEmpty()) {
            st.push(val);
            minVal = val;
        }
        else if(minVal <= val) {
            st.push(val);
        }
        else {             //if minVal > val;
            int stVal = (2*val - minVal);
            st.push(stVal);
            
            minVal = val;
        }
    }
    


    public void pop() {
        
        if(st.isEmpty()) {
            //return -1;
        }
        else if(st.peek() >= minVal) {
            int remVal = st.pop();
            
            //return remVal;
        }
        else if(st.peek() < minVal) {
            int remVal = minVal;
            minVal = 2 * minVal - st.peek();
            
            st.pop();
            //return rem value;
        }
    }
    


    public int top() {
        
        if(st.isEmpty()) {
            return -1;
        }
        else if(st.peek() >= minVal) {
            return st.peek();
        }
        else {                    //if (st.peek() < minVal);
            int topVal = minVal;
            
            return topVal;
        }
        
    }
    
    public int getMin() {
        return minVal;
    }
}
/********************************************************************************* */