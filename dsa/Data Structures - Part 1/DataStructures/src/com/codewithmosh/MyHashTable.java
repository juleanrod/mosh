package com.codewithmosh;
import java.util.LinkedList;

import javax.swing.text.html.parser.Entity;

import java.lang.StringBuilder;
import java.util.Iterator;

public class MyHashTable<I, S> {

    private LinkedList<Entry>[] buckets;
    private int CAPACITY = 5;
    private int count;

    private class Entry {
        private I key;
        private S val;

        public Entry(I i, S s) {
            this.key = i;
            this.val = s;
        }

        public I getKey() {
            return this.key;
        }

        public S getValue() {
            return this.val;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("{%s: %s}", (getKey()), getValue()));
            return sb.toString(); 
        }
    }

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        this.buckets = new LinkedList[CAPACITY]; 
        this.count = 0;
    }

    public void put(I key, S val) {
        int idx = this.hash(key);

        Entry entry = new Entry(key, val);

        if(buckets[idx] == null) {
            buckets[idx] = new LinkedList<Entry>();
        } 
        if(validKey(key)) {
            buckets[idx].add(entry);
            count++;
        } else {
            throw new IllegalArgumentException();
        }

    }

    public S get(I key) {
        int idx = hash(key);
        LinkedList<Entry> bucket = buckets[idx];
        int llidx = 0;
        Entry entry = bucket.element();
        while(llidx < bucket.size()) {
            entry = bucket.get(llidx);
            if(entry.getKey() == key)
                break;
            llidx++;

        }
        return entry.getValue();
    }

    private int hash(I key) {
        int res = (int)key % this.CAPACITY;
        return res;
    }

    private boolean validKey(I key) {
        int idx = this.hash(key);
        if(this.buckets[idx] == null)
            throw new IllegalArgumentException();
        Iterator<MyHashTable<I, S>.Entry> it = buckets[idx].iterator();
        while(it.hasNext()) {
            if(it.next().getKey() == key) 
                return false;
        }
        return true; 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < buckets.length; i++) {
            if(buckets[i] == null)
                sb.append(" null, ");
            else if(i == buckets.length-1 || buckets[buckets.length - 1] == null) {
                sb.append(buckets[i].toString());
                break;
            } else {
                sb.append(buckets[i].toString() + ',');
            }
        }
        return sb.append(']').toString();
    }

}
