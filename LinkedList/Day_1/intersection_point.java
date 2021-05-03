/*Intersection Point in Y Shaped List.

    Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.

    Input: 
    Linked List 1 = 4->1->common
    Linked List 2 = 5->6->1->common
    common = 8->4->5->NULL
    Output: 8
    Explanation: 

    4              5
    |              |
    1              6
    \             /
     8   -----  1 
     |
     4
     |
     5
     |
     NULL 
*/


public class intersection_point {

    /*Size based Approach
        Time: O(n);
        Space: O(1);
    */

    //helper function.
    static int getSize(Node head) {
        if(head == null) {
            return 0;
        }
        
        return getSize(head.next) + 1;
    }
    
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2) {
        
        //get the size of both lists.
        int size1 = getSize(head1);
        int size2 = getSize(head2);
        
        Node ptr1 = head1;
        Node ptr2 = head2;
        
        //get the pointers "ptr1" & "ptr2" at same level, {wrt to junction point}
        if(size1 > size2) {
            int delta = size1 - size2;
            
            while(delta != 0) {
                ptr1 = ptr1.next;
                delta--;
            }
        }
        else {
            int delta = size2 - size1;
            
            while(delta != 0) {
                ptr2 = ptr2.next;
                delta--;
            }
        }
        
        //move "ptr1" & "ptr2" at same speed.
        while(ptr1 != null && ptr2 != null && ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        //if no any junction point exist, return -1;
        if(ptr1 == null || ptr2 == null) {
            return -1;
        }
        
        //return junction data;
        return ptr1.data;
	}
    /************************************************************************************* */





    /*Based on Cycle detection.
        Time: O(n);
        Space: O(1);
    */

    //helper function.
    static Node getCycleJunction(Node head) {
        
        Node fast = head;
        Node slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if(slow == fast) {
                break;
            }
        }
        
        //if no such cycle exists, return null.
        if(fast.next == null || fast.next.next == null) {
            return null;
        }

        //get the junction point;
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;
    } 
    
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2) {
         
        //creating the cycle
        Node ptr = head1;
        while(ptr.next != null) {
            ptr = ptr.next;
        }
        
        ptr.next = head1;
        
        
        //get the junction point for the list-cycle;
        Node junction = getCycleJunction(head2);
        
        //make the LinkedList same as previous
        ptr.next = null;
        
     
        //if junction is not no such junction point exists.
        if(junction == null) {
            return -1;
        }
        else {
            //return junction data;
            return junction.data;
        }
	}
    /******************************************************************************************* */
}
