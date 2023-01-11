package com.codewithmosh;

import java.util.ArrayList;
import java.util.List;

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
        if(root == null)
            return -1;
        if(root.left == null && root.right == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public int height() {
        return height(root);
    }

    private int min(Node root) {
        if(root == null)
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while(current != null) {
            last = current;
            current = current.left;
        }
        return last.value;
    }

    public int min() {
        return min(root);
    }

    public boolean equals(MyBinaryTree other) {
        if(other == null)
            return false;
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if(first == null & second == null)
            return true;
        if(first != null && second != null)
            return first.value == second.value && 
                equals(first.left, second.left) &&
                equals(first.right, second.right);

        return false;
    }

    public boolean isBinarySearchTree() {
        if(root == null) return false;

        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isBinarySearchTree(Node root, int min, int max) {
        if(root == null)
            return true;
        if(root.value < min || root.value > max)
            return false;
        return isBinarySearchTree(root.left, min, root.value - 1) &&
            isBinarySearchTree(root.right, root.value - 1, max);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(this.root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if(root == null) return;
        if(distance == 0) {
            list.add(root.value);
            return;
        }
        getNodesAtDistance(root.left, distance - 1, list);
        getNodesAtDistance(root.right, distance - 1, list);

    }

    public int size(){
        return (int) Math.pow(height(), 2);
    }

    public int getLeafCount() {
        return getLeafCount(root);
    }

    private int getLeafCount(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;

        return getLeafCount(node.left) + getLeafCount(node.right);
    }

    public int max(){
        if(root == null)
            throw new IllegalStateException();
        return max(root, Integer.MIN_VALUE);
    }

    private int max(Node node, int max) {
        if(node.right == null)
            return node.value;
        return Math.max(max(node.right, node.value), node.value);
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node node, int target) {
        if(node == null)
            return false;
        if(target < node.value)
            contains(node.left, target);
        else if(target > node.value)
            contains(node.right, target);
        
        return node.value == target;
    }

    public boolean areSiblings(int value1, int value2) {
        return areSiblings(root, value1, value2);
    }

    private boolean areSiblings(Node node, int v1, int v2) {
        /*

                        20
                       /  \
                     10    30
                    /  \   /
                   6   14 24
                  / \       \
                 3   8      26    

        */

        if(node == null) return false;

        if(node.right != null && node.left != null) {
            int l = node.left.value;
            int r = node.right.value;
            if(l == v1 && r == v2)
                return true;
            else if(r == v1 && l == v2)
                return true;
        }

        if(node.left != null)
            return areSiblings(node.left, v1, v2);
		if(node.right != null)
            return areSiblings(node.right, v1, v1);
            
        return false; 
    }

    public List<Integer> getAncestors(int value) {
        List<Integer> list = new ArrayList<>();
        getAncestors(root, list, value);
        return list;
    }

    private void getAncestors(Node node, List<Integer> ancestors, int target) {
        /*

                        20
                       /  \
                     10    30
                    /  \   /
                   6   14 24
                  / \       \
                 3   8      26    

        */

        if (node == null)
            return;

        if (isAncestorOf(target, node))
            ancestors.add(node.value);

        if(target < node.value)
            getAncestors(node.left, ancestors, target);
        else
            getAncestors(node.right, ancestors, target);
    }

    private boolean isAncestorOf(int target, Node node) {
        if(node == null)
            return false;
        if(target == node.value)
            return true;
        else
            isAncestorOf(target, node.right);
        
        return isAncestorOf(target, node.left) || isAncestorOf(target, node.right);
    }
}
