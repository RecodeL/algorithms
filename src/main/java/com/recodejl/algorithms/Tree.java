package com.recodejl.algorithms;

import com.recodejl.common.Node;

public class Tree {
    public static void dfsPreorder(Node root){
        if (root == null) return;
        System.out.println(root.letter + ": " + root.percent);
        dfsPreorder(root.left);
        dfsPreorder(root.right);
    }

    public static void getLineage(Node root, double percent){
        if (root == null) return;
        // System.out.println(root.letter + ": " + root.percent);
        if(root.left != null) {
            System.out.println("Child: " + root.left.letter + " Ownership: " + percent * 100 + "%");
            getLineage(root.left, percent * root.left.percent);
        }
        if(root.right != null) {
            System.out.println("Child: " + root.right.letter + " Ownership: " + percent * 100 + "%");
            getLineage(root.right, percent * root.right.percent);
        }
        // getLineage(root.right);
    }
    public static void lineage(Node root){
        if (root == null) return;
        System.out.println(root.letter);
        getLineage(root, root.percent);
        lineage(root.left);
        lineage(root.right);
//        if (root.left != null){
//
//            lineage(root.left, root.percent * root.left.percent);
//        }
//        if(root.right != null){
//            System.out.println("Child: " + root.right.letter + " Ownership: " + percent * 100 + "%");
//            lineage(root.right, root.percent * root.right.percent);
//        }

        // lineage(root.right);
    }


    public static void main(String[] args) {
        // Node root = new Node(100, 'A');
        Node
                a = new Node(0.50, 'A'),
                b = new Node(0.25, 'B'),
                c = new Node(0.10, 'C'),
                d = new Node(0.50, 'D'),
                e = new Node(0.15, 'E'),
                f = new Node(0.30, 'F'),
                g = new Node(0.80, 'G');
/*//       a
//        /\
//       b  c
//       /  /
        d  g
//      /\
       e  f
//
//        */
        a.left = b; a.right = c;
        b.left = d;
        d.left = e; d.right = f;
        c.left = g;
        lineage(a);
        // dfsPreorder(a);
        // System.out.println("Hello World!");
    }
}
