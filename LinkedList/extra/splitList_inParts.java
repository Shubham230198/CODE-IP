/*Split LinkedList into k parts, such that max diff between size if not greater than 1.

    Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
    The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. 
    This may lead to some parts being null.

    Return a List of ListNode's representing the linked list parts that are formed.


    Input: 
    root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
    Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
    Explanation:
    The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.

*/



public class splitList_inParts {
    
    /*Using Modulo and divide operator {to find sureCount and plusCount}
        Time: O(n);
        Space: O(1);
    */
    private static int getSize(ListNode root) {
        if(root == null) {
            return 0;
        }
        
        return getSize(root.next) + 1;
    }
    
    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = getSize(root);
        
        int sureCount = size / k;
        int plusCount = size % k;
        
        ListNode[] result = new ListNode[k];
        ListNode head = root;
        
        for(int i = 0; i < result.length; i++) {
            
            //count the sureCount number of nodes from the list, {using prev-curr-count way}
            ListNode prev = null;
            ListNode curr = head;
            int count = 0;
            while(curr != null && count < sureCount) {
                prev = curr;
                curr = curr.next;
                
                count++;
            }
            
            //add the extra-node is needed
            if(plusCount > 0) {
                prev = curr;
                curr = curr.next;

                plusCount--;
            }
            
            //get the last node, {and if last node is not null, break it's link from remaining list}
            ListNode last = prev;
            if(prev != null)
                last.next = null;

            //store the list into answer[i], starting from head;
            result[i] = head;        
            //update the new-head 
            head = curr;
            
        }
        
        return result;
    }
    /************************************************************************************************************** */
}
