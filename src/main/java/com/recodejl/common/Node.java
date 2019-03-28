package com.recodejl.common;

public class Node {
    // mark all attributes as public for simplicity, ideally they should be in setters
    public Node left;
    public Node right;
    public double percent;
    public char letter;

    public Node(double percent, char ltr){
        this.percent = percent;
        this.letter = ltr;
        this.left = null;
        this.right = null;
    }
}
