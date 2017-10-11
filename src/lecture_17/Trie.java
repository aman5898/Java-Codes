package lecture_17;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
	private class Node {
		Character data;
		boolean eof;
		HashMap<Character, Node> children = new HashMap<>();
	}

	private Node root = new Node();
	private int numWords = 0;
	private int numNodes = 1;

	public void display() {
		display(root, "");
	}

	private void display(Node node, String osf) {
		if (node.eof) {
			System.out.println(osf);
		}
		ArrayList<Character> keys = new ArrayList<>(node.children.keySet());
		for (Character key : keys) {
			Node child = node.children.get(key);
			display(child, osf + key);
		}
	}

	public void removeword(String word) {
		removeword(root, word);
	}

	private void removeword(Node node, String word) {
		if (word.length() == 0) {
			node.eof = false;
			this.numWords--;
			return;
		}
		char ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = node.children.get(ch);
		if (child != null) {
			removeword(child, ros);
			this.numNodes--;
			if (child.eof == false && child.children.size() == 0) {
				node.children.remove(ch);
			}
		} else {
			System.out.println("Word not found");
			return;
		}

	}

	public boolean searchWord(String word) {
		return searchWord(word, root);
	}

	private boolean searchWord(String word, Node node) {
		// TODO Auto-generated method stub
		if (word.length() == 0) {
			return node.eof;
		}
		char ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = node.children.get(ch);
		if (child == null) {
			return false;
		} else {
			return searchWord(ros, child);
		}
	}

	public void addWord(String word) {
		addWord(root, word);
	}

	public void addWord(Node node, String word) {
		if (word.length() == 0) {
			this.numWords += 1;
			node.eof = true;
			return;
		}
		char ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = node.children.get(ch);
		if (child != null) {
			addWord(child, ros);
		} else {
			this.numNodes += 1;
			child = new Node();
			child.data = ch;
			node.children.put(ch, child);
			addWord(child, ros);
		}
	}
}
