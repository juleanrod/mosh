package com.codewithmosh;
import java.util.ArrayList;
import java.util.NoSuchElementException;

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
        Object[] array = new Object[this.size];
        Node current = this.head;
        int index = 0;
        while(current != null) {
            array[index++] = current.val;
            current = current.next;
        }
        return array;
    }

    public void print() {
        ArrayList<T> list = new ArrayList<>();
        Node reference = this.head;
        if (this.size == 0) {
            System.out.println("[]");
        }
        for (int i = 0; i < this.size; i++) {
            list.add(reference.val);
            reference = reference.next;
        }
        System.out.println(list);
    }
    
}
