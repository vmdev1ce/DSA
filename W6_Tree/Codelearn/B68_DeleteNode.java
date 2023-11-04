package Codelearn;

import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;
}

public class B68_DeleteNode {
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

    public static void printTree(Node root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.data + " ");
            printTree(root.right);
        }
    }

    public static void deleteNode(Node node) {
        if (node != null) {
            if (node.left != null) {
                deleteNode(node.left);
            }
            if (node.right != null) {
                deleteNode(node.right);
            }
            node = null;
        }
    }

    public static Node deleteNumber(Node root, int x) {
        if (root != null) {
            if (root.data == x) {
                deleteNode(root.left);
                deleteNode(root.right);
                root = null;
            } else if (root.data > x) {
                root.left = deleteNumber(root.left, x);
            } else {
                root.right = deleteNumber(root.right, x);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        Node root = null;

        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            root = insert(root, temp);
        }

        root = deleteNumber(root, x);

        if (root == null) {
            System.out.println("NULL");
        } else {
            printTree(root);
        }
    }
}

