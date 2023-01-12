package com.codewithmosh;

public class MyAVLTree {
    private class AVLnode {
        int value;
        AVLnode left;
        AVLnode right;
        int height;

        public AVLnode(int value) {
            this.value = value;
        }

        public AVLnode(int value, AVLnode left, AVLnode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.format("Value=%s", this.value);
        }
    }

    private AVLnode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLnode insert(AVLnode root, int value) {
        //i.g => AVLTree = [10]
        //insert(5) =>   10
        //           null  null
        if(root == null)
            return new AVLnode(value);

        if(value < root.value)
            root.left = insert(root.left, value);
        else
            root.left = insert(root.right, value);

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        if(root.height > 1 || root.height < -1)
            balance(root);

        return root;
    }

    private int height(AVLnode node) {
        if(node == null)
            return -1;
        return node.height;
    }

    private void balance(AVLnode root) {

        // balanaceFactor = height(left) - height(right)
        // bf > 1 => left heavy
        // bf < -1 => right heavy
    }
}

