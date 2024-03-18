public class SinglyLinkedList<T> {

    // Inner Node class.
    public class Node<T> {
        // Properties of the Node class.
        // The two properties should be:
        // 1. data (the data stored in the node).
        // 2. next (a reference (also known as a pointer) to the next node.
        private T data;
        private Node next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }
        public T getData() {
            return data;
        }
        // Constructor of the Node class.
        // The constructor should set the data property of the Node to be the value passed as a parameter.
        // The constructor should set the next property of the Node to be null.


    }

    // Properties of the Singly Linked List class.
    // The three properties should be:
    // 1. size (records the number of nodes in our Singly Linked List)
    // 2. head (a reference to the first (also known as the head) node in our Singly Linked List).
    // 3. tail (a reference to the last (also known as the tail) node in our Singly Linked List.
    private int size;
    private Node head;
    private Node tail;

    // Constructor.
    // Creates a Singly Linked List with a head node.
    public SinglyLinkedList(T value) {
        head = new Node(value);
        tail = head;
        size = 1;
    }

    // Methods

    // size
    // returns the size of the Singly Linked List.
    public int size() {

        return size;

    }

    // isEmpty
    // returns whether the Singly Linked List is empty.
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;

    }

    // peekFirst
    // returns the data stored in the head node.
    // throws a run time exception if the Singly Linked List is empty.
    public T peekFirst() throws RuntimeException {
        if (size == 0) {
            throw new RuntimeException();
        }
        return (T) head.getData();

    }

    // peekLast
    // returns the data stored in the tail node.
    // throws a run time exception if the Singly Linked List is empty.
    public T peekLast() throws RuntimeException {
        if (size == 0) {
            throw new RuntimeException();
        }
        return (T)tail.getData();

    }

    // addFirst
    // Adds a node to the front of the Singly Linked List.
    public void addFirst(T value) {
        Node temp = new Node(value);
        if (size ==0) {tail = temp; head = temp;size++; return;}
        temp.setNext(head);
        head = temp;
        size++;
    }

    // addLast
    // Adds a node to the back of the Singly Linked List.
    public void addLast(T value) {
        Node temp = new Node(value);
        if (size == 0) {tail = temp; head = temp;size++; return;}
        tail.setNext(temp);
        tail = temp;
        size++;
    }

    // insertAt
    // Inserts a node at a specific index.
    // If the index is equal to 0, then we can invoke the addFirst method.
    // If the index is equal to size, then we can invoke the addLast method.
    // throws an illegal argument exception if the index is invalid.
    public void insert(T value, int index) throws IllegalArgumentException {
        if (index ==0) { addFirst(value); return;} else if (index == size) {addLast(value); return;}
        Node temp = head;
        Node insert = new Node(value);
        if (size == 0) {head = insert; tail = insert; return;} else if (index > size || index < 0) {throw new IllegalArgumentException();} else if (index == size) {tail.setNext(insert); tail = insert; return;}
        for (int i = 1; i < index;i++) {
            temp = temp.getNext();
        }
        insert.setNext(temp.getNext());
        temp.setNext(insert);
        size++;
    }

    // removeFirst
    // Removes the first (also known as the head node) from the Singly Linked List.
    // Throws a run time exception if the Singly Linked List is empty.
    // Returns the data stored in the head node.
    // If the size of the Singly Linked List becomes 0, need to set the tail to null.
    public T removeFirst() throws RuntimeException {
        if (size == 0) {throw new RuntimeException();}
        T ret = (T)head.getData();
        if (size == 1) {tail = null; head = null; size--; return ret;}
        head = head.getNext();
        size--;

        return ret;

    }

    // removeLast
    // Removes the last (also known as the tail node) from the Singly Linked List.
    // Throws a run time exception if the Singly Linked List is empty.
    // Returns the data stored in the tail node.
    // If the size of the Singly Linked List becomes 0, need to set the tail to null.

    public T removeLast() throws RuntimeException {
        if (size == 0) {throw new RuntimeException();}
        Node temp = head;
        T ret = (T)tail.getData();
        if (size == 1){tail = null; head = null; size--; return ret;}
        while (true) {
            if (temp.getNext() == tail) {
                break;
            }
            temp = temp.getNext();
        }

        if (size == 1) {tail = null; head = null; size--; return ret;}
        temp.setNext(null);
        tail = temp;
        size--;
        return ret;

    }

    // removeAt
    // Removes a node at a specific index.
    // Returns the data stored in the removed node.
    // If the index is equal to 0, then we can invoke the removeFirst method.
    // If the index is equal to size-1, then we can invoke the removeLast method.
    // throws an illegal argument exception if the index is invalid.

    public T removeAt(int index) throws RuntimeException {
        if (size == 0) {throw new RuntimeException();} else if (index >= size) throw new IllegalArgumentException(); else if (index <0) throw new IllegalArgumentException();
        if (index == 0) {return removeFirst();} else if (index+1 == size) {return removeLast();}
        Node temp = head;
        T temp2 = (T)temp.getData();
        if (size == 1){tail = null; head = null; size--; return temp2;}

        for (int i = 2; i < index; i++) {
            temp = temp.getNext();
        }
            T ret = (T) temp.getNext().getData();
            temp.setNext(temp.getNext().getNext());
        size--;
        return ret;
    }

    // contains
    // Determines whether the Singly Linked List contains a node that holds data equivalent to the value passed.
    // Returns a boolean.
    public boolean contains(T value) {
        Node temp = head;
        while (true) {
            if ((T)temp.getData() == value) {return true;}
            if (temp == tail) {
                break;
            }
            temp = temp.getNext();
        }
        return false;

    }

    // valueAt
    // Returns the data held in the node at a specified index.
    // Throws an illegal argument exception if the index is invalid.
    public T valueAt(int index) throws IllegalArgumentException {
        if (size == 0) {throw new RuntimeException();} else if (index >= size) throw new IllegalArgumentException(); else if (index <0) throw new IllegalArgumentException();
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return (T)temp.getData();

    }

    // reverse
    // Reverses the Singly Linked List.
    public void reverse() {
        SinglyLinkedList reversed = new SinglyLinkedList(head.data);

        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
            reversed.addFirst(temp.data);
        }
        head = reversed.head;
        tail = reversed.tail;

    }

    // toString
    // Returns a String representation of the Singly Linked List.
    public String toString() {
        Node temp = head;
        String str = "" + head.data + " -> ";
        while (temp.next != null){
            temp = temp.next;
            str += ""+ temp.data + " -> ";
        }
        str += "null";
        return str;
    }

}