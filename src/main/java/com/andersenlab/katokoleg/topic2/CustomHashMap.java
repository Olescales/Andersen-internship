package com.andersenlab.katokoleg.topic2;

import java.util.Arrays;

public class CustomHashMap<K, V> {

    private double loadFactor;
    private Node<K, V>[] bucket;
    private int capacity;
    private int size;

    public CustomHashMap() {
        capacity = 16;
        loadFactor = 0.75d;
        bucket = new Node[capacity];
    }

    public CustomHashMap(double loadFactor, int capacity) {
        this.loadFactor = loadFactor;
        this.capacity = capacity;
        bucket = new Node[capacity];
    }

    public void put(K key, V value) {
        int hashCode = hashingFunction(key);
        int nodeIndex = getPositionInBucket(hashCode);
        Node<K, V> newNode = new Node<>(hashCode, key, value);
        if (bucket[nodeIndex] == null) {
            bucket[nodeIndex] = newNode;
        } else {
            Node<K, V> currentNode = bucket[nodeIndex];
            bucket[nodeIndex] = newNode;
            newNode.nextNode = currentNode;
        }
        size++;
        if (needToExtend()) {
            extendBucket();
        }
    }

    public V get(K key) {
        int hashCode = hashingFunction(key);
        int elementIndex = getPositionInBucket(hashCode);
        if (bucket[elementIndex] != null) {
            Node<K, V> node = bucket[elementIndex];
            while (node.nextNode != null) {
                if (node.key.equals(key)) {
                    return node.value;
                } else {
                    node = node.nextNode;
                }
            }
            return node.value;
        }
        return null;
    }

    public boolean containsKey(K key) {
        int hashCode = hashingFunction(key);
        int positionInBucket = getPositionInBucket(hashCode);
        return bucket[positionInBucket] != null && bucket[positionInBucket].hashcode == hashCode;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != null) {
                Node<K, V> node = bucket[i];
                if (node.value.equals(value)) {
                    return true;
                }
                while (node.nextNode != null) {
                    if (node.nextNode.value.equals(value)) {
                        return true;
                    }
                    node = node.nextNode;
                }
            }
        }
        return false;
    }

    public V remove(K key) {
        int hashCode = hashingFunction(key);
        int positionInBucket = getPositionInBucket(hashCode);
        if (bucket[positionInBucket] == null) {
            return null;
        }
        Node<K, V> node = bucket[positionInBucket];
        if (node.nextNode == null) {
            bucket[positionInBucket] = null;
            size--;
            return node.value;
        }
        while (node.nextNode != null) {
            Node<K, V> checkedNode = node.nextNode;
            if (checkedNode.key.equals(key)) {
                if (checkedNode.nextNode == null) {
                    node.nextNode = null;
                } else {
                    node.nextNode = checkedNode.nextNode;
                }
                size--;
                return checkedNode.value;
            }
            node = node.nextNode;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(bucket, null);
        size = 0;
    }

    private int hashingFunction(K key) {
        return key.hashCode();
    }

    private int getPositionInBucket(int hashCode) {
        return hashCode & (capacity - 1);
    }

    private void extendBucket() {
        capacity *= 2;
        Node<K, V>[] newBucket = new Node[capacity];
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] != null) {
                Node<K, V> last = bucket[i];
                if (last.nextNode != null) {
                    bucket[i] = last.nextNode;
                }
                int newIndex = getPositionInBucket(last.hashcode);
                newBucket[newIndex] = last;
            }
        }
        bucket = newBucket;
    }

    private boolean needToExtend() {
        return size > capacity * loadFactor;
    }

    private static class Node<K, V> {
        int hashcode;
        K key;
        V value;
        Node<K, V> nextNode;

        public Node(int hashcode, K key, V value) {
            this.hashcode = hashcode;
            this.key = key;
            this.value = value;
        }
    }
}