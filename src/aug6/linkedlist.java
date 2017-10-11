package aug6;


public class linkedlist<T> {
	private class Node {
		T data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public void display() {
		System.out.println("````````````````````````````````````````");
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("\n````````````````````````````````````````");
	}

	public int size() {
		return this.size;
	}



	public T getfirst() {
		return head.data;
	}
	
	private Node getnodeat(int idx) throws Exception {

		if (idx < 0 || idx > this.size) {
			throw new Exception("Wrong entry");
		}
		Node temp = this.head;

		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public T removelast() throws Exception {
		if (size == 0) {
			throw new Exception("Alredy Empty");
		}
		Node n1 = getnodeat(size - 2);
		T rv = n1.data;
		n1.next = null;
		size--;
		return rv;
	}

	public T getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked list is empty");
		}
		return tail.data;
	}

	public T getAt(int idx) throws Exception {
		if (idx < 0 || idx > size) {
			throw new Exception("No data Available");
		}
		Node temp = this.head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	public void addfirst(T data) {
		Node node = new Node();
		//System.out.println(size + " add first");
		node.data = data;
		node.next = this.head;
		this.head = node;
		if(this.size==0)
		{
			tail=head;
		}
		size++;
	}
	
	public T removeAt(int idx) throws Exception {
		if (idx < 0 || idx > size - 1) {
			throw new Exception("Not Valid Index");
		}
		System.out.println(size);

		if (idx == 0) {
			return removefirst();
		} else if (idx == size - 1) {
			return removelast();
		} else {
			Node prevn = getnodeat(idx - 1);
			Node node = prevn.next;
			Node nexn = node.next;
			prevn.next = nexn;
			this.size--;
			return node.data;
		}

		// return node.data;
	}
	
	public T removefirst() throws Exception {
		if (size == 0) {
			throw new Exception("Already Empty List");
		}

		T rv = head.data;
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			head = head.next;
		}
		size--;
		return rv;
	}

	public void addlast(T data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		if (this.size == 0) {

			this.head = node;
			this.tail = node;
			this.size++;

		} else {
			this.tail.next = node;
			this.tail = node;

			this.size++;
		}

	}

}
