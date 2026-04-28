public class LinkedList {
    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head = null;
    public static Node tail = null;
    public static int size = 0;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addMiddle(int idx, int data) {
        if(head == null || idx == 0) {
            addFirst(data);
            return;
        } else if(idx >= size) {
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        for(int i=0; i<idx-1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public int removeFirst() {
        if(head == null) {
            System.out.println("Linked List is empty");
            return -1;
        } else if(head.next == null) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeMiddle(int idx) {
        if(head == null || idx == 0) {
            return removeFirst();
        } else if(idx >= size-1) {
            return removeLast();
        } else {
            Node temp = head;
            for(int i=0; i<idx-1; i++) {
                temp = temp.next;
            }

            int val = temp.next.data;
            temp.next = temp.next.next;
            size--;
            return val;
        }
    }

    public int removeLast() {
        if(head == null) {
            System.out.println("Linked List is empty");
            return -1;
        } else if(head.next == null) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        Node temp = head;
        while(temp.next != tail) {
            temp = temp.next;
        }
        int val = tail.data;
        tail = temp;
        tail.next = null;
        size--;
        return val;
    }

    public void print() {
        if(head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        Node temp = head;
        while(temp != null) {
            if(temp.next == null) {
                System.out.print(temp.data);
                return;
            }
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addLast(3);
        ll.addMiddle(0, 1);
        ll.print();
        System.err.println();
        System.out.println("LinkedList size: " + size);
        System.err.println();
        ll.removeMiddle(1);
        ll.print();
        System.err.println();
        ll.removeFirst();
        ll.removeLast();
        ll.print();
        System.err.println();
        System.out.println("LinkedList size: " + size);
        System.err.println();
    }
}
