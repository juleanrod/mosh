package com.codewithmosh;

public class MyBinaryTree {

    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    public void insert(int value) {
        var node = new Node(value);
        if(root == null) {
            root = node;
            return;
        }

        var current = root;
        while(current != null) {
            if(value < current.value) {
                if(current.left == null) {
                    current.left = node;
                    break;
                }
                current = current.left;
            } else {
                if(current.right == null) {
                    current.right = node;
                    break;
                }
                current = current.right;
            } 
        }
        
    }

    public boolean find(int value) {
        var current = root;
        while(current != null) {
            if(value < current.value) {
                current = current.left;
            } else if(value > current.value) {
                current = current.left;
            } else {
                return true;
            }
        }

        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePreOrder(Node root) {
        if(root == null) return;
        // Root, Left, Rigth
        
        System.out.println(root.value);
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    private void traverseInOrder(Node root) {
        if(root == null) return;
        // Left, Root, Right
        
        traversePreOrder(root.left);
        System.out.println(root.value);
        traversePreOrder(root.right);
    }

    private void traversePostOrder(Node root) {
        if(root == null) return;
        // Left, Right, Root
        
        traversePreOrder(root.left);
        traversePreOrder(root.right);
        System.out.println(root.value);
    }

    private int height(Node root) {
        if(root.left == null && root.right == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public int height() {
        return height(root);
    }

}
