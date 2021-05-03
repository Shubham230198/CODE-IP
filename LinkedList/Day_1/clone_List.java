/*Clone a LinkedList with random pointers.

    you are given a special linked list with N nodes where each node has a next pointer pointing to its next node. You are also given M random pointers , where you will be given M number of pairs denoting two nodes a and b  i.e. a->arb = b.

    Input:
    N = 4, M = 2
    value = {1,2,3,4}
    pairs = {{1,2},{2,4}}
    Output: 1
    Explanation: In this test case, there
        are 4 nodes in linked list.  Among these
        4 nodes,  2 nodes have arbit pointer
        set, rest two nodes have arbit pointer
        as NULL. Second line tells us the value
        of four nodes. The third line gives the
        information about arbitrary pointers.
        The first node arbit pointer is set to
        node 2.  The second node arbit pointer
        is set to node 4.
*/

public class clone_List {
    

    /*Based on Hashmap,
        Time: O(n);
        Space: O(n)

    */
    Node copyList(Node head) {
        if(head == null) {
            return head;
        }
        
        HashMap<Node, Node> nodeMap = new HashMap<>();
        
        Node newHead = new Node(head.data);
        Node ptr2 = newHead;
        Node ptr1 = head.next;
        nodeMap.put(head, newHead);
        
        while(ptr1 != null) {
            //make new data, and add it into newList.
            Node newNode = new Node(ptr1.data);
            ptr2.next = newNode;
            ptr2 = ptr2.next;
            
            //put it inside the map
            nodeMap.put(ptr1, ptr2);
            
            ptr1 = ptr1.next;
        }
        
        //set the "arb" using nodeMap.
        ptr1 = head;
        ptr2 = newHead;
        while(ptr1 != null) {
            
            //set the "abr" of coressponding ptr1, {Only if "ptr1.abr != null" else it will be null also}
            if(ptr1.arb != null)
                nodeMap.get(ptr1).arb = nodeMap.get(ptr1.arb);
            
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        return newHead;
    }
    /************************************************************************************ */




    
    /*Using same approach using dummy node.
        Time: O(n);
        Space: O(n);
    */
    Node copyList(Node head) {
        if(head == null) {
            return head;
        }
        
        HashMap<Node, Node> nodeMap = new HashMap<>();
        
        Node dummy = new Node(-1);
        Node ptr2 = dummy;
        Node ptr1 = head;
        
        while(ptr1 != null) {
            //make new data, and add it into newList.
            Node newNode = new Node(ptr1.data);
            ptr2.next = newNode;
            ptr2 = ptr2.next;
            
            //put it inside the map
            nodeMap.put(ptr1, ptr2);
            
            ptr1 = ptr1.next;
        }
        
        ptr1 = head;
        ptr2 = dummy.next;
        while(ptr1 != null) {
            
            if(ptr1.arb != null)
                nodeMap.get(ptr1).arb = nodeMap.get(ptr1.arb);
            
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        return dummy.next;
    }
    /************************************************************************************** */





    /*Using famous without space approach.
        Time: O(n);
        Space: O(1);
    */
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }
        
        //create a copy list, by inserting newnode inbetween.
        Node ptr1 = head;
        while(ptr1 != null) {
            
            Node newNode = new Node(ptr1.val);
            
            newNode.next = ptr1.next;
            ptr1.next = newNode;
            
            ptr1 = ptr1.next.next;
        }
        
        
        //setting the random-pointers
        ptr1 = head;
        while(ptr1 != null) {
            
            ptr1.next.random = (ptr1.random != null ? ptr1.random.next : null);
            
            ptr1 = ptr1.next.next;
        }
        
        
        //segratting the newList;
        Node newHead = head.next;
        Node ptr2 = newHead;
        ptr1 = head;
        
        while(ptr2.next != null) {

            ptr1.next = ptr2.next;
            ptr2.next = ptr2.next.next;
            
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            
        }
        ptr1.next = null;      //{very important to remove the next of lastnode of original list}
        
        
        //return head of newList.
        return newHead;
        
    }
    /********************************************************************************************************** */








    /*

    */
}
