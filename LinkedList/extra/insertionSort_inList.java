/*Sort the linkedList using Insertion sort

*/

public class insertionSort_inList {
    
    /*Simple helper functions (removeNode, and addAtRightPlace)
        Time: O(n^2);
        Space: O(1);
    */

    //this function will receive "node", which is surely present.
    private void removeNode(ListNode head, ListNode node) {
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != node) {
            prev = curr;
            curr = curr.next;
        }
        
        prev.next = curr.next;
        curr.next = null;
    }
    
    
    
    //this function will add the node at correct position in [head, afterTail), and also return updated head.
    private ListNode addRightPlace(ListNode head, ListNode node, ListNode afterTail) {
        
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != afterTail) {        //important condition.
            
            if(curr.val >= node.val) {
                break;
            }
            
            prev = curr;
            curr = curr.next;
        }
        
        if(prev == null) {
            node.next = head;
            return node;
        }
        else {
            node.next = prev.next;
            prev.next = node;
            
            return head;
        }
    }
    
    
    
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        //no need to sort the first element, So starting from second element directy.
        ListNode curr = head.next;
        
        while(curr != null) {
            
            ListNode tempPick = curr;    //tempPick is the element, to get it's right position in sortedArray.
            curr = curr.next;
            
            //remove the tempPick node from list,
            removeNode(head, tempPick);
            
            //then add it to the right place.
            head = addRightPlace(head, tempPick, curr);
            
        }
        
        return head;
    }
    /****************************************************************************************************************** */
}
