/*Generate Binary Numbers

    Given a number N. The task is to generate and print all binary numbers with decimal values from 1 to N.

    Input:
    N = 5
    Output: 
    1 10 11 100 101

*/

public class Generate_Binary_Numbers {

    /*Complete Binary Tree, (methodology using array)
        Time: O(32*n);
        Space: O(1);
    */
    static ArrayList<String> generate_1(int N) {
        ArrayList<String> result = new ArrayList<>();
        result.add("");
        result.add("1");
        
        for(int i = 2; i <= N; i++) {
            int parentIdx = i / 2;
            String parentString = result.get(parentIdx);
            
            String nowString;
            //if "i" is even ---> (then it will be left child)
            if(i % 2 == 0) {   
                nowString = parentString + "0";   
            }
            else {       //---> (else it will be right child)
                 nowString = parentString + "1";
            }
            
            // System.out.println(nowString);
            result.add(nowString);
        }
        result.remove(0);
        
        return result;
    }
    /************************************************************************** */





    /*Same above method (but with extra queue DS) 
        Time: O(32*n);
        Space: O(n)
    */
    static ArrayList<String> generate_2(int N) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        
        ArrayList<String> result = new ArrayList<>(); 
        for(int i = 1; i <= N; i++) {
            String rem = q.poll();
            
            //adding its children.
            q.add(rem + '0');
            q.add(rem + '1');
            
            //adding this element into result list.
            result.add(rem);        
        }
        
        return result;
    }

}


