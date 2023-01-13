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

        setHeight(root);

        return balance(root);
    }

    private AVLnode balance(AVLnode root) {
        // balanaceFactor = height(left) - height(right)
        // bf > 1 => left heavy
        // bf < -1 => right heavy
        if(isLeftHeavy(root)) {
            if(balanceFactor(root.left) < 0)
                root.left = leftRotate(root.left);
            rightRotate(root);
        } else if(isRightHeavy(root)) {
            if(balanceFactor(root.right) > 0)
                root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    private AVLnode leftRotate(AVLnode node) {
        AVLnode newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;

        setHeight(node);
        setHeight(newRoot);
        return newRoot;
    }
    
    private AVLnode rightRotate(AVLnode node) {
        AVLnode newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;

        setHeight(node);
        setHeight(newRoot);
        return newRoot;
    }

    private void setHeight(AVLnode node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private boolean isRightHeavy(AVLnode node) {
        return balanceFactor(node) < - 1;
    }

    private boolean isLeftHeavy(AVLnode node) {
        return balanceFactor(node) > 1;
    }

    private int balanceFactor(AVLnode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private int height(AVLnode node) {
        if(node == null)
            return -1;
        return node.height;
    }

}

