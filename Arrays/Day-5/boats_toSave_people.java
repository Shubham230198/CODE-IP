/*Minimum Number of boats to save all the people.

    You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where 
    each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum 
    of the weight of those people is at most limit.

    Return the minimum number of boats to carry every given person.

    Input: people = [3,2,2,1], limit = 3
    Output: 3
    Explanation: 3 boats (1, 2), (2) and (3)
*/


public class boats_toSave_people {    

    /*Sorting and 2-pointers based approach. {start-end}
        Time: O(n.log(n) + n);     {sorting + traversal}
        Space: O(1);
    */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        int countOfBoats = 0;
        
        while(left <= right) {
            
            if(people[left] + people[right] > limit) {
                countOfBoats++;
                right--;
            }
            else {
                countOfBoats++;
                left++;
                right--;
            }
        }
        
        return countOfBoats;
    }
    /*************************************************************************** */




    //Note: What if a boat can carry more than 2 people, allowed here.
}
