/*Equal 0, 1 and 2:-
    Given a string which consists of only 0, 1 or 2s, 
    count the number of substring which have equal number of 0s, 1s and 2s.

    Examples:
        Input  :  str = “0102010”
        Output :  2
        Explanation : Substring str[2, 4] = “102” and 
                    substring str[4, 6] = “201” has 
                    equal number of 0, 1 and 2

        Input : str = "102100211"
        Output : 5
*/

import java.util.*;

class GFG {

    //1. Using key as a String (Not recommended by subesh bhaiya)
    public static int count_equal_012_String(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        
        int count_0 = 0;
        int count_1 = 0;
        int count_2 = 0;
        map.put(((count_0 - count_1) + "#" + (count_0 - count_1)), 1);
        
        int subStringCount = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0') {
                count_0++;
            }
            else if(str.charAt(i) == '1') {
                count_1++;
            }
            else {
                count_2++;
            }
            
            // System.out.println(i + "-> " + map);        
            
            String s = (count_0 - count_1) + "#" + (count_0 - count_2);

            //if map already contains "s" then update the subString count, and increment its occurence into the map.
            if(map.containsKey(s)) {
                subStringCount += map.get(s);

                map.put(s, map.get(s) + 1);
            }
            else {                         //if map doesn't contains "s", then simply insert it into map with occurence of 1.
                map.put(s, 1);
            }
        }
        
        return subStringCount;
    }
    
    


    //2. Using key as Pair of elements;

    public static class Pair {
        int zero_minus_one = 0;
        int zero_minus_two = 0;

        Pair(int zmo, int zmt) {
            this.zero_minus_one = zmo;
            this.zero_minus_two = zmt;
        }

        public boolean isEqual(Pair other) {
            return (this.zero_minus_one == other.zero_minus_one) && (this.zero_minus_two == other.zero_minus_two);
        }
    } 

    public static int count_equal_012_Pair(String str) {
        HashMap<Pair, Integer> map = new HashMap<>();

        int count_0 = 0;
        int count_1 = 0;
        int count_2 = 0;
        map.put(new Pair(count_0 - count_1, count_0 - count_2), 1);
        
        int subStringCount = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0') {
                count_0++;
            }
            else if(str.charAt(i) == '1') {
                count_1++;
            }
            else {
                count_2++;
            }

            Pair p = new Pair(count_0 - count_1, count_0 - count_2);
            if(map.containsKey(p)) {
                subStringCount += map.get(p);

                map.put(p, map.get(p) + 1);
            }
            else {
                map.put(p, 1);
            }
        }

        return subStringCount;
    }
    
    
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int t = scn.nextInt();
		
		while(t-- != 0) {
    		String str = scn.next();
    		
    		int answer = getCountOfSubstringWithEqual_0_1_2(str);
    		System.out.println(answer);
		}
		
	}
}