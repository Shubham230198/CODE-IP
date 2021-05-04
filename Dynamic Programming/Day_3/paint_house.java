/*Paint Houses - 1.

    There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
    The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses 
    have the same color, and you need to cost the least. Return the minimum cost.

    Input: [[14,2,11],[11,14,5],[14,3,10]]
    Output: 10
    Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue. Minimum cost: 2 + 5 + 3 = 10.
*/


public class paint_house {
    
    /*Famous dynamic programming approach.  {Well known approach}
        Time: O(n);
        Space: O(n*3);   
    */
    
    /************************************************************************ */


    /*Three Variable based approach.  {Same above logic just implemented without space}
        Time: O(n);
        Space: (1);

    */
    public int minCost(int[][] costs) {
        
        //declare three variables
        int redCost = 0;
        int blueCost = 0;
        int greenCost = 0;

        for(int i = 0; i < costs.length; i++) {
            int oldRed = redCost;
            int oldBlue = blueCost;
            int oldGreen = greenCost;

            redCost = Math.min(oldBlue, oldGreen) + costs[i][0];
            blueCost = Math.min(oldRed, oldGreen) + costs[i][1];
            greenCost = Math.min(oldRed, oldBlue) + costs[i][2];
        }

        return Math.min(redCost, Math.min(blueCost, greenCost));
    }
    /******************************************************************************** */
}
