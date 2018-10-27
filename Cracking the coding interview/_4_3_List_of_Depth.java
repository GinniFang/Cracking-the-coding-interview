import java.util.LinkedList;
import java.util.Queue;

/*Problem description
 * Given a binary tree, design an algorithm which creates
 * a linked list of all the nodes at each depth*/
public class _4_3_List_of_Depth {
	/*Using Two queues
	 * one to store the parent level
	 * one to store the child level*/
	public LinkedList list_of_depth(Node root) {
		LinkedList<LinkedList<Node>> res = new LinkedList<>();
		Queue<Node> level_q = new LinkedList<>();
		Queue<Node> tree_q = new LinkedList<>();
		if(root==null) return res;
		tree_q.add(root);
		while(!tree_q.isEmpty()||!level_q.isEmpty()) {
			LinkedList<Node> list = new LinkedList<>();
			while(!tree_q.isEmpty()) {
				Node node = tree_q.poll();
				list.add(node);
				level_q.add(node);
			}
			res.add(list);
			while(!level_q.isEmpty()) {
				Node node = level_q.poll();
				if(node.left!=null) tree_q.add(node.left);
				if(node.right!=null) tree_q.add(node.right);
			}
		}
		return res;
	}
	/* Improved version, only use one queue
	 * To make sure we add the child level in
	 * but poll out all the parent level, we should
	 * first record the parent level's size
	 * so that we know when we should stop
	 * polling*/
	public LinkedList list_of_depth_improved(Node root) {
		LinkedList<LinkedList<Node>> res = new LinkedList<>();
		Queue<Node> tree_q = new LinkedList<>();
		if(root==null) return res;
		tree_q.add(root);
		while(!tree_q.isEmpty()) {
			LinkedList<Node> list = new LinkedList<>();
			int size = tree_q.size();
			for(int i=0;i<size;i++){
				Node node = tree_q.poll();
				list.add(node);
				if(node.left!=null) tree_q.add(node.left);
				if(node.right!=null) tree_q.add(node.right);
			}
			res.add(list);
		}
		return res;
		
	}
	/* Recursive version, each time we pass in Level+1 to
	 * the next recursive call. DFS*/
	public void list_of_depth_recurse(Node root,LinkedList<LinkedList<Node>> lists, int level) {
		if(root==null) return;
		LinkedList<Node> list = null;
		if(lists.size()==level) {//level is not contained in list
			list = new LinkedList<Node>();
			lists.add(list);
		}else {
			list = lists.get(level);
		}
		list.add(root);
		list_of_depth_recurse(root.left,lists,level+1);
		list_of_depth_recurse(root.right,lists,level+1);
		
	}
	
	
	public static void main(String args[]) {
		_4_3_List_of_Depth obj = new _4_3_List_of_Depth();
		Node root = new Node(5);
		Node head = root;
		root.left = new Node(4);
		root.right = new Node(6);
		root = root.left;
		root.left = new Node(7);
		root.right = new Node(8);
		LinkedList<LinkedList<Node>> list = new LinkedList<>();
		//LinkedList<LinkedList<Node>> list = obj.list_of_depth_improved(head);
		obj.list_of_depth_recurse(head,list,0);
		for(int i =0;i<list.size();i++) {
			System.out.println("The "+(i+1)+"th level");
			for(int j = 0;j<list.get(i).size();j++) {
				System.out.print(list.get(i).get(j).val+" ");
			}
			System.out.println();
		}
	}
	
}
