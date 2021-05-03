public class detectCycle {
    
    /*Only to detect have any cycle.?
        Time: O(n);
        Space: O(1);
    */
    public static boolean detectLoop(Node head){
        Node fast = head;
        Node slow = head;
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow) {
                return true;
            }
        }
        
        return false;
    }
    /***************************************************************************************** */






    /*When we have to find the actual junction node in cycle. {Proof is very important}
        Time: O(n);
        Space: O(1);
    */
    public static Node getLoopJunction(Node head){
        Node fast = head;
        Node slow = head;
        
        boolean flag = false;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow) {
                flag = true;
            }
        }
        
        //if flag is false, then no cycle is present.
        if(flag == false) {
            System.out.println("No Cycle");
            return null;
        }
        else {   //else cycle is present, we have to find the junction node.
            
            slow = head;
            while(fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            
            //return slow {currently pointing to junction node}
            return slow;
        }
        
    }
    /************************************************************************************************* */

}
