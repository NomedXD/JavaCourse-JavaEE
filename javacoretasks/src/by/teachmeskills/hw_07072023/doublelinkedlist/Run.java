package by.teachmeskills.hw_07072023.doublelinkedlist;

public class Run {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.add(6);
        doubleLinkedList.add(12);
        doubleLinkedList.add(77);
        doubleLinkedList.addFirst(99);
        boolean isDone = doubleLinkedList.remove(Integer.valueOf(12));
        System.out.println(doubleLinkedList);
    }

}
