/*Count of Distinct Subsequences (Non Empty).
    1. You are given a string.
    2. You have to print the count of distinct and non-empty subsequences of the given string. 

    Example:-
    str: abcb
    count: 13
*/

import java.util.*;
public class Count_D_subSeq {

    /*USING DP with Last_Occurence_idx MAP.
        Time: O(n);
        Space: O(n);
    */
    public static long countDSubseq(String str) {
        long[] countD = new long[str.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if(i == 0) {
                countD[i] = 2;
            }
            else {
                countD[i] = 2 * countD[i - 1];
            }
            
            
            if(map.containsKey(ch)) {
                int l_occur = map.get(ch);
                
                if(l_occur == 0) {  //only empty subsequence will make the repetition here.
                    countD[i] -= 1;
                }
                else {
                    countD[i] -= countD[l_occur - 1];
                }
            }
            
            map.put(ch, i);
        }
        
        //before returning the ans, subtract 1. {for empty subsequence}
        return (countD[str.length() - 1] - 1);
    }
    
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        //write your code here
        System.out.println(countDSubseq(str));
        scn.close();
    }
}
