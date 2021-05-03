/*Multiply Strings

    Given two non-negative integers num1 and num2 represented as strings, return the product 
    of num1 and num2, also represented as a string.

    Input: num1 = "123", num2 = "456"
    Output: "56088"
*/

public class multiply_strings {
    
    /*Simple multiplication Approach   {No actual carry values work, during mutilpication}

        Time: O(num1.length * num2length);
        Space: O(num1.length + num2.length);
    */

    public String multiply(String num1, String num2) {
        //as final size of product can at max of length --> len-of-first-num + len-of-second-num
        int[] arr = new int[num1.length() + num2.length()];
        
        for(int i = num1.length() - 1; i >= 0; i--) {
            int val1 = num1.charAt(i) - '0';
            
            for(int j = num2.length() - 1; j >= 0; j--) {
                int val2 = num2.charAt(j) - '0';
                
                //just multiply 2 numbers and put its affect at (i + j + 1) index. {don't need to deal}
                arr[i + j + 1] += (val1 * val2);
            }
        }
        
        //do the carrying thing over the whole array, to create actual product value.
        int carry = 0;
        for(int i = arr.length - 1; i >= 0; i--) {
            arr[i] += carry;
            
            carry = arr[i] / 10;
            arr[i] = arr[i] % 10;
        }
        
        //convert array into a String {representing a number}.
        StringBuilder str = new StringBuilder();
        boolean isEmpty = true;
        for(int i = 0; i < arr.length; i++) {
            
            if(arr[i] == 0 && isEmpty == true) {
                continue;
            }

            str.append(arr[i]);
            isEmpty = false;
        }
        
        if(str.length() == 0) {
            return "0";
        }
        else {
            return str.toString();            
        }
    }
}
