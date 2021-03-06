package linkedlist;

import java.util.Scanner;

public class oddevenLL {

	public static void main(String[] args) {
Scanner s=new Scanner (System.in);
int n=s.nextInt();
oddevenLL obj=new oddevenLL();
LinkedList list=obj.new LinkedList();
for(int i=0;i<n;i++) {
	list.addLast(s.nextInt());
}
		LinkedList ll=list.oddeven(list);
		ll.display();
		
	}
	




	public class LinkedList {
		private class Node {
			int data;
			Node next;

			Node(int data, Node next) {
				this.data = data;
				this.next = next;
			}
		}

		Node head;
		Node tail;
		int size;

		public LinkedList() {
			// TODO Auto-generated constructor stub
			this.head = null;
			this.tail = null;
			this.size = 0;
		}

		public int size() {
			return this.size;
		}

		public boolean isEmpty() {
			return this.size() == 0;
		}

		public void addFirst(int data) {
			Node node = new Node(data, this.head);
			this.head = node;
			if (this.isEmpty()) {
				this.tail = node;
			}
			this.size++;
		}

		public void addLast(int data) {
			Node node = new Node(data, null);
			if (this.isEmpty()) {
				this.head = node;
				this.tail = node;
			} else {
				this.tail.next = node;
				this.tail = node;
			}
			this.size++;
		}

		private Node getNodeAt(int index) throws Exception {
			if (index < 0 || index >= this.size) {
				throw new Exception("Invalid Index");
			}

			Node temp = this.head;
			int counter = 0;
			while (counter < index) {
				temp = temp.next;
				counter++;
			}

			return temp;
		}

		public void addAt(int index, int data) throws Exception {
			if (index < 0 || index > this.size) {
				throw new Exception("Invalid Index");
			}
			if (index == 0) {
				this.addFirst(data);
			} else if (index == this.size) {
				this.addLast(data);
			} else {
				Node temp = this.getNodeAt(index - 1);
				Node node = new Node(data, temp.next);
				temp.next = node;
				this.size++;
			}

		}

		public int getFirst() throws Exception {
			if (this.isEmpty()) {
				throw new Exception("List is Empty");
			}

			return this.head.data;
		}

		public int getLast() throws Exception {
			if (this.isEmpty()) {
				throw new Exception("List is Empty");
			}

			return this.tail.data;
		}

		public int getAt(int index) throws Exception {
			if (this.isEmpty()) {
				throw new Exception("List is Empty");
			}

			if (index < 0 || index >= this.size) {
				throw new Exception("Invalid index");
			}

			return this.getNodeAt(index).data;
		}

		public void removeFirst() throws Exception {
			if (this.isEmpty()) {
				throw new Exception("List is Empty");
			}

			if (this.size == 1) {
				this.head = null;
				this.tail = null;
			} else {
				this.head = this.head.next;
			}
			this.size--;
		}

		public void removeLast() throws Exception {
			if (this.isEmpty()) {
				throw new Exception("List is Empty");
			}

			if (this.size == 1) {
				this.head = null;
				this.tail = null;
			} else {
				Node temp = this.getNodeAt(this.size - 2);
				temp.next = null;
				this.tail = temp;
			}
			this.size--;
		}

		public void removeAt(int index) throws Exception {
			if (this.isEmpty()) {
				throw new Exception("List is Empty");
			}

			if (index < 0 || index >= this.size) {
				throw new Exception("Invalid Index");
			}

			if (index == 0) {
				this.removeFirst();
			} else if (index == this.size - 1) {
				this.removeLast();
			} else {
				Node temp = this.getNodeAt(index - 1);
				temp.next = temp.next.next;
				this.size--;
			}

		}

		public void display() {
			Node temp = this.head;
			while (temp != null) {
				System.out.print(temp.data+" ");
				temp = temp.next;
			}
		}


    public LinkedList oddeven(LinkedList list) {
	   
	LinkedList temp1=new LinkedList();
	Node temp=this.head;
	while(temp!=null) {
		if(temp.data%2!=0) {
		temp1.addLast(temp.data);
		}
		temp=temp.next;
		}
	temp=this.head;
	while(temp!=null) {
		if(temp.data%2==0) {
		temp1.addLast(temp.data);
		}
		temp=temp.next;
		}
	return temp1;
	}
	

	}

}
