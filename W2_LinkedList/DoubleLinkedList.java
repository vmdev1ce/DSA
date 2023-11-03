public class DoubleLinkedList {

	static Node head;

	class Node {
		int data;
		Node next;
		Node prev;

		Node(int d) {
			data = d;
			next = null;
			prev = null;
		}
	}

	public void push(int data) {
		// them phan tu vao dau danh sach
		Node new_node = new Node(data);
		new_node.prev = null;
		new_node.next = head;
		if (head != null)
			head.prev = new_node;
		head = new_node;
	}

	public void ammend(int data) {
		// them phan tu vao cuoi danh sach
		Node temp = head;
		Node new_node = new Node(data);
		if (temp == null) {
			new_node.prev = null;
			new_node.next = head;
			head = new_node;
			return;
		}
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new_node;
		new_node.prev = temp;
		new_node.next = null;
	}

	public void insertAfter1(Node node, int data) {
		//them phan tu vao vi tri bat ky
		if (node == null)
			return;
		Node new_node = new Node(data);
		new_node.prev = node;
		new_node.next = node.next;
		node.next = new_node;
		new_node.next.prev = new_node;
	}

	public void insertInPos(int position, int data) {
		if (position <= 0 || head == null) {
			push(data);
		} else {
			Node current = head;
			int count = 2;
	
			while (current != null && count < position) {
				current = current.next;
				count++;
			}
	
			if (current != null) {
				Node new_node = new Node(data);
				new_node.prev = current;
				new_node.next = current.next;
	
				if (current.next != null) {
					current.next.prev = new_node;
				}
	
				current.next = new_node;
			} else {
				ammend(data);
			}
		}
	}
	public void deletePos(int pos) {
		// xoa phan tu o vi tri bat ky
		Node temp = head;
		if (head == null)
			return;
		if (pos == 1) {
			if (temp.next == null)
				head = null;
			else {
				temp.next.prev = null;
				head = temp.next;
			}
			return;
		}
		for (int i = 1; i < pos - 1 && temp != null; i++) {
			temp = temp.next;
		}
		if (temp == null || temp.next == null || pos < 1) {
			return;
		}
		if (temp.next.next == null) {
			temp.next = null;
			return;
		}
		Node next = temp.next.next;
		next.prev = temp;
		temp.next = next;
	}

	public void deleteLastNode() {
		//xoa phan tu cuoi cung
		if (head == null) {
			return;
		}

		Node temp = head;
		Node prevtemp = null;

		while (temp.next != null) {
			prevtemp = temp;
			temp = temp.next;
		}

		if (prevtemp == null) {
			head = null;
		} else {
			prevtemp.next = null;
		}
	}

	public int count() {
		// dem so phan tu
		int count = 0;
		Node temp = head;

		while (temp != null) {
			count++;
			temp = temp.next;
		}

		return count;
	}

	public boolean isEmpty() {
		// kiem tra rong?
		return head == null;
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		DoubleLinkedList dll = new DoubleLinkedList();
		//Thêm 1 Node vào đầu danh sách
		dll.push(8);
		dll.printList();
		dll.push(9);
		dll.push(87);
		dll.printList();
		//Thêm 1 Node vào cuối danh sách
		dll.ammend(2);
		dll.printList();
		dll.ammend(11);
		dll.ammend(5);
		dll.printList();
		//Thêm 1 Node ở vị trí thứ 3 trong danh sách
		dll.insertInPos(3, 13);
		dll.printList();
		//Xóa 1 Node đầu tiên trong danh sách.
		dll.deletePos(1);
		dll.printList();
		//Xóa 1 Node cuối cùng trong danh sách.
		dll.deleteLastNode();
		dll.printList();
		//Xóa 1 Node ở vị trí thứ 4 trong danh sách
		dll.deletePos(4);
		dll.printList();
		//Trả về số phần tử trong danh sách.
		System.out.println(dll.count());
		// Kiểm tra danh sách có trống hay không?
		System.out.println(dll.isEmpty());
	}
}