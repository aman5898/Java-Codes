package lecture_16;

import java.util.LinkedList;
import java.util.Scanner;

public class bst {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	Node root;
	int size;

	private class diapair {
		int height;
		int diameter;
		boolean isvalid = true;
	}

	private class bstpair {
		boolean isbst;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
	}

	public bst(int[] sa) {
		root = construct(sa, 0, sa.length - 1);
	}
	private class Heapmover
	{
		int sum;
	}
	
	public void printbw(int lo,int hi)
	{
		printbw(root,lo,hi);
	}
	
	private void printbw(Node node,int lo,int hi)
	{
		if(node==null)
		{
			return;
		}
		if(node.data<lo)
		{
			printbw(node.right, lo,hi);
		}else if(node.data>hi)
		{
			printbw(node.left,lo,hi);
		}else
		{
			System.out.print(node.data+" ,");
			printbw(node.left, lo, hi);
			printbw(node.right,lo,hi);
		}
	}
	
	public void replacebysum()
	{
		Heapmover mover=new Heapmover();
		mover.sum=0;
		replacebysum(root,mover);
	}
	
	private void replacebysum(Node node,Heapmover mover)
	{
		if(node==null)
		{
			return ;
		}
		replacebysum(node.right, mover);
		int temp=node.data;
		node.data=mover.sum;
		mover.sum+=temp;
		replacebysum(node.left, mover);
	}

	private Node construct(int[] sa, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		Node temp = new Node();
		this.size++;
		temp.data = sa[mid];
		temp.left = construct(sa, lo, mid - 1);
		temp.right = construct(sa, mid + 1, hi);
		return temp;
	}

	public void removeelem(int data) {
		removeelm(data, root, null, false);
	}

	private void removeelm(int data, Node node, Node parent, boolean ilc) {
		if (node.data == data) {
			if (node.left == null && node.right == null) {
				this.size--;
				if (ilc == true) {
					parent.left = null;
				} else if (ilc == false) {
					parent.right = null;
				}
			} else if (node.left == null && node.right != null) {
				this.size--;
				if (ilc == true) {
					parent.left = node.right;
				} else if (ilc == false) {
					parent.right = node.right;
				}
			} else if (node.right == null && node.left != null) {
				this.size--;
				if (ilc == true) {
					parent.left = node.left;
				} else if (ilc == false) {
					parent.right = node.left;
				}
			} else {

				this.size--;
				int lmax = max(node.left);
				node.data = lmax;
				removeelm(lmax, node.left, node, true);
			}

		} else if (node.data > data) {
			removeelm(data, node.left, node, true);
		} else if (node.data < data) {
			removeelm(data, node.right, node, false);
		}
	}

	public void remove(int data) {
		remove(root, data);
	}

	private void remove(Node node, int data) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			if (data == node.left.data) {
				this.size--;
				node.left = null;
			}
		}
		if (node.right != null) {
			if (data == node.right.data) {
				this.size--;
				node.right = null;
			}
		}

		remove(node.left, data);
		remove(node.right, data);
	}

	private Node getnode(int data, Node node) {
		if (node == null) {
			return null;
		}
		if (node.data == data) {
			return node;
		} else if (node.data < data) {
			return getnode(data, node.right);
		} else {
			return getnode(data, node.left);
		}
	}

	public bst(int[] post, int[] in) {
		root = construct(post, in, 0, post.length - 1, 0, in.length - 1);
	}

	private Node construct(int[] post, int[] in, int poi, int poe, int ini, int ine) {
		if (poi > poe || ini > ine) {
			return null;
		}
		Node node = new Node();
		node.data = post[poe];
		this.size++;
		int idx = -1;
		for (int i = ini; i <= ine; i++) {
			if (in[i] == node.data) {
				idx = i;
				break;
			}
		}

		int clse = idx - ini;

		node.left = construct(post, in, poi, poi + clse - 1, ini, idx - 1);
		node.right = construct(post, in, poi + clse, poe - 1, idx + 1, ine);
		return node;
	}

	public void addelement(int data) {
		if (size == 0) {
			root = new Node();
			root.data = data;
			size++;
		} else {
			addelement(root, data);
		}
	}

	private void addelement(Node node, int data) {

		if (data > node.data) {
			if (node.right == null) {
				node.right = new Node();
				this.size++;
				node.right.data = data;
				return;
			}
			addelement(node.right, data);
		} else if (data < node.data) {
			if (node.left == null) {
				node.left = new Node();
				this.size++;
				node.left.data = data;
				return;
			}
			addelement(node.left, data);
		} else {
			System.out.println("Element already exist Can't be added");
			return;
		}
	}

	private class TraversalPair {
		Node node;
		boolean selfdone;
		boolean leftdone;
		boolean rightdone;
	}

	public void preorderI() {
		LinkedList<TraversalPair> stack = new LinkedList<>();
		TraversalPair rp = new TraversalPair();
		rp.node = root;

		stack.addFirst(rp);
		while (stack.size() != 0) {
			TraversalPair curr = new TraversalPair();
			curr = stack.getFirst();
			if (curr.selfdone == false) {
				System.out.print(curr.node.data + " ");
				curr.selfdone = true;

			} else if (curr.leftdone == false) {

				if (curr.node.left != null) {
					TraversalPair left = new TraversalPair();
					left.node = curr.node.left;
					stack.addFirst(left);
				}
				curr.leftdone = true;

			} else if (curr.rightdone == false) {
				// System.out.println();
				if (curr.node.right != null) {
					TraversalPair right = new TraversalPair();
					right.node = curr.node.right;
					stack.addFirst(right);
				}
				curr.rightdone = true;

			} else {
				stack.removeFirst();
			}
		}
	}

	public void postorderI() {
		LinkedList<TraversalPair> stack = new LinkedList<>();
		TraversalPair rp = new TraversalPair();
		rp.node = root;

		stack.addFirst(rp);
		while (stack.size() != 0) {
			TraversalPair curr = new TraversalPair();
			curr = stack.getFirst();
			if (curr.leftdone == false) {

				if (curr.node.left != null) {
					TraversalPair left = new TraversalPair();
					left.node = curr.node.left;
					stack.addFirst(left);
				}
				curr.leftdone = true;

			} else if (curr.rightdone == false) {
				// System.out.println();
				if (curr.node.right != null) {
					TraversalPair right = new TraversalPair();
					right.node = curr.node.right;
					stack.addFirst(right);
				}

				curr.rightdone = true;

			} else if (curr.selfdone == false) {
				System.out.print(curr.node.data + " ");
				curr.selfdone = true;

			} else {
				stack.removeFirst();
			}
		}
	}

	public void levelorder() {
		LinkedList<Node> ll = new LinkedList<>();
		ll.addFirst(root);
		while (ll.size() != 0) {
			Node curr = ll.removeFirst();
			System.out.println(curr.data);
			if (curr.left != null) {
				ll.addLast(curr.left);
			}
			if (curr.right != null) {
				ll.addLast(curr.right);
			}

		}
	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node node) {
		if (node == null) {
			return;
		}

		postorder(node.left);
		postorder(node.right);
		System.out.println(node.data);
	}

	public void inorder() {
		inorder(root);
	}

	private void inorder(Node node) {
		if (node == null) {
			return;
		}

		inorder(node.left);
		System.out.println(node.data);
		inorder(node.right);

	}

	public boolean isbalance() {
		return isbalance(root).isvalid;
	}

	private diapair isbalance(Node node) {
		if (node == null) {
			diapair mp = new diapair();
			mp.isvalid = true;
			mp.height = -1;
			return mp;
		}
		diapair lp = isbalance(node.left);
		diapair rp = isbalance(node.right);
		if (lp.isvalid == false || rp.isvalid == false) {
			diapair mp = new diapair();
			mp.isvalid = false;
			return mp;
		} else {
			int x = lp.height - rp.height;
			if (x >= -1 && x <= 1) {
				diapair mp = new diapair();
				mp.isvalid = true;
				mp.height = Math.max(lp.height, rp.height) + 1;
				return mp;

			} else {
				diapair mp = new diapair();
				mp.isvalid = false;
				mp.height = Math.max(lp.height, rp.height) + 1;
				return mp;
			}
		}

	}

	public boolean isfound(int data) {
		return isfound(root, data);
	}

	public int diameter2() {
		return diameter2(root).diameter;
	}

	private diapair diameter2(Node node) {
		if (node == null) {
			diapair mp = new diapair();
			mp.height = -1;
			mp.diameter = 0;
			return mp;
		}
		diapair lp = diameter2(node.left);
		diapair rp = diameter2(node.right);
		diapair mp = new diapair();
		mp.height = Math.max(lp.height, rp.height) + 1;
		mp.diameter = Math.max(lp.diameter, Math.max(rp.diameter, lp.height + rp.height + 2));
		return mp;
	}

	private boolean isfound(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (data > node.data) {
			return isfound(node.right, data);
		} else if (data < node.data) {
			return isfound(node.left, data);
		} else {
			return true;
		}

	}

	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int lh = height(node.left);
		int rh = height(node.right);
		int x = diameter(node.left);
		int y = diameter(node.right);
		int z = lh + rh + 2;
		return (Math.max(z, Math.max(x, y)));

	}

	public int max() {
		return max(root);
	}

	private int min(Node node) {
		if (node.left == null) {
			return node.data;
		} else {
			return min(node.left);
		}
	}

	public int min() {
		return min(root);
	}

	private int max(Node node) {
		if (node.right == null) {
			return node.data;
		} else {
			return max(node.right);
		}
	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}
		int ls = size2(node.left);
		int rs = size2(node.right);
		return ls + rs + 1;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		int ld = height(node.left);
		int rd = height(node.right);
		if (ld > rd) {
			return ld + 1;
		} else {
			return rd + 1;
		}
	}

	public int size() {
		return size;
	}

	public boolean isempty() {
		return size == 0;
	}

	private Node takeinput(Node parent, boolean ilc, Scanner scn) {
		if (parent == null) {
			System.out.println("Enter data for root");
		} else if (ilc == true) {
			System.out.println("Enter data for left child of " + parent.data);
		} else if (ilc == false) {
			System.out.println("Enter data for right child of " + parent.data);
		}

		int data = scn.nextInt();
		Node temp = new Node();
		temp.data = data;

		System.out.println("Does " + temp.data + " have a left child");
		boolean bl = scn.nextBoolean();
		if (bl == true) {
			temp.left = takeinput(temp, true, scn);
		}

		System.out.println("Does " + temp.data + " have a right child");
		bl = scn.nextBoolean();
		if (bl == true) {
			temp.right = takeinput(temp, false, scn);
		}

		return temp;

	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		String str = "";
		if (node.left != null) {
			str += node.left.data;
		} else {
			str += ".";
		}
		str += " ==> " + node.data + " <== ";
		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ".";
		}
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
}
