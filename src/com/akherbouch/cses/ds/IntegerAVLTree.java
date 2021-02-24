package com.akherbouch.cses.ds;

public class IntegerAVLTree {

    protected Node root;

    protected static class Node {
        public int value, size, height;
        public Node lesser, greater;
        public Node(int data) {
            this.value = data;
            size = 1;
        }
    }

    public int size() {
        return getSize(root);
    }

    // Insert
    public void insert(int value) {
        root = insert(root, value);
    }
    protected Node insert(Node node, int value) {
        if (node == null) node = new Node(value);
        else if (value < node.value) node.lesser = insert(node.lesser, value);
        else if (value > node.value) node.greater = insert(node.greater, value);
        return checkAVL(node);
    }

    // Search
    public boolean contains(int value) {
        return find(value) != null;
    }
    protected Node find(int value) {
        Node cur = root;
        while(cur != null && cur.value != value) {
            if (value < cur.value) cur = cur.lesser;
            else cur = cur.greater;
        }
        return cur;
    }
    
    // Remove
    public void remove(int value) {
        root = remove(root, value);
    }
    protected Node remove(Node node, int value) {
        if (value < node.value) node.lesser = remove(node.lesser, value);
        else if (value > node.value) node.greater = remove(node.greater, value);
        else { // equal
            if (node.lesser == null && node.greater == null) node = null;
            else if (node.greater == null) node = node.lesser;
            else if (node.lesser == null) node = node.greater;
            else {
                node.greater = minimum(node.greater);
                node.value = successor;
            }
        }
        return checkAVL(node);
    }

    // Balancing
    
    int successor;

    protected Node minimum(Node node) {
        if(node.lesser == null) {
            successor = node.value;
            node = node.greater;
        } else {
            node.lesser = minimum(node.lesser);
            node = checkAVL(node);
        }
        return node;
    }

    protected Node checkAVL(Node node){
        if(node == null) return null;
        int balance = getBalance(node);
        if(balance < -1 || balance > 1) 
            node = rotate(node, balance);
        update(node);
        return node;
    }

    protected Node rotate(Node node, int balance){
        if(balance < -1) {
            if(getBalance(node.lesser) <= 0) 
                return rotateLeftLeft(node);
            return rotateLeftRight(node);
        }
        if(getBalance(node.greater) >= 0) 
            return rotateRightRight(node);
        return rotateRightLeft(node);
    }

    protected Node rotateRightLeft(Node node) {
        Node pivot = node.greater;
        Node root = pivot.lesser;
        pivot.lesser = root.greater;
        node.greater = root.lesser;
        root.greater = pivot;
        root.lesser = node;
        update(pivot);
        update(node);
        return root;
    }

    protected Node rotateRightRight(Node node) {
        Node root = node.greater;
        node.greater = root.lesser;
        root.lesser = node;
        update(node);
        return root;
    }

    protected Node rotateLeftRight(Node node) {
        Node pivot = node.lesser;
        Node root = pivot.greater;
        pivot.greater = root.lesser;
        node.lesser = root.greater;
        root.lesser = pivot;
        root.greater = node;
        update(pivot);
        update(node);
        return root;
    }

    protected Node rotateLeftLeft(Node node) {
        Node root = node.lesser;
        node.lesser = root.greater;
        root.greater = node;
        update(node);
        return root;
    }
    
    protected void update(Node node) {
        if(node == null) return;
        node.height = Math.max(getHeight(node.lesser), getHeight(node.greater))+1;
        node.size = getSize(node.lesser) + getSize(node.greater) + 1;
    }

    protected int getBalance(Node node) {
        return getHeight(node.greater) - getHeight(node.lesser);
    }

    protected int getHeight(Node node) {
        return node != null ? node.height : -1;
    }

    protected int getSize(Node node) {
        return node != null ? node.size : 0;
    }
}
