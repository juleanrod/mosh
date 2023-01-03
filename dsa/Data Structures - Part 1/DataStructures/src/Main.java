import java.util.*;
import com.codewithmosh.MyQueueReverser;

public class Main {
    public static void main(String[] names) {
        //MyLinkedList<Integer> list = new MyLinkedList<>();
        //list.addFirst(20);
        //list.addFirst(30);
        //list.addLast(40);
        ////list.addLast(50);
        //System.out.println(list.size());
        ////list.deleteFirst();
        ////list.deleteFirst();
        ////list.deleteLast();
        //System.out.println(list.contains(20));
        //System.out.println(list.indexOf(30));
        //System.out.println(Arrays.toString(list.toArray()));
        ////list.reverse();
        //System.out.println(Arrays.toString(list.toArray()));
        //System.out.println(list.getKthFromTheEnd(2));
        //list.printMiddle();

        //Stack<Character> stack = new Stack<>();
        //String input = "julian";
        //StringBuffer inputReversed = new StringBuffer();
        //for(char ch : input.toCharArray())
            //stack.push(ch);
        //while(!stack.empty())
            //inputReversed.append(stack.pop());
        //System.out.println(inputReversed);
        //boolean result = BalanceChecker.isBalanced("(3+2(3/4))<>");
        //System.out.println(result);

        //Class clazz = int.class;
        //int i = 10;
        //MyStack<Integer> stack = new MyStack<>(clazz, 3);
        //stack.push(2);
        //System.out.println(stack.isEmpty());

        // Reversing a Queue
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        MyQueueReverser.reverse(queue);
        System.out.println(queue.toString());
    }
}
