package Codelearn;

import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;
}

public class B63_CountLeaf {

    public static Node insert(Node root, int x) {
        if (root == null) {
            Node temp = new Node();
            temp.data = x;
            temp.left = null;
            temp.right = null;
            return temp;
        } else {
            if (x < root.data) {
                root.left = insert(root.left, x);
            } else {
                root.right = insert(root.right, x);
            }
            return root;
        }
    }

    public static boolean isLeafNode(Node node) {
        return (node.left == null && node.right == null);
    }

    public static int countLeafNodes(Node root) {
        if (root == null) {
            return 0;
        }
        if (isLeafNode(root)) {
            return 1;
        }
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node root = null;
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            root = insert(root, temp);
        }
        int leafCount = countLeafNodes(root);
        System.out.println(leafCount);
    }
}
