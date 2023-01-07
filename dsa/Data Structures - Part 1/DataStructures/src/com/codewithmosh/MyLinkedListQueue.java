package com.codewithmosh;

public class MyLinkedListQueue<E> {

    class Node {
        E val;
        Node next;
        Node prev;

        public Node(E val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }

        public Node(E val, Node n, Node p) {
            this.val = val;
            this.next = n;
            this.prev = p;
        }
    }

    private int count = 0;
    private Node head;
    private Node tail;

    public MyLinkedListQueue() {
        this.head = null;
        this.tail = head;
    }

    public void enqueue(E item) {
        Node node = new Node(item);

        if(count == 0) {
            head = node;
            tail = head;
            count++;
            return;
        }
        
        tail.next = node;
        node.prev = tail;
        tail = node;
        count++;
    }

    public E dequeue() {
        if(isEmpty())
            throw new IllegalStateException();
        E ret = head.val;
        head = head.next;
        head.prev = null;
        count--;
        return ret;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public E peek() {
        if(head == null)
            throw new IllegalStateException();
        return head.val;
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        Node temp = head;
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < count; i++) {
            s.append(temp.val + "<-");
            temp = temp.next;
        }
        return s.toString();
    }

}
