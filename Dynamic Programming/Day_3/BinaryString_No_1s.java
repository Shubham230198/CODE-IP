import java.util.*;
public class BinaryString_No_1s {
    long countStrings(int n) {
        //for one length string
        long endAt1 = 1;   
        long endAt0 = 1;
        
        for(int i = 1; i < n; i++) {
            long temp = endAt1;

            //now 1's will be equal to previous 0s. 
            endAt1 = endAt0;
            //now 0's will be eual to sum of previous 0s and previous 1s.
            endAt0 = endAt0 % (1000000007) + temp % (1000000007);
        }
        
        return (endAt0 + endAt1) % (1000000007);
    }
}
