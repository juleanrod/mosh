import com.codewithmosh.MyLinkedList;

public class Main {
    public static void main(String[] names) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(20);
        list.addFirst(30);
        list.addLast(40);
        list.addLast(50);
        list.deleteFirst();
        list.deleteLast();
        list.print();
    }
}
