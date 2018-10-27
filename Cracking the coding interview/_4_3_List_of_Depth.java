import java.util.LinkedList;
import java.util.Queue;

/*Problem description
 * Given a binary tree, design an algorithm which creates
 * a linked list of all the nodes at each depth*/
public class _4_3_List_of_Depth {
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
	public static void main(String args[]) {
		_4_3_List_of_Depth obj = new _4_3_List_of_Depth();
		Node root = new Node(5);
		Node head = root;
		root.left = new Node(4);
		root.right = new Node(6);
		root = root.left;
		root.left = new Node(7);
		root.right = new Node(8);
		LinkedList<LinkedList<Node>> list = obj.list_of_depth(head);
		for(int i =0;i<list.size();i++) {
			System.out.println("The "+(i+1)+"th level");
			for(int j = 0;j<list.get(i).size();j++) {
				System.out.print(list.get(i).get(j).val+" ");
			}
			System.out.println();
		}
	}
	
}
