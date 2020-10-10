package com.ifindn.node;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Mr.Guo
 * @Date 2020-06-16 22:55
 */
public class Node {

    Map<String,Integer> map = new HashMap<>();

    //节点的值
    private int value;
    //此节点值
    private Node node;
    //此节点的左子节点
    private Node left;
    //此节点的右子节点
    private Node right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return this.value + "";
    }
}
