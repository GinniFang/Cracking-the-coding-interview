import javax.swing.tree.TreeNode;

/* Problem description
Given a sortee(Increasing order) array with unique integer elements, 
write an algorithm to create a binary tree with minimal height */

class Minimal_BST_with_Sorted_array {
    public Node createMinimalBST(int[] arr) {
        return buildTree(arr, 0, arr.length - 1);
    }

    public Node buildTree(int[] arr, int start, int end) {
        if (start > end)
            return null;
        int middle = (start + end) / 2;
        Node root = new Node(arr[middle]);
        System.out.println(root.val);
        root.left = buildTree(arr, start, middle - 1);
        root.right = buildTree(arr, middle + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Minimal_BST_with_Sorted_array ob = new Minimal_BST_with_Sorted_array();
        ob.createMinimalBST(arr);
    }
}
