package com.codewithmosh;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;

public class MyLinkedList<T> {
    private class Node {
        private T val;
        private Node next;
        
        public Node(T value) {
            this.val = value;
        }
    }

    private int size = 0;
    private Node head;
    private Node tail;

    public void addFirst(T value) {
        Node newNode = new Node(value);
        // check if the head is null
        if(head == null) {
            this.head = newNode;
            this.tail = this.head;
            this.size++;
            return;
        }
        // else just add a new node
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    public void addLast(T value) {
        Node newNode = new Node(value);
        // check if the head is null
        if(head == null) {
            this.head = this.tail = newNode;
            this.size++;
            return;
        }
        if (this.size == 1) {
            this.head.next = newNode;
            this.tail = newNode;
            this.size++;
            return;
        }
        
        this.tail.next = newNode;
        this.tail = newNode;
        this.size++;
    }

    public void deleteFirst() {
        if(this.size <= 0) return;
        if(this.size == 1) {
            this.head = this.tail = null;
            this.size--;
        }
        this.head = this.head.next;
        this.size--;
    }

    public void deleteLast() {
        if(this.size <= 0) 
            throw new NoSuchElementException();
        if(this.head == this.tail) {
            this.head = this.tail = null;
            this.size--;
            return;
        }
        Node current = this.head;
        for (int i = 0; i < this.size - 1; i++) {
            current = current.next;
        }
        this.tail =  current.next;
        this.size--;
    }

    public boolean contains(T value) {
        Node current = this.head;
        for (int i = 0; i < this.size; i++) {
            if (current.val == value) return true;
            current = current.next;
        }
        return false;
    }

    public int indexOf(T value) {
        Node current = this.head;
        for (int i = 0; i < this.size; i++) {
            if (current.val == value) return i;
            current = current.next;
        }
        return -1;
    }

    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        ArrayList<T> list = new ArrayList<>();
        Node current = this.head;
        int index = 0;
        while(current != null) {
            list.add(current.val);
            current = current.next;
        }
        Object[] arr = new Object[this.size];
        arr = list.toArray(arr);
        return arr;
    }

    public void reverse() {
        Node previous = this.head;
        Node current = this.head.next;

        this.tail = this.head;
        this.tail.next = null;
        while(current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current; 
            current = next;
        }
        this.head = previous;
    }

    public Object getKthFromTheEnd(int k) {
        if(this.size() == 0) throw new IllegalStateException();
        Node b = this.head;
        Node a = this.head;
        for(int i = 0; i < k; i++) {
            b = b.next;
            if(b == null)
                throw new IllegalArgumentException();
        }
        while (b != null) {
            a = a.next;
            b = b.next;
        }
        return a.val;
    }
    
    public void printMiddle() {
        if(this.size == 0) return;

        ArrayList<T> al = new ArrayList<>();
        boolean odd = this.size % 2 != 0;
        int targetIdx = this.size / 2;
        Node current = this.head;
        for(int i = 0; i <= targetIdx; i++) {
            if(odd && i == targetIdx) {
                current = current.next;
                System.out.printf("[%s]\n", current.val);
            }
            if(!odd && i == targetIdx) {
                current = current.next;
                System.out.printf("\n[%s, %s]", current.val, current.next.val);
            }
        }
    }

    public boolean hasLoop() {
        Node a = this.head;
        Node b = this.head;
        while (b != this.tail && b.next != this.tail) {
            b = b.next.next;
            a = a.next;
            if (a == b) return true;
        }

        return false;
    }
}
