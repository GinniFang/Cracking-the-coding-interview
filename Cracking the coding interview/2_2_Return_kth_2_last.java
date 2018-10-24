/* Problem descripton:
implement an algorithm to find the kth to last
element of a dingly linked list*/


class LinkedListNode{
    ListNode next;
    ListNode val;
    ListNode(int val){
        this.val = val;
    }
}

//quick thought approach two pointer
class Solution{
    LinkedListNode printKthToLast(LinkedListNode head, int k){
        //first let the fast one go k steps ahead
        LinkedListNode p_f = head;
        LinkedListNode p_s = head;
        for(int i=0;i<k;i++){
            if(p_f==null) return null;//marginal check
            p_f = p_f.next;
        }
        while(p_f!=null){
            p_s = p_s.next;
            p_f = p_f.next;
        }
        return p_s;
    }
}

//answer provided by book
//only valid when we only want to print the value
//of k th element
class Solution{
    int printKthToLast(LinkedListNode head, int k){
        if(head==null){
            return 0;
        }
        int index = printKthToLast(head.next,k)+1;
        if(index==k){
            System.out.println(head.data);
        }
        return index;
    }
}

//wrapper class to wrap index and value;
class Index{
    public int value;
}
class Solution{
    LinkedListNode kthToLast(LinkedListNode head,int k){
        index idx = new Index();
        return kthToLast(head,k,idx);
    }
    LinkedListNode kthToLast(LinkedListNode head, int k, index idx){
        if(head==null){
            return 0;
        }
        LinkedListNode node = printKthToLast(head.next,k,idx);
        //pay attention to the position we add one
        //after we call printKthToLast because we 
        //want to retrieve back
        idx.value = idx.value+1;
        if(idx.value==k){
            System.out.println(head.data);
        }
        return node;
    }
}