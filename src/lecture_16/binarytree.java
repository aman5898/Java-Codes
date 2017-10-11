package lecture_16;

import java.util.LinkedList;
import java.util.Scanner;

//import generictree.GenericTree.Node;

public class binarytree {
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
		int size = 0;
		Node newroot;
	}

	public binarytree() {
		Scanner scn = new Scanner(System.in);
		root = takeinput(root, false, scn);
	}

	public void isbst1() {
		bstpair mp=isbst1(root);
		System.out.println(mp.newroot.data);
		System.out.println(mp.size);
	}

	public bstpair isbst1(Node node) {

		if (node == null) {
			bstpair x = new bstpair();
			x.isbst = true;
			return x;
		}
		bstpair lp = isbst1(node.left);
		bstpair rp = isbst1(node.right);
		bstpair mp = new bstpair();
		mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
		mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
		if (lp.isbst == true && rp.isbst == true) {
			if (node.data < rp.min && node.data > lp.max) {
				mp.isbst = true;
			} else {
				mp.isbst = false;
			}
		} else {
			mp.isbst = false;
		}

		if (mp.isbst) {
			mp.size = lp.size + rp.size + 1;
			mp.newroot = node;
		} else if (lp.size > rp.size) {
			mp.size = lp.size;
			mp.newroot = lp.newroot;
		} else {
			mp.size = rp.size;
			mp.newroot = rp.newroot;
		}

		return mp;

	}

	public void removeleaves() {
		removeleaves(root, null, false);
	}

	private void removeleaves(Node node, Node parent, boolean ilc) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null && parent != null) {
			if (ilc == true) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		removeleaves(node.left, node, true);
		removeleaves(node.right, node, false);

	}

	public void pws() {
		System.out.println(root.data);
		pws(root, null, false);
	}

	private void pws(Node node, Node parent, boolean ilc) {
		if (node == null) {
			return;
		}
		pws(node.left, node, true);
		pws(node.right, node, false);
		if (ilc == true && parent != null) {
			if (parent.right == null) {
				System.out.println(node.data);
			}
		} else if (ilc == false && parent != null) {
			if (parent.left == null) {
				System.out.println(node.data);
			}
		}

	}

	public binarytree(int[] post, int[] in) {
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

	public boolean isBst() {
		return isBst(root).isbst;
	}

	private bstpair isBst(Node node) {
		if (node == null) {
			bstpair bp = new bstpair();
			bp.isbst = true;
			return bp;
		}
		bstpair lp = isBst(node.left);
		bstpair rp = isBst(node.right);
		bstpair mp = new bstpair();
		if (lp.isbst == false || rp.isbst == false) {
			mp.isbst = false;
		} else {
			if (lp.max < node.data) {
				if (node.data < rp.min) {
					mp.isbst = true;
					mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
					mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
				} else {
					mp.isbst = false;
				}
			} else {
				mp.isbst = false;
			}
		}
		return mp;
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
		if (node.data == data) {
			return true;
		}
		boolean lf = isfound(node.left, data);
		boolean rf = isfound(node.right, data);
		if (lf == true || rf == true) {
			return true;
		} else {
			return false;
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

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int lm = max(node.left);
		int rm = max(node.right);
		if (lm > rm) {
			if (lm > node.data) {
				return lm;
			} else {
				return node.data;
			}
		} else {
			if (rm > node.data) {
				return rm;
			} else {
				return node.data;
			}
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
