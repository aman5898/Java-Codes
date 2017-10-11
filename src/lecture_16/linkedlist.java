package lecture_16;

public class linkedlist {
	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	private class heapmover {
		Node node;
		int data;
	}

	public void fold() {
		heapmover left = new heapmover();
		left.node = this.head;
		fold(left, this.head, 0);
	}

	public int mid() {
		Node fast = head;
		Node slow = head;

		while (true) {
			if (fast.next == null || fast.next.next == null) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}

	public int kfromlast(int idx) {
		Node fast = head;
		Node slow = head;
		for (int i = 0; i < idx; i++) {
			fast = fast.next;
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow.data;
	}

	private Node midnode() {
		Node fast = head;
		Node slow = head;

		while (true) {
			if (fast.next == null || fast.next.next == null) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public linkedlist mergesort() {
		if(this.size==1)
		{
			return this;
		}
		Node n = this.midnode();
		
		Node n1 = n.next;
		linkedlist fh = new linkedlist();
		fh.head = this.head;
		fh.tail = n;
		fh.tail.next = null;
		fh.size=(this.size+1)/2;
		
		linkedlist sh = new linkedlist();
		sh.head = n1;
		sh.tail = tail;
		sh.size=(this.size)/2;
		
		
		 fh=fh.mergesort();
		 sh=sh.mergesort();
		 return fh.mergesortedlinkedlists(sh);
		// return
	}
	
	public void evenafterodd()
	{
		linkedlist odd=new linkedlist();
		linkedlist even=new linkedlist();
		while(this.head!=null)
		{
			if(this.head.data%2==0)
			{
				even.addlast(head.data);
			}else
			{
				odd.addlast(head.data);
			}
			head=head.next;
			this.size--;
		}
		this.head=odd.head;
		odd.tail.next=even.head;
		even.tail.next=null;
		this.tail=even.tail;
		this.size=odd.size+even.size();
		
	}
	
	public linkedlist kreverse(int k)
	{
		
		linkedlist onemore=new linkedlist();
		while(head!=null)
		{
			linkedlist imp=new linkedlist();
			for(int i=0;i<k;i++)
			{
				imp.addfirst(head.data);
				head=head.next;
			}
			if(onemore.size()==0)
			{
				onemore=imp;
			}else{
				onemore.tail.next=imp.head;
				onemore.tail=imp.tail;
			}
		}
		this.head=onemore.head;
		this.size=onemore.size;
		this.tail=onemore.tail;
		return this;
	}

	public linkedlist mergesortedlinkedlists(linkedlist other) {
		linkedlist sorted = new linkedlist();
		Node fh = this.head;
		Node sh = other.head;
		while (fh != null && sh != null) {
			if (fh.data < sh.data) {
				sorted.addlast(fh.data);
				fh = fh.next;
			} else {
				sorted.addlast(sh.data);
				sh = sh.next;
			}
		}
		while (fh != null) {
			sorted.addlast(fh.data);
			fh = fh.next;
		}
		while (sh != null) {
			sorted.addlast(sh.data);
			sh = sh.next;
		}
		return sorted;
	}

	public void removeduplicate() {
		Node prev = head;
		Node curr = prev.next;
		while (curr != null) {

			if (curr.data == prev.data) {
				Node temp = prev;
				temp.next = curr.next;
				curr = curr.next;
			} else {
				curr = curr.next;
				prev = prev.next;
			}
		}
	}

	private void fold(heapmover left, Node right, int floor) {
		if (right == null) {
			return;
		}
		fold(left, right.next, floor + 1);
		if (floor > size / 2) {
			Node oln = left.node.next;
			left.node.next = right;
			right.next = oln;
			left.node = oln;
		} else if (floor == size / 2) {
			this.tail = right;
			this.tail.next = null;
		}

	}

	public int removefirst() throws Exception {
		if (size == 0) {
			throw new Exception("Already Empty List");
		}

		int rv = head.data;
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			head = head.next;
		}
		size--;
		return rv;
	}

	public int removeAt(int idx) throws Exception {
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

	public int removelast() throws Exception {
		if (size == 0) {
			throw new Exception("Alredy Empty");
		}
		Node n1 = getnodeat(size - 2);
		int rv = n1.data;
		n1.next = null;
		size--;
		return rv;
	}

	public void display() {
		System.out.println("````````````````````````````````````````");
		// for (Node temp = this.head; temp != null; temp = temp.next) {
		// System.out.print(temp.data+" ");
		// }
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

	public void addat(int data, int idx) throws Exception {
		System.out.println(size);
		if (idx < 0 || idx > size) {
			throw new Exception("Wrong index");
		}
		if (idx == 0) {
			addfirst(data);
		} else if (idx == size) {
			addlast(data);
		} else {

			Node n1 = getnodeat(idx - 1);
			Node n2 = getnodeat(idx);
			Node node = new Node();
			node.data = data;
			node.next = n2;
			n1.next = node;
			size++;
		}

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

	public int getfirst() {
		return head.data;
	}

	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked list is empty");
		}
		return tail.data;
	}

	public int getAt(int idx) throws Exception {
		if (idx < 0 || idx > size) {
			throw new Exception("No data Available");
		}
		Node temp = this.head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	public void addfirst(int data) {
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

	public void addlast(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		//System.out.println(size + "Add last");
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
