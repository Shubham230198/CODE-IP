/*Mid Element of LinkedList.

    Given a singly linked list of N nodes. The task is to find the middle of the linked list. 
    For example, if given linked list is 1->2->3->4->5 then the output should be 3.

    Input:
    LinkedList: 2->4->6->7->5->1
    Output: 7 
    Explanation: 
    Middle of linked list is 7.
*/

public class mid_Of_list {
    
    /*Slow & Fast pointer based.
        Time: O(n);
        Space: O(1);
    */

    int getMiddle(Node head) {
        if(head == null) {
            return head.data;
        }
        
         Node fast = head;
         Node slow = head;
        
        //right now, we will have second element in case of even nodes. {for first node, just "(fast.next != null && fast.next.next != null)" }
         while(fast != null && fast.next != null) {
             fast = fast.next.next;
             slow = slow.next;
         }
         
         return slow.data;
    }
    /********************************************************************* */
}
