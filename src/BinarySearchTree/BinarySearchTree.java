package BinarySearchTree;


public class BinarySearchTree {
	
	class Node {
		public Node(int key) {
			super();
			this.key = key;
		}
		Node left;
		Node right;
		int key;
		
	}
	private Node rootNode;
	private int size = 0;
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public BinarySearchTree(){
		rootNode = null;
	}
	public BinarySearchTree(Node root, int size){
		this.rootNode = root;
		this.size = size;
	}
	public Node getRootNode() {
		return rootNode;
	}
	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}
	
	public Node searcheKey(Node node, int value){
		if(node != null){
			if(node.key == value)
				return node;
			else if (node.key > value)
				return searcheKey(node.left, value);
			 
			return searcheKey(node.right, value);
		}
		
		return null;
	}
	public int treeMinValue(Node root){
		if(root.left != null)
			return treeMinValue(root.left);
		return root.key;
	}
	public Node treeMinNode(Node root){
		if(root.left != null)
			return treeMinNode(root.left);
		return root;
	}
	public int treeMax(Node root){
		if(root.right != null)
			return treeMax(root.right);
		return root.key;
	}
	public Node treeMaxNode(Node root){
		if(root.right != null)
			return treeMaxNode(root.right);
		return root;
	}
	public void insertValue(Node node, int value){
		if(value < node.key){
			if(node.left == null){
				node.left =new Node(value);
				this.size++;
			}else insertValue(node.left, value);
			
		}else{
			if(node.right == null ){
				node.right = new Node(value);
				this.size++;
			}else insertValue(node.right, value);
		}
	}
	public void insert(int value){
		if(this.rootNode == null ){
			this.rootNode = new Node(value);
			this.size++;
		}else insertValue(this.rootNode, value);
	}
	public Node nextLarger(Node root, int element){
		if(root != null ){
			Node node = this.searcheKey(root, element);
			if(node.right != null)
					return treeMinNode(node.right);
			return root;
		}
		return null;
	}
	public Node nextSmaller(Node root, int element){
		if(root != null){
			Node node = searcheKey(root, element);
			if(node.left != null)
				return treeMaxNode(node.left);
			return root;
		}
		return null;
	}
	public void inOrder(Node root){
		if(root != null){
			inOrder(root.left);
			System.out.println(root.key);
			inOrder(root.right);
		}
	}
	
  
    /* A recursive function to insert a new key in BST */
    public Node deleteNode(Node root, int key) 
    { 
        /* Base Case: If the tree is empty */
        if (root == null)  return root; 
  
        /* Otherwise, recur down the tree */
        if (key < root.key) 
            root.left = deleteNode(root.left, key); 
        else if (key > root.key) 
            root.right = deleteNode(root.right, key); 
  
        // if key is same as root's key, then This is the node 
        // to be deleted 
        else
        { 
            // node with only one child or no child 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
  
            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
            root.key = treeMinValue(root.right); 
  
            // Delete the inorder successor 
            root.right = deleteNode(root.right, root.key); 
        } 
  
        return root; 
    } 
	public static void main(String[] args){
		BinarySearchTree tree1 = new BinarySearchTree();
		tree1.insert(50);
		//tree1.delete(tree1.rootNode, 50);
		//tree1.inOrder(tree1.rootNode);
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50); 
		tree.insert(30);
	    tree.insert(20); 
	    tree.insert(40); 
	    tree.insert(70); 
	    tree.insert(60); 
	    tree.insert(80);
	    tree.insert(35);
	    tree.insert(90);
	    tree.insert(45);
	    
	    tree.deleteNode(tree.rootNode,30);
	    tree.inOrder(tree.rootNode);
	  /**
	     * 						50
	     * 					   /   \	
	     * 				      /     \ 
	     * 					 /       \ 
	     * 					30        70
	     * 				   /  \	      / \
	     * 				  /    \     /   \
	     * 				 /      \   /     \						
	     *              20      40  60    80 
	     *                     / \          \
	     * 			          /   \	         \
	     * 				     /     \          \	
	     *                  35     45       90
	     * 
	     * 
	     * 
	     * 
	     * 
	    tree.inOrder(tree.rootNode);
		int minimum = tree.treeMinValue(tree.rootNode);
		int maximum = tree.treeMax(tree.rootNode);
		System.out.println(tree.nextSmaller(tree.rootNode, 80).key);
		System.out.println("---> the min = " + minimum);
		System.out.println("---> the max = " + maximum);*/
	    
	}
	
}

