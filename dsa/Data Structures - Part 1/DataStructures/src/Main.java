import com.codewithmosh.MyLinkedList;
import java.util.Arrays;

public class Main {
    public static void main(String[] names) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(20);
        list.addFirst(30);
        list.addLast(40);
        list.addLast(50);
        System.out.println(list.size());
        list.deleteFirst();
        list.deleteFirst();
        list.deleteLast();
        list.print();
        System.out.println(list.contains(20));
        System.out.println(list.indexOf(30));
        System.out.println(Arrays.toString(list.toArray()));
        // list.print();
    }
}
