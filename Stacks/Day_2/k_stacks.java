/*K-Stacks into an Array;
    We will have to implement "K-stacks" into a single array.
*/


public class k_stacks {
    int[] arr;
    int[] top;
    int[] next;
    int freeIdx;

    //arr => this will be main array containing elements of stacks.
    //top => it will be containing the peek index elements for all the stacks.
    //next => if the current position is filled in arr, then it will be containing second last element for current stack.
    //        else it will e containing index of nextFree index in the array.
    //freeIdx => this will be the just nextFree Index.


    k_stacks(int arrSize, int stacksCount) {
        arr = new int[arrSize];
        freeIdx = 0;

        //Initially all the next will be containing justNext index. 
        next = new int[arrSize];
        for(int i = 0; i < next.length; i++) {
            next[i] = i + 1;
        }

        //initially all the top will be containing -1, representing all stacks are empty.
        top = new int[stacksCount];
        for(int i = 0; i < top.length; i++) {
            top[i] = -1;
        }
    }


    public void push(int val, int stackNo) {
        if(freeIdx == arr.length) {
            System.out.println("Not Possible to add, array is full");
            return;
        }

        //add the element in the array, at freeIdx
        arr[freeIdx] = val;
        int addIdx = freeIdx;

        //update the three in straight order {freeIdx -> next -> top}
        freeIdx = next[addIdx];
        next[addIdx] = top[stackNo];
        top[stackNo] = addIdx;
    }


    public int pop(int stackNo) {
        if(top[stackNo] == -1) {
            System.out.println("This stack is empty");
            return -1;
        }

        //get the val to be removed.
        int remValIdx = top[stackNo];
        int remVal = arr[remValIdx];
        
        //update in reverse order {top -> next -> freeIdx}
        top[stackNo] = next[remValIdx];
        next[remValIdx] = freeIdx;
        freeIdx = remValIdx;

        //return 
        return remVal;
    }

    public int peek(int stackNo) {
        if(top[stackNo] == -1) {
            System.out.println("This stack is already empty");
            return -1;
        }

        int peekIdx = top[stackNo];
        return arr[peekIdx];
    }
}
