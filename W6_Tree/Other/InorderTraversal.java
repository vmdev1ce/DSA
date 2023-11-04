package Other;

import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;
}

public class InorderTraversal {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node root = null;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            root = insert(root, x);
        }
        printTree(root);
    }
}
