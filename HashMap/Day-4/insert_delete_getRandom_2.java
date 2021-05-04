/*
    Design a data structure that supports all following operations in average O(1) time.

    Note: Duplicate elements are allowed.
    insert(val): Inserts an item val to the collection.
    remove(val): Removes an item val from the collection if present.
    getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
*/


//Note: the order of operations over hashmap-hashset, is very important.
//Note: We have used the concept of mySize, instead of arr.size() of array.[for better run time over leetcode]

class RandomizedCollection {
    HashMap<Integer, HashSet<Integer>> map;
    ArrayList<Integer> arr;
    int mySize = 0;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        arr = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            //add this into arr, and hashset of hashmap
            arr.add(val);
            mySize++;

            map.get(val).add(mySize - 1);

            return false;
        }
        else {
            //add this into arr, and new hashset into hashmap
            arr.add(val);
            mySize++;

            HashSet<Integer> set = new HashSet<>();
            set.add(mySize - 1);
            
            map.put(val, set);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        
        if(map.containsKey(val) == false || map.get(val).size() == 0) {
            return false;
        }
        else {
            int v_idx = map.get(val).iterator().next();
            int l_idx = mySize - 1;

            //swap the positions
            int temp = arr.get(l_idx);
            arr.set(l_idx, arr.get(v_idx));
            arr.set(v_idx, temp);

            //remove the occurence of val_element from map-set
            map.get(val).remove(v_idx);

            //add the new occurence of last_element(currently as temp) in map-setremove the occurence of last_element from map-set
            map.get(temp).add(v_idx);
            map.get(temp).remove(l_idx);



            //trim the arr
            arr.remove(l_idx);
            mySize--;

            return true;
        }
        
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        if(mySize == 0) {
            return 0;
        }
        
        int random_idx = (int)(Math.random()* mySize);
        
        return arr.get(random_idx);
    }
}