package com.codewithmosh;
import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class MyStack<E extends Object> {
    
    private E[] elements;
    private int topIdx;
    private int size = 0;
    private int capacity;

    public MyStack(Class<E> clazz, int capacity) {
        elements = (E[]) Array.newInstance(clazz, capacity);
        this.capacity = capacity;
    }

    public void push(E element) {
        if(this.size == 0) {
            this.elements[0] = element;
            this.topIdx = 0;
            this.size++;
            return;
        }

        if(this.capacity == this.size) 
            throw new IllegalStateException();
        
        this.elements[++this.topIdx] = element;
        this.size++;
    }

    public E pop() {
        if(this.isEmpty()) {
            throw new EmptyStackException();
        }
        var element = this.elements[this.topIdx--];
        return element;
    }

    public E peek() {
        return this.elements[this.topIdx];
    }

    public boolean isEmpty() {
        if(this.size == 0) return true;
        return false;
    }


}
