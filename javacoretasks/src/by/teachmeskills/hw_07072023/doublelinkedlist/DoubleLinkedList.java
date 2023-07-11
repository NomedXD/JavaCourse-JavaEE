package by.teachmeskills.hw_07072023.doublelinkedlist;

public class DoubleLinkedList<T> {
    transient int size = 0;
    transient Node<T> first;
    transient Node<T> last;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    // Add at the begging
    public void addFirst(T data) {
        if (isEmpty())
            first = new Node<>(data);
        else {
            Node<T> temp = first;
            first = new Node<>(data,null, temp);
            first.next.prev = first;
        }
        size++;
    }

    // Add to end
    public boolean add(T node) {
        linkLast(node);
        return true;
    }

    private void linkLast(T node) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(node, l, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    // Insertion at index position
    public void add(int index, T element) {
        checkPositionIndex(index);

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, findNodePosition(index));
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Out of bounds at index" + index);
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private Node<T> findNodePosition(int index) {
        Node<T> x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
        } else {
            x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
        }
        return x;
    }

    private void linkBefore(T element, Node<T> nextNode) {
        final Node<T> pred = nextNode.prev;
        final Node<T> newNode = new Node<>(element, pred, nextNode);
        nextNode.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    // Removing element
    public T remove(int index) {
        checkPositionIndex(index);
        return unlink(findNodePosition(index));
    }

    T unlink(Node<T> x) {
        final T data = x.data;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.data = null;
        size--;
        return data;
    }

    public boolean remove(Object nodeData) {
        if (nodeData == null) {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.data == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<T> x = first; x != null; x = x.next) {
                if (nodeData.equals(x.data)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    // Other methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public void clear(){
        first = null;
        last = null;
    }

    public boolean contains(T element){
        Node<T> temp = first;
        boolean returnable = false;
        while (temp != null) {
            if (element.equals(temp.data)) {
                returnable = true;
                break;
            }
            temp = temp.next;
        }
        return returnable;
    }

    public T get(int index){
        return findNodePosition(index).data;
    }

    public T getFirst(){
        return first.data;
    }

    public T getLast(){
        return last.data;
    }

    @Override
    public String toString() {
        Node<T> temp = first;
        StringBuilder builder = new StringBuilder("[");
        while (temp != null) {
            builder.append(temp.data).append(",");
            temp = temp.next;
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
