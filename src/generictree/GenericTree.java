package generictree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;
	private int size;

	public GenericTree() {
		Scanner scn = new Scanner(System.in);
		root = takeinput(null, -1, scn);
	}

	public int size2() {
		return size2(root);
	}

	public boolean isfound(int data) {
		return isfound(data, root);
	}

	private boolean isfound(int data, Node node) {
		boolean bl = false;
		if (data == node.data) {
			return true;
		}
		for (Node child : node.children) {
			bl = isfound(data, child);
			if (bl == true) {
				return true;
			}
		}
		return bl;
	}

	public void printAtdepth(int x) {
		printAtdepth(root, 0, x);
	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(Node node) {
		System.out.print(node.data + ", ");
		for (Node child : node.children) {
			preorder(child);
		}
	}

	public void levelorder() {
		LinkedList<Node> ll = new LinkedList<>();
		ll.addLast(root);
		while (ll.size() != 0) {
			Node temp = ll.removeFirst();
			System.out.print(temp.data + " ");
			for (Node child : temp.children) {
				ll.addLast(child);
			}

		}
	}

	public void levelorderLW() {
		LinkedList<Node> plist = new LinkedList<>();
		LinkedList<Node> clist = new LinkedList<>();
		plist.addLast(root);
		while (plist.size() != 0) {
			Node temp = plist.removeFirst();
			System.out.print(temp.data + " ");
			// System.out.print(temp.data+" ");
			for (Node child : temp.children) {
				clist.addLast(child);

			}
			if (plist.size() == 0) {
				System.out.println();
				plist = clist;
				clist = new LinkedList<>();
			}

		}
	}

	private class Heapmover {
		int size;
		int height;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		boolean found;
		int predecessor;
		int succesoor = -1;
		boolean success;
		int justlarge = Integer.MAX_VALUE;
		int ksmallest = Integer.MAX_VALUE;
		Node jl;
		Node prev;
		Node curr;
	}
	
	public void printzz()
	{
		printzz(root);
	}
	
	private void printzz(Node node)
	{
		
	}

	public void linearise() {
		linearise(root);
	}

	private void linearise(Node node) {
		for (Node child : node.children) {
			linearise(child);
		}

		for (int i = node.children.size() - 2; i >= 0; i--) {
			Node n = gettail(node.children.get(i));
			Node x = node.children.remove(i +1);
			n.children.add(x);
		}
	}

	private Node gettail(Node node) {
		while (node.children.size() != 0) {
			node = node.children.get(0);
		}
		return node;
	}

	public void removeleaves() {
		// Heapmover move=new Heapmover();
		removeleaves(root);
	}

	protected void removeleaves(Node node) {

		ArrayList<Node> list = node.children;
		int sz = list.size();
		for (int i = 0; i < sz; i++) {
			Node l = list.get(i);
			if (l.children.size() == 0) {
				list.remove(i);
				i -= 1;
				sz -= 1;
			}
		}

		for (Node child : node.children) {
			removeleaves(child);
		}

	}

	public int kthsmallest(int k) {
		int x = Integer.MIN_VALUE;
		for (int i = 0; i <= k; i++) {
			Heapmover mover = new Heapmover();
			kthsmallest(root, mover, x);
			x = mover.jl.data;
		}
		return x;
	}

	private void kthsmallest(Node node, Heapmover mover, int data) {
		if (node.data > data) {
			if (mover.jl == null) {
				mover.jl = node;
			} else {
				if (node.data < mover.jl.data) {
					mover.jl = node;
				}
			}
		}
		for (Node child : node.children) {
			kthsmallest(child, mover, data);
		}
	}

	public void multisolver(int data) {
		Heapmover move = new Heapmover();
		multisolver(root, move, data, 0);
		if (move.found == false) {
			move.predecessor = -1;
		}
		if (move.justlarge == Integer.MAX_VALUE) {
			move.justlarge = -1;
		}
		System.out.println("Size==>" + move.size);
		System.out.println("height==>" + move.height);
		System.out.println("Maxm==>" + move.max);
		System.out.println("Min==>" + move.min);
		System.out.println("Found==>" + move.found);
		System.out.println("Predecessor==>" + move.predecessor);
		System.out.println("Just larger==>" + move.justlarge);
		System.out.println("Suceecessor==>" + move.succesoor);
	}

	private void multisolver(Node node, Heapmover move, int data, int depth) {
		move.size++;
		if (move.success == true) {
			move.succesoor = node.data;
			move.success = false;
		}
		if (node.data == data) {
			move.found = true;
			// node.found==true;
			move.success = true;
		}
		if (node.data > data) {
			if (node.data < move.justlarge) {
				move.justlarge = node.data;
			}
		}
		if (node.data > move.max) {
			move.max = node.data;
		}
		if (node.data < move.min) {
			move.min = node.data;
		}
		if (depth > move.height) {
			move.height = depth;
		}
		if (move.found == false) {
			move.predecessor = node.data;
		}

		for (Node child : node.children) {

			multisolver(child, move, data, depth + 1);

		}
		// if(move.found==true)
		// {
		// move.predecessor=node.data;
		// }
	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node node) {
		for (Node child : node.children) {
			postorder(child);
		}
		System.out.print(node.data + ", ");

	}

	private void printAtdepth(Node node, int dsf, int x) {
		if (dsf == x) {
			System.out.println(node.data);
			return;
		}
		for (Node child : node.children) {
			printAtdepth(child, dsf + 1, x);
		}

	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {
		int left = 0;
		int right = node.children.size() - 1;
		while (left <= right) {
			Node check = node.children.get(left);
			node.children.set(left, node.children.get(right));
			node.children.set(right, check);
			left++;
			right--;
		}
		for (Node child : node.children) {
			mirror(child);
		}
	}

	public int height() {
		return height(root) - 1;
	}

	private int height(Node node) {
		int depth = 0;
		for (Node child : node.children) {
			int x = height(child);
			if (x > depth) {
				depth = x;
			}
		}
		return depth + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		int maxm = node.data;
		for (Node child : node.children) {
			int x = max(child);
			if (x > maxm) {
				maxm = x;
			}
		}

		return maxm;
	}

	private int size2(Node node) {
		int sz = 0;
		for (Node child : node.children) {
			sz += size2(child);
		}
		return sz + 1;
	}

	private Node takeinput(Node parent, int childidx, Scanner scn) {
		if (parent == null) {
			System.out.println("Enter data for root");
		} else {
			System.out.println("Enter data for " + childidx + " child of " + parent.data);
		}

		int x = scn.nextInt();
		Node child = new Node();
		child.data = x;
		this.size++;
		System.out.println("Enter no. of child of " + child.data);
		int y = scn.nextInt();
		for (int i = 0; i < y; i++) {
			Node grandchildren = takeinput(child, i, scn);
			child.children.add(grandchildren);
		}
		return child;
	}

	public void display() {
		display(root);
	}

	public void display(Node node) {
		String str = node.data + "==>";
		for (Node child : node.children) {
			str += child.data + " , ";
		}
		str += ".";
		System.out.println(str);
		for (Node child : node.children) {
			display(child);
		}
	}

	public int size() {
		return this.size;
	}

	public boolean Isempty() {
		return this.size == 0;

	}

}
