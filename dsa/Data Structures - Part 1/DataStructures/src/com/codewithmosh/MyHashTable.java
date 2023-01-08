package com.codewithmosh;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.text.html.parser.Entity;

import java.lang.StringBuilder;
import java.util.Iterator;

public class MyHashTable<K, V> {

    private LinkedList<Entry>[] buckets;
    private int CAPACITY = 5;

    private class Entry {
        public K key;
        public V val;

        public Entry(K k, V v) {
            this.key = k;
            this.val = v;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("{%s: %s}", (this.key), (this.val)));
            return sb.toString(); 
        }
    }

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        this.buckets = new LinkedList[CAPACITY]; 
    }

    public void put(K key, V val) {
        var entry = getEntry(key);
        if(entry != null)
            entry.val = val;

        var bucket = getOrCreateBucket(key);
        bucket.addLast(new Entry(key, val));
    }

    public V get(K key) {
        var entry = getEntry(key);

        return (entry == null) ? null : entry.val;
    }

    public void remove(K key) {
        var entry = getEntry(key);
        if(entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);
    }

    private LinkedList<Entry> getBucket(K key) {
        return buckets[hash(key)];
    }

    private Entry getEntry(K key) {
        var bucket = getBucket(key);
        if(bucket != null) {
            for(var entry : bucket) {
                if(entry.key == key)
                    return entry;
            }
        }

        return null;
    }

    private LinkedList<Entry> getOrCreateBucket(K key) {
        var idx = hash(key);
        var bucket = buckets[idx];
        if(bucket == null)
            buckets[idx] = new LinkedList<Entry>();

        return buckets[idx];
    }

    private int hash(K key) {
        return (int)key % this.CAPACITY;
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
