/*MaxFreq Stack.

    Implement the FreqStack class:

    O(1): FreqStack() constructs an empty frequency stack.
    O(1): void push(int val) pushes an integer val onto the top of the stack.
    O(1): int pop() removes and returns the most frequent element in the stack.

    If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
*/

import java.util.*;
public class maxFreq_Stack {
    
    HashMap<Integer, Stack<Integer>> stackMap;
    HashMap<Integer, Integer> freqMap;
    int maxFreq;
    
    public FreqStack() {
        stackMap = new HashMap<>();
        freqMap = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        
        //put it in highestFreqMap
        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        
        
        int newFreq = freqMap.get(val);
        if(newFreq > maxFreq) {
            //update the maxFreq
            maxFreq = newFreq;

            //create a new Stack with val, and insert it with newFreq.
            Stack<Integer> st = new Stack<>();
            st.push(val);
            stackMap.put(maxFreq, st);            
            
        }
        else {
            stackMap.get(newFreq).push(val);
        }
    }
    
    public int pop() {
        if(maxFreq == 0) {
            return -1;
        }
        
        //get the remVal from the maxFreq Stack, {and update the stackMap accordingly}
        int remVal = stackMap.get(maxFreq).pop();
        
        if(stackMap.get(maxFreq).size() == 0) {
            stackMap.remove(maxFreq);
            maxFreq--;
        }
        
        //update the remVal occurrence from the freqMap, {& remove the remVal if occurence becomes zero} 
        freqMap.put(remVal, freqMap.get(remVal) - 1);
        
        if(freqMap.get(remVal) == 0) {
            freqMap.remove(remVal);
        }
        
        return remVal;
    }
}
