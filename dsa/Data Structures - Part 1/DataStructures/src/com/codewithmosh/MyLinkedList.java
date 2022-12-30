package com.codewithmosh;
import java.util.ArrayList;

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
            this.head = newNode;
            this.tail = this.head;
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
