
public class LargestSmallerBSTKey {

	/***********************************************************
	 * Given a root of a Binary Search Tree (BST) and a number num, implement an
	 * efficient function findLargestSmallerKey that finds the largest key in
	 * the tree that is smaller than num. If such a number doesn�t exist, return
	 * -1. Assume that all keys in the tree are nonnegative.
	 * 
	 * Analyze the time and space complexities of your solution. *
	 ***********************************************************/
	static class Node {
		int key;
		Node left;
		Node right;
		Node parent;

		Node(int key) {
			this.key = key;
			left = null;
			right = null;
			parent = null;
		}
	}

	static class BinarySearchTree {

		Node root;

		int findLargestSmallerKey(int num) {
			if (root == null)
				return -1;
			return findHelper(root, num);

		}

		static int findHelper(Node root, int num) {
			if (root == null)
				return -1;

			if (root.key > num) { // result is in the left branch ,find the max
									// value of the left branch

				return findHelper(root.left, num);

			} else {// num > root.key result might be root or

				while (root.right != null)
					root = root.right;
				return root.key;
			}

		}

		// inserts a new node with the given number in the
		// correct place in the tree
		void insert(int key) {

			// 1) If the tree is empty, create the root
			if (this.root == null) {
				this.root = new Node(key);
				return;
			}

			// 2) Otherwise, create a node with the key
			// and traverse down the tree to find where to
			// to insert the new node
			Node currentNode = this.root;
			Node newNode = new Node(key);

			while (currentNode != null) {
				if (key < currentNode.key) {
					if (currentNode.left == null) {
						currentNode.left = newNode;
						newNode.parent = currentNode;
						break;
					} else {
						currentNode = currentNode.left;
					}
				} else {
					if (currentNode.right == null) {
						currentNode.right = newNode;
						newNode.parent = currentNode;
						break;
					} else {
						currentNode = currentNode.right;
					}
				}
			}
		}
	}

	/*********************************************
	 * Driver program to test above function *
	 *********************************************/

	public static void main(String[] args) {

		// Create a Binary Search Tree
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(20);
		bst.insert(9);
		bst.insert(25);
		bst.insert(5);
		bst.insert(12);
		bst.insert(11);
		bst.insert(14);

		System.out.println("Largest smaller number bigger than4 is " +  bst.findLargestSmallerKey(4));
		System.out.println("Largest smaller number bigger than 5 is " +  bst.findLargestSmallerKey(5));
		System.out.println("Largest smaller number bigger than 8 is " +  bst.findLargestSmallerKey(8));
		System.out.println("Largest smaller number bigger than 10 is " +  bst.findLargestSmallerKey(10));
		System.out.println("Largest smaller number bigger than 17 is " +  bst.findLargestSmallerKey(17));
		System.out.println("Largest smaller number bigger than 21 is " +  bst.findLargestSmallerKey(21));
		System.out.println("Largest smaller number bigger than 26 is " +  bst.findLargestSmallerKey(26));

	}
}