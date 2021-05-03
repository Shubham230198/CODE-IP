/*Reverse a LinkedList.

    Given the head of a singly linked list, reverse the list, and return the reversed list.
*/

public class reverseList {
    
    /*2-pointers based.
        Time: O(n);
        Space: O(1);
    */
    public ListNode reverseList_1(ListNode head) {
        
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null) {
            ListNode nextNode = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        
        return prev;
    }
    /*************************************************************************** */
}
