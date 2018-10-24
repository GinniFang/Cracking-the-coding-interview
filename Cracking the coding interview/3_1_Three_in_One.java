//Three in One, describe how to use a single array
// to implement three stacks, when push

//Approach 1: Fixed Division
/*  we divide the array into three equal parts 
    allow grow in that limited space
*/

//!!! the point is 
//1 division
//2 have size array
//3 calculate indexOfTop
class FixedMultiStack{
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize){
        stackCapacity = stackSize;
        sizes = new int[numberOfStacks];
        values = int[numberOfStacks*stackCapacity];
    }
    public void push(int stackNum, int value) throws FullStackException{
        if(isFull(stackNum)) throw new FullStackException();
        int top = indexOfTop(stackNum);
        values[top+1] = value;
        size[stackNum]++;
    }

    public int pop(int stackNum){
        if(isEmpty(stackNum))throws new EmptyStackEception();
        int top = indexOfTop(stackNum);
        int value = values[top];
        values[top] =0;
        size[stackNum]--;
        return value;
    }

    public int peek(int stackNum){
        if(isEmpty(stackNum)) throws new EmptyStackEception();
        return values[indexOfTop(stackNum)];
        
    }

    public boolean isEmpty(int stackNum){
        return size[stackNum]==0;
    }

    public boolean ifFull(int stackNum){
        return size[stackNum]== stackCapacity;
    }

    private int indexOfTop(int stackNum){
        int offset = stackNum*stackCapacity;
        int size = size[stackNum];
        return size+offset-1;
    }
}

//Approach 2 Flexible Division:
//if one stack exceeds its initial capacity, we grow the 
//allowable capacity and shift elements as necessary
//!!!!Design array to be circular
//You would be ask to implemnt a part of it.
// StackInfo[] info;
// int[] values;
public class MultiStack{
    //hold the info needed for a stack
    private class StackInfo{
        public int start,size,capacity;
        public StackInfo(int start, int capacity){
            this.start = start;
            this.capacity = capacity;
        }
        /*check if an index on the full array is 
        within the stack boundaries. The stack can
        wrap around to the start of the array  */
        public boolean isWithinStackCapacity(int index){
            if(index<0||index>=values.length){
                return false;
            }
            /* ??? */
            int contiguousIndex = index<start?index+values.length:index;
            int end =start+capacity;
            return start<=contiguousIndex && contiguousIbdex<end;
            }

            public int lastCapacityIndex(){
                return adjustIndex(start+capacity-1);
            }
            
            public int lastElementIndex(){
                return adjustIndex(start+size-1);
            }
            public boolean isFull(){
                return size==capacity;
            }
            public boolean isEmpty{
                return size==0;
            }
        }

        private StackInfo[] info;
        private int[] values;

        public MultiStack(int numberOfStacks, int defaultSize){
            info = new StackInfo[numberOfStacks];
            //initialization
            for(int i=0;i<numberOfStacks;i++){
                //start, capacity
                info[i] = new StackInfo(defaultSize * i,defaultSize);
            }
            values= new int[numberOfStacks * defaultSize];
        }
        //!!!!!!!
        public void push(int stakNum, int value) throw FullStackException{
            if(allStacksAreFull()){
                throw new FullStackException();
            }
            StackInfo stack = info[stackNum];
            if(stack.isFull()){
                expand(stackNum);
            }
            stack.size++;
            values[stack.lastElementIndex()] = value;
        }
        //!!!!
        public int pop(int stackNum) throws Exception{
            StackInfo stack = info[stackNum];
            if(stack.isEmpty) throw new EmptyStackEception();
            int value = values[stack.lastElementIndex()];
            values[stack.lastElementIndex()] = 0;
            stack.size--;
            return value;
        }

        public int peek(int stackNum){
            StackInfo stack = info[stackNum];
            return values[stack.lastElementIndex()];
        }
        //!!!!
        private void shift(int stackNum){
            //!!!!!
            if(stack.size>=stack.capacity){
                int nextStack = (stackNum+1)%info.length;
                shift(nextStack);
                stack.capacity++;
            }
            /* shift all elemnts in stack over by one */
            int index = stack.lastCapacityIndex();
            while(stack.isWithinStackCapacity(index)){
                values[index] = values[previousIndex(index)];
                index = previousIndex(index);
            }
            /* adjust stack data */
            values[stack.start] = 0;//clear the start value
            stack.start = nextIndex(stack.start);//move start;
            stack.capacity--;//shrink capacity;
        }
        /*!!!! expand stack by shifting over other stacks */
        private void expand(int stackNum){
            shift((stackNum+1)%info.length);
            info[stackNum].capacity++;
        }

        public int numberOfElements(){
            int size = 0;
            for(StxkInfo sd :info){
                size+=sd.size;
            }
            return size;
        }

        public boolean allStacksAreFull{
            return numberOfElements() == values.length;
        }

        private int adjustIndex(int index){
            int max = values.length;
            //same as Math.floorMod() floorDiv(a, b) * b + floorMod(a, b) == a
            //make sure all the mode be positive for given
            //positive divisor -11 % 5 = 4
            return ((index%max)+max )%max;
        }

        private int nextIndex(int index){
            //get index after this index, adjust
            //for wrap around
            return adjustIndex(index+1);
        }

        private int previousindex(int index){
            return adjustIndex(index-1);
        }
}