package LinkedList;

class DLL {
    private Node head;
    private Node tail;
    private int size;

    DLL() {
        this.size = 0;
    }

    int getSize() {
        return size;
    }

    private class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;

        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    void insert(int index, int val) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        int i = 0;
        Node temp = head;
        while (++i < index && temp != null) {
            temp = temp.next;
        }
        Node node = new Node(val);
        Node nextNode = temp.next;
        temp.next = node;
        node.prev = temp;
        if (nextNode == null) {
            tail = node;
        }
        if (nextNode != null) {
            node.next = nextNode;
            nextNode.prev = node;
        }
        size += 1;
    }

    void delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 0) { // Delete the first node
            deleteFirst();
            return;
        }

        if (index == size - 1) { // Delete the last node
            deleteLast();
            return;
        }

        int i = 0;
        Node temp = head;

        // Traverse to the node at position `index`
        while (i < index) {
            temp = temp.next;
            i++;
        }

        // Adjust links
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        size--; // Reduce the size
    }

    // Delete the first node
    void deleteFirst() {
        if (head == null) return;

        if (head == tail) { // Only one node
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
    }

    // Delete the last node
    void deleteLast() {
        if (tail == null) return;

        if (head == tail) { // Only one node
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    void displayReverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.prev;
        }
        System.out.print("START");
    }

}

public class DoublelyLinkedList {
    public static void main(String[] args) {
        DLL dlist = new DLL();
        dlist.insertFirst(55);
        dlist.insertFirst(5);
        dlist.insertFirst(53);
        dlist.insertFirst(80);
        dlist.insertFirst(77);
        dlist.insertFirst(32);
        dlist.insert(0, 99);
        dlist.deleteFirst();
        dlist.delete(0);
        dlist.display();
        System.out.println();
        dlist.displayReverse();

    }
}
