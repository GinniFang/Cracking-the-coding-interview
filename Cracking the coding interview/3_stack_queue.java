//implement stack
//implemented using a linked list
public clas MyStack<T>{
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data){
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop(){
        if(top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item){
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
    }
    public T = peek(){
        if(top == null) throw new EmptyStackException();
        return top.data;
    }
    public boolean isEmpty(){
        return top==null;
    }
}

//Implement a queue
//it use the operation
//add(item)
//remove()
//peek()
//isEmpty()
//A queue can be implement with linkled list
//!!!!!!The difference between implement queue and 
//stack is you !!two!! pointer needed for queue,
//one point to head and one point to tail

public class MyQueue<T>(){
    private static class QueueNode<T>{
        private data;
        private QueueNode next;

        public QueueNode(T data){
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    punlic void add(T item){
        QueueNode<T> t = new QueueNode<T>(item);
        if(last!=null){
            last.next = t;//avoid it be the first node
        }
        last = t;
        if(first==null){
            first = last;
        }
    }

    public T remove(){
        if(first == null) throw new NoSuchElementException();
        T data = first.data;
        fist = first.next;
        if(first == null){
            last = null;
            //make sure the linkedlist be consistent
            //if there are no first data, then there should
            //not have last.
        }
        return data;
    }

    public T peek(){
        if(first == null) throw new NoSuchElementException;
        return first.data;
    }

    public boolean isEmpty(){
        return first==null;
    }

}