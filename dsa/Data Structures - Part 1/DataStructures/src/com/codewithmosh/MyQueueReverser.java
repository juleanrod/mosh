package com.codewithmosh;
import java.util.Queue;
import java.util.Stack;

public class MyQueueReverser {

    public static void reverse(Queue<Integer> q) {

        if(q.isEmpty())
            throw new IllegalStateException();

        Stack<Integer> stack = new Stack<>();

        while(!q.isEmpty())
            stack.push(q.remove());
        while(!stack.isEmpty())
            q.add(stack.pop());
    }

}
