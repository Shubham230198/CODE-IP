/*Count possible ways to construct buildings:-
    Given an input number of sections and each section has 2 plots on either sides of the road. Find all possible ways
     to construct buildings in the plots such that there is a space between any 2 buildings.
*/

public class constructBuildings {

    /*Application of fibonaci Series. {exact similar approach to count-of-binary-strings-without-one's}
        Time: O(n)
        Space: O(1)
    */
    static int countBuildings(int n) {    //firstly we will be calculating only for one side of road. {at last answer will be square}
        
        //ans for n = 1;
        int build = 1;
        int noBuild = 1;

        for(int i = 2; i <= n; i++) {
            int temp = build;
            
            build = noBuild;
            noBuild = noBuild + temp;
        }

        int oneSideAns = build + noBuild;

        return (oneSideAns * oneSideAns);
    }

    public static void main(String[] args) {
        int n = 4;

        System.out.println(countBuildings(n));
    }
}
