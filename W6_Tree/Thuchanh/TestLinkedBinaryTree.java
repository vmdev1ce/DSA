public class TestLinkedBinaryTree {
    public static void main(String[] args) {
        LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> binaryTree = new LinkedBinaryTree<>();

        LinkedBinaryTree.Node<Integer> root = binaryTree.addRoot(1);
        LinkedBinaryTree.Node<Integer> leftChild = binaryTree.addLeft(root, 3);
        LinkedBinaryTree.Node<Integer> rightChild = binaryTree.addRight(root, 5);

        LinkedBinaryTree.Node<Integer> leftChild3 = binaryTree.addLeft(leftChild, 2);
        LinkedBinaryTree.Node<Integer> rightChild3 = binaryTree.addRight(leftChild, 7);

        LinkedBinaryTree.Node<Integer> leftChild5 = binaryTree.addLeft(rightChild, 6);
        LinkedBinaryTree.Node<Integer> rightChild5 = binaryTree.addRight(rightChild, 8);


        System.out.println("Root is 1: " + binaryTree.root());

        System.out.println("Size is 7 " + binaryTree.size());

        System.out.println("Empty is fale" + binaryTree.isEmpty());

        System.out.println("Root has 2 children: " + binaryTree.numChildren(root));

        System.out.println("Parent of 3 is 1: " + binaryTree.parent(leftChild));
        System.out.println("Parent of 5 is 1: " + binaryTree.parent(rightChild));
        System.out.println("Root's left child is leftChild: " + binaryTree.left(root));
        System.out.println("Root's right child is rightChild: " + binaryTree.right(root));

        System.out.println("sibling of 3 is 5: " + binaryTree.sibling(leftChild));
        System.out.println("Right child's sibling is leftChild: " + binaryTree.sibling(rightChild));
    }
}
