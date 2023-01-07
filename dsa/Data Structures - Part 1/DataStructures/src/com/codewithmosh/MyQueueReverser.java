package com.codewithmosh;
import java.util.Stack;
import java.util.ArrayDeque;

public class MyQueueReverser {

    public static void reverse(ArrayDeque<Integer> q) {

        if(q.isEmpty())
            throw new IllegalStateException();

        Stack<Integer> stack = new Stack<>();

        while(!q.isEmpty())
            stack.push(q.remove());
        while(!stack.isEmpty())
            q.add(stack.pop());
    }

    public static void reverse(ArrayDeque<Integer> q, int k) {
        //Reverse the order of the first K elements in the Queue
        if(k > q.size() || k <= 0)
            throw new IllegalArgumentException();
        if(q.isEmpty())
            throw new IllegalStateException();
        if(k == q.size())
            MyQueueReverser.reverse(q);

        Stack<Integer> stack = new Stack<>();
        ArrayDeque<Integer> temp = new ArrayDeque<>();

        int i = q.size() - k;

        while(i >= 0) {
            stack.push(q.remove());
            i--;
        }
        System.out.println(stack);
        while(!stack.isEmpty())
            temp.add(stack.pop());

        while(!temp.isEmpty()) {
            q.offerFirst(temp.removeLast());
        }
    }

}
