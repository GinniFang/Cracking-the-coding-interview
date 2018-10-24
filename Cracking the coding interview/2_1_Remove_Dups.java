//Using set or map
//O(n)
void deleteDups(LinkedListNode n){
    Set<Integer> map = new HashSet<>();
    LinkedListNode pre = n;
    while(n!=null){
        if(map.contains(n.val)){
            pre.next = n.next;
        }
        else{
            map.put(n.val);
            pre = n;
        }
        n = n.next;
    }
}


//follow up without using temporary buffer
//double nested loop O(n^2)
void deleteDups(LinkedListNode n){
    if(n==null||n.next==null) return n;
    LinkedListNode root = n;
    LinkedListNode pre = root;
    LinkedListNode current = root.next;
    while(root!=null){
        current = root;
        while(current.next!=null){
            if(current.next.val==current.val){
                //this is efficient for skip continuous
                //duplicate like 1 -> 2 -> 1-> 1 -> 3
                //it will skip all 1 which is current
                //next next until find a new one
                current.next = current.next.next;
            }
            else{
                current = current.next;
            }
        }
        root = root.next;
    }
}