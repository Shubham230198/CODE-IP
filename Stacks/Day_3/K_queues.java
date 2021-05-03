import java.util.*;

public class K_queues {

    int[] arr;
    int[] next;
    int[] front;
    int[] rear;
    int freeIdx;

    int size;
    int cap;

    K_queues(int capacity, int qCount) {
        this.cap = capacity;
        this.size = 0;

        arr = new int[capacity];

        next = new int[capacity];
        for(int i = 0; i < next.length; i++) {
            next[i] = i+1;
        }

        front = new int[qCount];
        Arrays.fill(front, -1);

        rear = new int[qCount];
        Arrays.fill(rear, -1);

        this.freeIdx = 0;
    }



    //push function
    public void add(int qIdx, int val) {
        if(freeIdx == cap) {
            System.out.println("queue space is full");
            return;
        }

        arr[freeIdx] = val;
        int addIdx = freeIdx;

        //update the paramenters accordingly
        if(front[qIdx] == -1) {
            freeIdx = next[addIdx];

            front[qIdx] = addIdx;
            rear[qIdx] = addIdx;
        }
        else {
            freeIdx = next[addIdx];

            next[rear[qIdx]] = addIdx;
            rear[qIdx] = addIdx;
        }

        //{important as arr[addIdx] is filled, but next[addIdx] is of no use untill we get another element, so we have to set it -1.(to prevent errors)}
        next[addIdx] = -1;            
    }



    //poll function
    public int poll(int qIdx) {
        if(front[qIdx] == -1) {
            System.out.println("This Queue is already empty");
            return -1;
        }

        int remIdx = front[qIdx];
        int rem = arr[remIdx];

        if(front[qIdx] == rear[qIdx]) {
            rear[qIdx] = front[qIdx] = -1;
            next[remIdx] = freeIdx;
            freeIdx = remIdx;
        }
        else {
            front[qIdx] = next[remIdx];
            next[remIdx] = freeIdx;
            freeIdx = remIdx;
        }

        return rem;
    }


    //peek() function
    public int peek(int qIdx) {
        if(front[qIdx] == -1) {
            System.out.println("This queue is empty");
            return -1;
        }
        
        int remIdx = front[qIdx];
        int rem = arr[remIdx];

        return rem;
    }





    public static void main(String[] args)
    {
        // Let us create 3 queue in an array of size 10
        int k = 3, n = 10;
        K_queues ks=  new K_queues(n, k);
        
         
        // Let us put some items in queue number 2
        ks.add(2, 15);
        ks.add(2, 45);
       
        // Let us put some items in queue number 1
        ks.add(1, 17);
        ks.add(1, 49);
        ks.add(1, 39);
       
        // Let us put some items in queue number 0
        ks.add(0, 11);
        ks.add(0, 9);
        ks.add(0, 7);
         
        System.out.println("Dequeued element from queue 2 is " +
                                ks.poll(2));
        System.out.println("Dequeued element from queue 1 is " +
                                ks.poll(1));
        System.out.println("Dequeued element from queue 0 is " +
                                ks.poll(0) );
       
    }
}
