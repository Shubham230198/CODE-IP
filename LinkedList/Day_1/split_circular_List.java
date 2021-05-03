/*Split a Circular LinkedList into two halves.

    Given a Cirular Linked List of size N, split it into two halves circular lists. If there are odd number of nodes in the given 
    circular linked list then out of the resulting two halved lists, first list should have one node more than the second list. 
    The resultant lists should also be circular lists and not linear lists.

    Input:
    Circular LinkedList: 2->6->1->5
    Output:
    2 6
    1 5


    Input:
    Circular LinkedList: 1->5->7
    Output:
    1 5
    7
*/




public class split_circular_List {
    
    /*By Finding mid {leftOne}
        Time: O(n);
        Space: O(1);
    */
    void splitList(circular_LinkedList list) {                  //deals with single-length-list by making this single-node as, both circular-lists. 
        if(list.head == null) {
            return;
        }
        
        //finding the mid-node, 
        Node fast = list.head;
        Node slow = list.head;
        
        while(fast.next != list.head && fast.next.next != list.head) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //break the list in 2 parts; {by setting head1 and head2}
        list.head1 = list.head;
        list.head2 = slow.next;
        
        
        //complete cycle of firstList.
        slow.next = list.head1;
        
        //complete cycle of secondList.
        Node ptr = list.head2;
        while(ptr.next != list.head) {
            ptr = ptr.next;
        }
        ptr.next = list.head2;
           
	}
    /************************************************************************************* */
}
