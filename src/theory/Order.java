package theory;

public class Order {
	// Binary Tree Traveral
	// Inorder : L-Root-R
	// Preorder : Root-L-R
	// Postorder : L-R-Root
	
	/*
	 *       (1)
	 *      /   \
	 *     (2)  (3)
	 *    /  \
	 *  (4)   (5)
	 *  
	 *  Inorder ( left-root-right) : 4 2 5 1 3
	 *  Preorder ( root-left-right) : 1 2 4 5 3
	 *  Postorder ( left-right-root) : 4 5 2 3 1
	 */

	public static void main(String[] args) {
		Tree t = new Tree();
		Node n4 = t.makeNode(null, 4, null);
		Node n5 = t.makeNode(null, 5, null);
		Node n2 = t.makeNode(n4, 2, n5);
		Node n3 = t.makeNode(null, 3, null);
		Node n1 = t.makeNode(n2, 1, n3);
		
		t.setRoot(n1);
		System.out.println("inorder");
		t.inorder(t.getRoot());
		System.out.println("\npreorder");
		t.preorder(t.getRoot());
		System.out.println("\npostorder");
		t.postorder(t.getRoot());
	}
}

class Node{
	int data;
	Node left;
	Node right;
}

class Tree{
	public Node root;
	
	public void setRoot(Node node) {
		this.root = node;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public Node makeNode(Node left, int data, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		return node;
	}
	
	public void inorder(Node node) {
		if( node != null ) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}
	
	public void preorder(Node node) {
		if(node!=null) {
			System.out.print(node.data + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	public void postorder(Node node) {
		if(node!=null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data + " ");
		}
	}
}

