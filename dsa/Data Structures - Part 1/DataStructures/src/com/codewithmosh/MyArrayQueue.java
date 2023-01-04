package com.codewithmosh;
import java.lang.IllegalStateException;
import java.util.Arrays;

public class MyArrayQueue {

    private int front;
    private int rear;
    private final int[] queue;
    private int size;

    public MyArrayQueue(int capacity) {
        this.queue = new int[capacity];
    }

    public void enqueue(int element) {
        if(this.size == queue.length)
            throw new IllegalStateException();
        this.queue[this.rear] = element;
        this.rear = (this.rear + 1) % this.queue.length;
        this.size++;
    }

    public int dequeue() {
        var element = queue[this.front];
        queue[this.front] = 0;
        this.front = (this.front + 1) % queue.length;
        this.size--;
        return element;
    }

    public int peek() {
        if(this.isEmpty())
            throw new IllegalStateException();
        return this.queue[this.front];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.queue.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.queue);
    }
}
