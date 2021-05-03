public class k_stacks {
    int[] arr;
    int[] next;
    int[] top;
    int free;

    k_stacks(int arrSize, int stackCount) {
        arr = new int[arrSize];
        free = 0;

        //initially all the next array contains nextIdx.
        next = new int[arrSize];
        for(int i = 0; i < next.length; i++) {
            next[i] = i + 1;
        }

        //initially all the top is -1; ---> Means not containing any element.
        top = new int[stackCount];
        for(int i = 0; i < top.length; i++) {
            top[i] = -1;
        }
    }
    
    public void add(int val, int stackNo) {
        if(freeIdx == arr.length) {
            System.out.println("error");
            return;
        }

        arr[free] = val;

        int addIdx = free;

        freeIdx = next[addIdx];
        next[addIdx] = top[stackNo];
        top[stackNo] = addidx;
    }

    public int remove(int stackNo) {
        int remIdx = top[stackNo];
        if(remIdx < 0) {
            System.out.println("Empty");
            return -1;
        }

        int ans = arr[remIdx];

        //reset the array value;
        arr[remIdx] = 0;

        //reset the top -->next ---> freeIdx;
        top[stackNo] = next[remIdx];
        next[remIdx] = free;
        freeIdx = remIdx;

        //remove the element;
        return ans;
    }

    public int peek(int stackNo) {
        int peekidx = top[stackNo];

        if(peekIdx < 0) {
            System.out.println("Stack is Empty");
            return -1;
        }
        
        return arr[peekIdx];
    }

    public static void main(String[] args) {

    }
}
