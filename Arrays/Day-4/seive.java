/*Seive.
    Given a number N, calculate the prime numbers up to N using Sieve of Eratosthenes.  

*/

public class seive {

    /*Using Array.
        Time: O(n.log(log(n)));
        Space: O(n);
    */
    static ArrayList<Integer> sieveOfEratosthenes(int N){
        int[] arr = new int[N + 1];
        
        for(int i = 2; i * i <= N; i++) {
            if(arr[i] == 0) {
                
                for(int j = i * i; j <= N; j += i) {
                    arr[j] = -1;
                }
            }
        }
        
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 2; i < arr.length; i++) {
            if(arr[i] == 0) {
                primes.add(i);
            }
        }
        
        return primes;
    }
    /************************************************************************* */
}
