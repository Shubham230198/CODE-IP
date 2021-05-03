/*Calculate the count of Car Fleets.

    N cars are going to the same destination along a one lane road.  The destination is target miles away.
        1.Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the target along the road.
        2.A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.
        3.The distance between these two cars is ignored - they are assumed to have the same position.
        4.A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a single car is also a car fleet.
        5.If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.


    How many car fleets will arrive at the destination?

    Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
    Output: 3
    Explanation:
    The cars starting at 10 and 8 become a fleet, meeting each other at 12.
    The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
    The cars starting at 5 and 3 become a fleet, meeting each other at 6.
    Note that no other cars meet these fleets before the destination, so the answer is 3.

*/


public class car_Fleet {
    

    /*Sort Car (on basis of position), and calculate the reaching-time {double-type} for everyCar (moving last to start)
              --->if (thisTime > lastFleetTime), increment the fleetCount and update new lastFleetTime;  
              --->else this car will be part of last fleet, (do nothing).

        Time: O(nlog(n) + n); {sorting + single-traversal}
        Space: O(n); {store the Car objects in an Array}
    */
    private class Car implements Comparable<Car> {
        int myPosition;
        int mySpeed;
        
        Car(int p, int s) {
            this.myPosition = p;
            this.mySpeed = s;
        }
        
        public int compareTo(Car other) {
            return this.myPosition - other.myPosition;
        }
    } 
    
    //main function.
    public int carFleet(int target, int[] position, int[] speed) {
        
        //make a car array, fill it, and sort it on position basis.
        Car[] carArr = new Car[position.length];
        
        for(int i = 0; i < carArr.length; i++) {
            carArr[i] = new Car(position[i], speed[i]);
        }
        
        Arrays.sort(carArr);
        
        
        
        //count the totalFleet, by using reaching time of every fleet.
        int fleetCount = 0;          
        double fleetTime = -1;             //dummy initialization.  {important to keep it double}
        
        for(int i = carArr.length - 1; i >= 0; i--) {

            //highly important to keep nowTime double.   {as it could come in fractions too.}
            double nowTime = ((target - carArr[i].myPosition) *1.00) / carArr[i].mySpeed;
            
            if(nowTime > fleetTime) {       //if this car reaches later than last fleet, it will act as different fleet.
                fleetCount++;
                fleetTime = nowTime;
            }
            else {
                //do nothing as this car will be part of last fleet;
            }
        }
     
        
        //return the fleetCount;
        return fleetCount;
    }
    /**************************************************************************************************************************** */
}
