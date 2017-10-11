package lecture_16;

public class queue {

	protected int[] data;
	protected int front;
	protected int size;

	public queue() {
		this(5);
	}

	public queue(int cap) {
		this.data = new int[cap];
	}

	public void display() throws Exception {
		if (size == 0) {
			throw new Exception("Nothing to Display");

		}
		System.out.println("`````````````````````````````````");
		for (int i = 0; i < size; i++) {
			System.out.print(data[(front + i) % data.length]+" ");
		}
		System.out.println("\n`````````````````````````````````");
	}

	public int sizee() {
		return this.size;
	}

	public boolean isempty() {
		return this.size == 0;
	}

	public int dequeue() throws Exception {
		if (size == 0) {
			throw new Exception("Queue is empty");
		}
		int x = this.data[front];
		this.data[this.front] = 0;

		this.front = (this.front + 1) % this.data.length;
		this.size--;
		return x;
	}

	public void enqueue(int value) throws Exception {
		if (this.size == data.length) {
			throw new Exception("Stack is full");
		}

		int tail = (front + this.size) % this.data.length;
		this.data[tail] = value;
		this.size++;
	}

}
