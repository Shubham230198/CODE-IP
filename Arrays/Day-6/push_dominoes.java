/*Push Dominoes.

    There are N dominoes in a line, and we place each domino vertically upright.

    In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
    When a vertical domino has dominoes falling on it from both sides, it stays still due to the 
    balance of the forces.

    Input: ".L.R...LR..L.."
    Output: "LL.RR.LLRRLL.."
*/

public class push_dominoes {
    
    /*
        Time: O(n + n + n + n);  {creating_dummy + creating_ans_in_StringBuilder + converting_string + return_subString}
        Space: (n);
    */
    public static String pushDominoes(String dominoes) {
        //add dummy "L" and "R", at starting and ending.
        dominoes = 'L' + dominoes + 'R';
        StringBuilder str = new StringBuilder();
        
        int ptr1 = 0;
        int ptr2 = 1;
        while(ptr2 < dominoes.length()) {

            //No need to check for "ptr1" to not be a '.'  ----> It is always "L" Or "R".
            // while(dominoes.charAt(ptr1) == '.') {
            //     ptr1++;
            // }
            
            //make the "ptr2" to next "L" Or "R".
            while(dominoes.charAt(ptr2) == '.') {
                ptr2++;
            }
            
            char ch1 = dominoes.charAt(ptr1);
            char ch2 = dominoes.charAt(ptr2);
    
            //append the first character only.
            str.append(ch1);
            
            if(ch1 == 'L') {
                if(ch2 == 'L') {    //when "ch1 = L" && "ch2 = L"
                    for(int i = 1; i <= (ptr2 - ptr1 - 1); i++) {
                        str.append('L');
                    }
                }
                else {              //when "ch1 = L" && "ch2 = R"
                    for(int i = 1; i <= (ptr2 - ptr1 - 1); i++) {
                        str.append('.');
                    }
                }
            }
            else {
                if(ch2 == 'L') {    //when "ch1 = R" && "ch2 = L"
                    for(int i = 1; i <= (ptr2 - ptr1 - 1)/2; i++) {
                        str.append('R');
                    }
                    
                    //if the dots between "ptr1" and "ptr2" are odd in count  ---> the mid dot will remain dot.
                    if((ptr2 - ptr1 - 1) % 2 != 0) {   
                        str.append('.');
                    }
                    
                    for(int i = 1; i <= (ptr2 - ptr1 - 1)/2; i++) {
                        str.append('L');
                    }
                }
                else {              //when "ch1 = R" && "ch2 = R"
                    for(int i = 1; i <= (ptr2 - ptr1 - 1); i++) {
                        str.append('R');
                    }
                }
            }
            
            // str.append(ch2);     //{Not need to append the "ptr2" character into "str", As it will be acting like next "ptr1"}
                   
            //set "ptr1" to "ptr2"; And "ptr2" to "ptr2 + 1";
            ptr1 = ptr2;
            ptr2 = ptr2 + 1;
        }
        
        String result = str.toString();
        
        return result.substring(1);
    }
    /****************************************************************************************************************************************** */


    
    
    
}
