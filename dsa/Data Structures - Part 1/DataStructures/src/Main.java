import java.util.*;
import com.codewithmosh.*;

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
        //ArrayDeque<Integer> queue = new ArrayDeque<>();
        //queue.add(10);
        //queue.add(20);
        //queue.add(30);
        //queue.add(40);
        //queue.add(50);
        //MyQueueReverser.reverse(queue, 3);
        //System.out.println(queue.toString());

        //ArrayQueue Implementation
        //MyArrayQueue queue = new MyArrayQueue(5);
        //queue.enqueue(10);
        //queue.enqueue(20);
        //queue.enqueue(30);
        //queue.dequeue();
        //System.out.println(queue.toString());
        //var front = queue.dequeue();
        //queue.enqueue(40);
        //queue.enqueue(50);
        //queue.enqueue(60);
        //System.out.println(front);
        //System.out.println(queue.toString());
        //queue.enqueue(70);
        //System.out.println(queue.toString());
        //System.out.println(queue.isFull());

        //QueueWithTwoStacks
        //MyQueueWithTwoStacks<Integer> q = new MyQueueWithTwoStacks<>();
        //q.enqueue(10);
        //q.enqueue(20);
        //q.enqueue(30);
        //System.out.println(q);
        //q.dequeue();
        //System.out.println(q);
        //q.enqueue(40);
        //System.out.println(q);

        //PriorityQueue
        //MyPriorityQueue queue = new MyPriorityQueue(5);
        //queue.add(5);
        //queue.add(2);
        //queue.add(3);
        //queue.remove();
        //System.out.println(queue.toString());

        //LinkedListQueue
        //MyLinkedListQueue<Integer> llq = new MyLinkedListQueue<>();
        //llq.enqueue(10);
        //llq.enqueue(20);
        //llq.enqueue(30);
        //System.out.println(llq.toString());
        //llq.dequeue();
        //llq.dequeue();
        //System.out.println(llq.toString());
        //System.out.println(llq.peek());
        //System.out.println(llq.size());

        //StackWithTwoQueues
        MyStackWithTwoQueues<Integer> stack = new MyStackWithTwoQueues<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack.toString());

    }
}
