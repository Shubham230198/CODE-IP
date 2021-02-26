/*WEIGHTED JOB SCHEDULING
    Given N jobs where every job is represented by following three elements of it.
    Start Time, Finish Time, Profit.
    Find the maximum profit subset of jobs such that no two jobs in the subset overlap.

    Input:  
    Number of Jobs n = 4
    Job Details {Start Time, Finish Time, Profit}
    Job 1: {1, 2, 50}
    Job 2: {3, 5, 20}
    Job 3: {6, 19, 100}
    Job 4: {2, 100, 200}

    Output:  
    Job 1: {1, 2, 50}
    Job 4: {2, 100, 200}
*/


import java.util.*;

class WJS {

    static class job implements Comparable<job> {
        int start;
        int finish;
        int profit;

        job(int s, int f, int p) {
            start = s;
            finish = f;
            profit = p;
        }

        public int compareTo(job o) {    //sorting on the basis of end time
            if(this.finish < o.finish) {
                return -1;
            } 
            else {
                return 1;
            }
        }
    }

    /*WEIGHTED JOBS MAX PROFIT, USING INCLUDE AND EXCLUDE    
        Time: O(n.log(n));
        Space: O(n);
    */

    static int searchBinary(job[] arr, int idx) {
        int low = 0; int high = idx - 1;
        int l = -1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(arr[mid].finish <= arr[idx].start) {
                low = mid + 1;
                l = mid;
            }
            else {
                high = mid - 1;
            }
        }
        return l;
    }

    static int weighted_job_profit_include_exclude(job[] arr) {
        Arrays.sort(arr);
        
        int[] table = new int[arr.length];
        table[0] = arr[0].profit;            //including the first job. (as excluding it won't give any profit)

        for(int i = 1; i < arr.length; i++) {
            table[i] = arr[i].profit;

            //searching for the last job which finishes just before (or equal to) the start of current job.
            int lIdx = searchBinary(arr, i);  
            if(lIdx != -1) {
                table[i] += table[lIdx];
            }

            //taking max of including and excluding.
            table[i] = Math.max(table[i], table[i - 1]);   
        }

        return table[table.length - 1];
    }

    /************************************************************* */


    /* Using LIS Approach.
        Time: O(n^2)
        Space: O(n)
    */
    static ArrayList<job> weighted_jobs_seq_LIS(job[] arr) {
        Arrays.sort(arr);

        int[] lis = new int[arr.length];
        lis[0] = arr[0].profit;

        ArrayList<ArrayList<job>> jobList = new ArrayList<>();
        jobList.add(new ArrayList<>());
        jobList.get(0).add(arr[0]);

        for(int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int val = 0;
            int idx = 0;

            while(j >= 0) {
                if((arr[j].finish <= arr[i].start) && (lis[j] > val)) {
                    val = lis[j];
                    idx = j;
                }

                j--;
            }

            lis[i] = val + arr[i].profit;
            ArrayList<job> jList = new ArrayList<job>(jobList.get(idx));
            jList.add(arr[i]);

            jobList.add(jList);
        }

        int ans = 0;
        int idx = 0;
        for(int i = 0; i < lis.length; i++) {
            if(ans < lis[i]) {
                ans = lis[i];
                idx = i;
            }
        }
        System.out.println("The max profit can be : " + ans);


        return jobList.get(idx);
    }

    /***************************************************************************** */

    public static void main(String[] args) {
        // job[] arr = {
        //     new job(3, 10, 20),
        //     new job(1, 2, 50),
        //     new job(6, 19, 100),
        //     new job(2, 100, 200)
        // };

        job[] arr = {
            new job(0, 1, 10),
            new job(2, 10, 1000),
            new job(8, 12, 50),
            new job(14, 17, 100)
        };

        System.out.println(weighted_job_profit_include_exclude(arr));


        // ArrayList<job> ans = weighted_jobs_seq_LIS(arr);
        
        // for(job x: ans) {
        //     System.out.println(x.start + " - " + x.finish + " - " + x.profit);
        // }


    }    
}
