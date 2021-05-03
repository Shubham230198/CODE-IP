/*Designing a LRU Cache.
    Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

    Implement the LRUCache class:
        1. LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
        2. int get(int key) Return the value of the key if the key exists, otherwise return -1.
        3. void put(int key, int value) Update the value of the key if the key exists. Otherwise, 
           add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.


*/


public class lru_Cache {

    /*Using a Doublly linkedList and HashMap<Key, Node>
        Time: O(1) ---> All operations.
        Space: O(2*k) {linkedList and map contains "capacity" number of elements}
    */
    static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        
    }
    
    
    Node head;
    Node tail;
    HashMap<Integer, Node> lruMap;
    int capacity;
    int size;
    
    public LRUCache(int capacity) {
        this.head = this.tail = null;
        
        this.capacity = capacity;
        this.size = 0;
        
        this.lruMap = new HashMap<>();
    }



    public void addLast(Node node) {    //helper function to add "node" in last.
        if(head == null) {
            head = tail = node;
        }
        else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }

        size++;
    }
    
    public Node remove(Node node) {       //helper function to remove node "node".
        if(node == head && node == tail) {
            head = tail = null;
        }
        else if(node == head) {
            head = head.next;
            head.prev = null;
            
            node.next = null;
        }
        else if(node == tail) {
            tail = tail.prev;
            tail.next = null;
            
            node.prev = null;
        }
        else {
            Node leftNode = node.prev;
            Node rightNode = node.next;
            
            leftNode.next = rightNode;
            rightNode.prev = leftNode;

            node.prev = node.next = null;
        }
        
        size--;
        
        return node;
    }
    
    
    
    //get Function.
    public int get(int key) {
        
        //if map contains "key-node", then place it at last {most-recently-used}
        if(lruMap.containsKey(key) == true) {
            Node remNode = remove(lruMap.get(key));
            addLast(remNode);
            
            return remNode.value;
        }
        else {
            return -1;
        }
    }
    
    //put function
    public void put(int key, int value) {

        //if map contains "Key-node", then replace it at last {most-recently-used}, after updating value.
        if(lruMap.containsKey(key) == true) {
            Node remNode = remove(lruMap.get(key));
            
            remNode.value = value;
            addLast(remNode);
        }
        else {
            
            Node newNode = new Node(key, value);

            //if size is already full, remove the "head" {least-recently-used}, and add upcomming node at {most-recenty-used}
            if(size == capacity) {
                lruMap.remove(head.key);
                remove(head);
                
                addLast(newNode);
                lruMap.put(key, newNode);
            }
            else {           //is size is not full just add the coming node at "last" {most-recently-used}.
                addLast(newNode);
                lruMap.put(key, newNode);
            }
        }
    }
    /******************************************************************************* */


}


/*Based on LinkedMap.
    Time: O(1) {All operations}
    Space: O(2*k)
*/

class LRUCache_TreeMap {

    private LinkedHashMap<Integer, Integer> lruMap;
    private int capacity;
    private int size;
    
    public LRUCache(int capacity) {
        this.lruMap = new LinkedHashMap();
        this.capacity = capacity;
        this.size = 0;
    }
    
    //get function of LRU cache
    public int get(int key) {
        
        if(lruMap.containsKey(key) == true) {
            int val = lruMap.get(key);
            
            //update this key to recently used;
            lruMap.remove(key);
            lruMap.put(key, val);
            
            //return value
            return val;
        }
        else {
            return -1;
        }
    }
    
    
    //put functionality of LRU Cache.
    public void put(int key, int value) {
        
        if(lruMap.containsKey(key) == true) {
            lruMap.remove(key);
            lruMap.put(key, value);
        }
        else if(size == capacity) {
            
            Iterator<Map.Entry<Integer, Integer>> itr = lruMap.entrySet().iterator();
            Map.Entry<Integer, Integer> entry = itr.next();

            lruMap.remove(entry.getKey());
            
            lruMap.put(key, value);
        }
        else {
            lruMap.put(key, value);
            size++;
        }
    }
    
    /**************************************************************************************** */
}
