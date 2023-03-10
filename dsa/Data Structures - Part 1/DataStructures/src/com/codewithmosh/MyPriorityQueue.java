package com.codewithmosh;
import java.util.Arrays;

public class MyPriorityQueue {

    private final int[] items;
    private int count;

    public MyPriorityQueue(int capacity) {
        this.items = new int[capacity];
        this.count = 0;
    }

    public void add(int item) {
        if(this.isFull())
            throw new IllegalStateException();
        if(this.count < this.items.length) {
            this.addToQueue(item); 
            this.count++;
        }
    }

    public boolean isFull() {
        return this.count == this.items.length;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int remove() {
        return this.items[--this.count];
    }

    private void addToQueue(int item) {
        int i;
        for(i = this.count - 1; i >= 0; i--) {
            if(this.items[i] > item)
                this.items[i+1] = this.items[i];
            else
                break;
        }

        this.items[i + 1] = item;
    }

    @Override
    public String toString() {
        int[] temp = new int[this.count];
        for(int i = 0; i < temp.length; i++) {
            temp[i] = this.items[i];
        }
        return Arrays.toString(temp);
    }
}
