public class segmentedSeive {
    
    //simple sieve, to get primes till "limit"
    static ArrayList<Integer> getPrimes(int limit) {

        int[] visited = new int[limit + 1];
        
        for(int i = 2; i * i <= limit; i++) {
            if(visited[i] == 0) {

                for(int j = i * i; j <= limit; j += i) {
                    visited[j] = -1;
                }
            }
        }

        ArrayList<Intege> primes = new ArrayList<>();
        for(int i = 2; i <= limit; i++) {
            if(visited[i] == 0) {
                primes.add(i);
            }
        }

        return primes;
    } 





    static void segmentedSieve(int n) {

        //difining a limit, (such that this size array can be created)
        int limit = Math.ceil(Math.sqrt(n) + 1);

        //get list of primes till "limit"             (as (n <= 10^10, so limit <= 10^5) and an array till limit could be made)
        ArrayList<Integer> primes = getPrimes(limit);


        //define range for first segment.
        int low = limit;
        int high = 2*limit;

        //utilising segmented seive.
        while(low < n) {

            if(high >= n) {        //if high goes beyond "n", keep it to n only.
                high = n;
            }


            //applying segmented seive, using primesList.
            int visited[] = new int[limit + 1];

            //making every fact of primes.get(i), in range.
            for(int i = 0; i < primes.size(); i++) {
                int p = primes.get(i);

                int firstMultiple = (low/p * p);  //finding the firstMultiple of primes.get(i), in the range.
                if(firstMultiple < low) {
                    firstMultiple += p;
                }

                for(int j = firstMultiple; j < high; j += p) {
                    if(j == p) continue;      //if the first multiple is same to prime, don't do anything

                    visited[j - low] = -1;
                }
            }

            //collect the numbers which are primes, into the primesList (Not including high as it will be included in next low-high cycle)
            for(int i = low; i < high; i++) {
                if(visited[i - low] == 0) {
                    if(i == 1) continue;

                    primes.add(i);
                }
            }


            //update the new low and high
            low = low + limit;
            high = high + limit;
        }


        return primes;
    }
}
