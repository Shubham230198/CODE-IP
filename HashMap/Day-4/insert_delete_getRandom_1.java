/*Implement the RandomizedSet class: (no duplicate value will be present)

bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
*/



class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> arr;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        arr = new ArrayList<>();  
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        else {
            arr.add(val);
            map.put(val, arr.size() - 1);
            
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int v_idx = map.get(val);
            int l_idx = arr.size() - 1;
            
            //swap value_idx and last_idx
            int temp = arr.get(v_idx);
            arr.set(v_idx, arr.get(l_idx));
            arr.set(l_idx, temp);
            
            //update the idx of last_element (currently at v_idx) in hashmap
            map.put(arr.get(v_idx), v_idx);
            
            //remove the value_ele from arr, and hashmap too
            arr.remove(arr.size() - 1);
            map.remove(val);
            
            return true;
        }
        else {
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int random_idx = (int)(Math.random() * arr.size());
        
        return arr.get(random_idx);
    }
}


//note: instead of using arr.size() in the below function, we could have implemented using end_idx variable. It would be faster.