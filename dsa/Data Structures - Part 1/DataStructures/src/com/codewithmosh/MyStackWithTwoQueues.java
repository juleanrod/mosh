package com.codewithmosh;
import java.util.LinkedList;
import java.util.Queue;

public class MyStackWithTwoQueues<E> {
    Queue<E> q1 = new LinkedList<>();
    Queue<E> q2 = new LinkedList<>();

    public void push(E item) {
        if(q1.size() == 0)
            q1.add(item);
        else {
            // item = 40
            // q1:[40,30,20,10]
            // sizeOfQ1 = 3
            // q2:[]
            int sizeOfQ1 = q1.size();
            for(int j = 0 ; j < sizeOfQ1; j++)
                q2.add(q1.remove());
            q1.add(item);
            for(int k = 0 ; k < sizeOfQ1 ; k++)
                q1.add(q2.remove());
        }
    }

    public E pop() {
        if(q1.isEmpty())
            throw new IllegalStateException();
        return q1.remove();
    }

    public E peek() {
        if(q1.isEmpty())
            throw new IllegalStateException();
        return q1.peek();
    }

    public int size() {
        if(q1.isEmpty())
            throw new IllegalStateException();
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    @Override
    public String toString() {
        return q1.toString();
    }
}
