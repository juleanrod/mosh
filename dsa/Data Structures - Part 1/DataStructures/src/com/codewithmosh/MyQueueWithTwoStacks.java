package com.codewithmosh; import java.util.Stack;
import java.lang.IllegalStateException;
import java.util.Arrays;

public class MyQueueWithTwoStacks<T> {

    private Stack<T> stack1;
    private Stack<T> stack2;
    private T front;
    private T rear;

    public MyQueueWithTwoStacks() {
        this.stack1 = new Stack<>();
        this.stack2= new Stack<>();
    }

    // O(1)
    public void enqueue(T value) {
        this.stack1.push(value);
    }

    // O(n)
    public T dequeue() {
        if(this.stack1.isEmpty() && this.stack2.isEmpty())
            throw new IllegalStateException();
        if(this.stack2.isEmpty()) {
            while(!this.stack1.isEmpty())
                this.stack2.push(this.stack1.pop());
        }
        return this.stack2.pop();
    }

    public boolean isEmpty() {
        return this.stack1.isEmpty() && this.stack2.isEmpty();
    }

    @Override
    public String toString() {
        Object[] firstHalf = this.stack2.toArray();
        Object[] secondHalf = this.stack1.toArray();
        int length = firstHalf.length + secondHalf.length;
        int[] result = new int[length];

        int idx = 0;
        for(int i = firstHalf.length - 1; i >= 0; i--) {
            result[idx++] = (int) firstHalf[i];
        }
        for(int j = 0; j < secondHalf.length; j++) {
            result[idx++] = (int) secondHalf[j];
        }

        return Arrays.toString(result);
    }

}
