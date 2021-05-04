/*Count Total Rabbits in Forest

    In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them) tell you how many other rabbits have the same color 
    as them. Those answers are placed in an array.

    Return the minimum number of rabbits that could be in the forest.


    Input: answers = [1, 1, 2]
    Output: 5
    Explanation:
    The two rabbits that answered "1" could both be the same color, say red.
    The rabbit than answered "2" can't be red or the answers would be inconsistent.
    Say the rabbit that answered "2" was blue.
    Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
    The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.

*/



public class rabbit_count {
    
    /*Using a HashMap, to store the "occ" (how many more will come) of particular said value.

        Way: --->if "said" is not present in the map, increse count by "said + 1", and add "said, said" in map.
             --->if "said" is present, decrease "occ" by one.
             --->if any said Occ is zero, remove it from map.

        Time: O(n);
        Space: O(n);

    */
    public int numRabbits(int[] answers) {
        
        //making a freqMap, making us know how many "x" saying elements can still come.
        HashMap<Integer, Integer> map = new HashMap<>();
        int countOfRabbits = 0;
        
        for(int i = 0; i < answers.length; i++) {
            int ans = answers[i];
            
            //if we already have "ans" spoken in map(non-zero), then just decrease the count from the map.
            if(map.containsKey(ans) == true) {   
                map.put(ans, map.get(ans) - 1);
            }
            else {                            //else this color rabbit is first, add its (said + 1), and make the map know "said" will more come.
                countOfRabbits += (ans + 1);
                map.put(ans, ans);
            }
            
            
            //if any "said" value has occurence as zero, remove that.
            if(map.get(ans) == 0) {
                map.remove(ans);
            }
        }
        
        
        return countOfRabbits;
    }
    /***************************************************************************************************** */
}
