package LinkedList;

class LL {
    private Node head;
    private Node tail;
    private int size;

    LL() {
        this.size = 0;
    }

    int getSize() {
        return size;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size += 1;
    }

    void insert(int index, int val) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        } else if (index > size || index < 0) {
            return;
        }
        int insertionPoint = 1;
        Node temp = head;
        while (insertionPoint != index) {
            temp = temp.next;
            insertionPoint++;
        }
        Node preNode = temp.next;
        temp.next = new Node(val);
        temp.next.next = preNode;
        size += 1;

    }

    void deleteFirst() {
        head = head.next;
        if (head == null) {
            tail = head;
        }
        size -= 1;
    }

    void delete(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        System.out.println("The deleted value is: " + temp.next.data);
        temp.next = temp.next.next;
        size -= 1;
    }

    int find(int val) {
        int index = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) {
                break;
            }
            index++;
            temp = temp.next;
        }
        if (index > size - 1) {
            System.out.println("Given lement is not found");
            return -1;
        }

        return index;

    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

}

public class Linkedlist {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(5);
        list.insertFirst(10);
        list.insertFirst(1);
        list.insertFirst(79);
        list.insertFirst(45);
        list.insertLast(33);
        list.insert(2, 99);
        list.insert(2, 100);
        list.insert(2, 200);
        list.deleteFirst();
        list.delete(2);
        int searchIndex = list.find(9);
        if (searchIndex < 0) {
            System.out.println("Element not found");
        } else {
            System.out.println("Elemnent found at index: " + searchIndex);
        }
        list.display();
        System.out.println("\nSize of LL: " + list.getSize());
    }
}