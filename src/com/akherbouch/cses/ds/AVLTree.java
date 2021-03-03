package com.akherbouch.cses.ds;

public class AVLTree<E extends Comparable<E>> {

    Node<E> root;

    protected static class Node<E> {
        public E data;
        public int size, height;
        public Node<E> lesser, greater;
        public Node(E data) {
            this.data = data;
            size = 1;
        }
    }

    public E getMedian() {
        checkAVL(root);
        System.out.println(root.lesser.size + " - " + root.greater.size);
        return root.data;
    }

    public E findKth(int k) {
        Node<E> cur = root;
        int rootLeftSize = getSize(cur.lesser) + 1;
        while (rootLeftSize != k) {
            if (k > rootLeftSize) {
                cur = cur.greater;
                k -= rootLeftSize;
            }
            else cur = cur.lesser;
            rootLeftSize = getSize(cur.lesser) + 1;
        }
        return cur.data;
    }

    public E findLessOrEqualTo(E data) {
        return this.findLessOrEqualTo(root, data);
    }

    private E findLessOrEqualTo(Node<E> node, E data){
        E res = null;
        if(node == null) return res;
        if(data.compareTo(node.data) < 0) {
            res = findLessOrEqualTo(node.lesser, data);
        }else {
            res = node.data;
            if(data.compareTo(node.data) > 0) {
                E comp = findLessOrEqualTo(node.greater, data);
                if(comp != null) res = comp;
            }
        }
        return res;
    }

    public void insert(E data) {
        root = insert(root, data);
    }

    private Node<E> insert(Node<E> node, E data){
        if(node == null) {
            node = new Node<E>(data);
        }else {
            if(data.compareTo(node.data) <= 0) {
                node.lesser = insert(node.lesser, data);
            }else if(data.compareTo(node.data) > 0) {
                node.greater = insert(node.greater, data);
            }

        }
        node = checkAVL(node);
        return node;
    }

    public void remove(E key) {
        root = remove(root, key);
    }

    private Node<E> remove(Node<E> node, E data){
        if(data.compareTo(node.data) < 0){
            node.lesser = remove(node.lesser, data);
        }else if(data.compareTo(node.data) > 0){
            node.greater = remove(node.greater, data);
        }else {
            if(node.lesser == null && node.greater == null) {
                node = null;
            }else if(node.lesser == null) {
                node = node.greater;
            }else if(node.greater == null) {
                node = node.lesser;
            }else{
                node.greater = minimum(node.greater);
                node.data = successor;
            }
        }
        node = (node != null)? checkAVL(node) : node;
        return node;
    }


    E successor;

    Node<E> minimum(Node<E> node) {
        if(node.lesser == null) {
            successor = node.data;
            node = node.greater;
        }else {
            node.lesser = minimum(node.lesser);
            node = checkAVL(node);
        }
        return node;
    }

    private Node<E> checkAVL(Node<E> node){
        if(node != null) {
            int balance = getBalance(node);
            if(balance < -1 || balance > 1){
                node = rotate(node, balance);
            }
            update(node);
        }
        return node;
    }

    private Node<E> rotate(Node<E> node, int balance){
        if(balance < -1) {
            if(getBalance(node.lesser) <= 0) {
                node = rotateLeftLeft(node);
            }else {
                node = rotateLeftRight(node);
            }
        }else {
            if(getBalance(node.greater) >= 0) {
                node = rotateRightRight(node);
            }else {
                node = rotateRightLeft(node);
            }
        }
        return node;
    }

    private Node<E> rotateRightLeft(Node<E> node) {
        Node<E> pivot = node.greater;
        Node<E> root = pivot.lesser;
        pivot.lesser = root.greater;
        node.greater = root.lesser;
        root.greater = pivot;
        root.lesser = node;
        update(pivot);
        update(node);
        return root;
    }

    private Node<E> rotateRightRight(Node<E> node) {
        Node<E> root = node.greater;
        node.greater = root.lesser;
        root.lesser = node;
        update(node);
        return root;
    }

    private Node<E> rotateLeftRight(Node<E> node) {
        Node<E> pivot = node.lesser;
        Node<E> root = pivot.greater;
        pivot.greater = root.lesser;
        node.lesser = root.greater;
        root.lesser = pivot;
        root.greater = node;
        update(pivot);
        update(node);
        return root;
    }

    private Node<E> rotateLeftLeft(Node<E> node) {
        Node<E> root = node.lesser;
        node.lesser = root.greater;
        root.greater = node;
        update(node);
        return root;
    }


    private void update(Node<E> node) {
        if(node != null) {
            node.height = Math.max(getHeight(node.lesser), getHeight(node.greater))+1;
            node.size = getSize(node.lesser) + getSize(node.greater)+1;
        }
    }

    private int getBalance(Node<E> node) {
        return getHeight(node.greater) - getHeight(node.lesser);
    }

    private int getHeight(Node<E> node) {
        return node != null? node.height : -1;
    }

    private int getSize(Node<E> node) {
        return node != null? node.size : 0;
    }
}