package Other;

public class HeightOfBinaryTree {

    static int height = -1;
    static class Node {
        int data;
        Node left;
        Node right;
    };

    static Node newNode(int item) {
        Node temp = new Node();
        temp.data = item;
        temp.left = temp.right = null;
        return temp;
    }

    static int findDepth(Node root, int x) {

        if (root == null)
            return -1;

        int dist = -1;

        if ((root.data == x) ||

                (dist = findDepth(root.left, x)) >= 0 ||
                (dist = findDepth(root.right, x)) >= 0)

            return dist + 1;
        return dist;
    }


    static int findHeightUtil(Node root, int x) {


        if (root == null) {
            return -1;
        }

        int leftHeight = findHeightUtil(root.left, x);
        int rightHeight = findHeightUtil(root.right, x);
        int ans = Math.max(leftHeight, rightHeight) + 1;

        if (root.data == x)
            height = ans;

        return ans;
    }

    static int findHeight(Node root, int x) {
        findHeightUtil(root, x);
        return height;
    }

    public static void main(String[] args) {

        Node root = newNode(5);
        root.left = newNode(10);
        root.right = newNode(15);
        root.left.left = newNode(20);
        root.left.right = newNode(25);
        root.left.right.right = newNode(45);
        root.right.left = newNode(30);
        root.right.right = newNode(35);

        int k = 25;
        System.out.println("Depth: " + findDepth(root, k));
        System.out.println("Height: " + findHeight(root, k));
    }
}
