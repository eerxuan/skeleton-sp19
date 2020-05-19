public class LinkedListDeque<T> implements Deque<T> {
    private final Node<T> head;
    private int size;

    public LinkedListDeque(){
        head = new Node<>(null);
        head.next = head;
        head.prev = head;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque<T> other) {
        head = new Node<>(null);
        head.next = head;
        head.prev = head;
        size = 0;
        Node<T> node = other.head.next;
        while (node != head) {
            this.addLast(node.val);
            node = node.next;
        }
    }

    public T getRecursive(int index){
        return geRecursiveHelper(head.next, index);
    }

    public T geRecursiveHelper(Node<T> node, int index){
        T value;
        if (index == 0) {
            return node.val;
        }
        value = geRecursiveHelper(node.next, index-1);
        return value;
    }

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        Node<T> buffer = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = buffer;
        buffer.prev = newNode;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        Node<T> buffer = head.prev;
        head.prev = newNode;
        newNode.next = head;
        newNode.prev = buffer;
        buffer.next = newNode;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node<T> node = head.next;
        while (node != head) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        T value = head.next.val;
        head.next = head.next.next;
        head.next.prev = head;
        size -= 1;
        return value;
    }

    @Override
    public T removeLast() {
        T value = head.prev.val;
        head.prev = head.prev.prev;
        head.prev.next = head;
        size -= 1;
        return value;
    }

    @Override
    public T get(int index) {
        Node<T> node = head.next;
        while (index != 0){
            node = node.next;
            index -= 1;
        }
        return node.val;
    }
}

class Node<T> {
    T val;
    Node<T> next;
    Node<T> prev;

    public Node(T val){
        this.val = val;
        next = null;
        prev = null;
    }
}
