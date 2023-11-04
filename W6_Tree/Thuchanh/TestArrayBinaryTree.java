public class TestArrayBinaryTree {
    public static void main(String[] args) {
        ArrayBinaryTree<Integer, Integer> b1 = new ArrayBinaryTree<>();
        b1.setRoot(1);
        b1.setLeft(0, 3);
        b1.setRight(0, 5);

        b1.setLeft(1, 2);
        b1.setRight(1, 7);

        b1.setLeft(2, 6);
        b1.setRight(2, 8);

        System.out.println(b1.root());
        System.out.println(b1.size());
        System.out.println(b1.isEmpty());
        System.out.println(b1.numChildren(1));
        System.out.println(b1.parent(3));
        System.out.println(b1.left(1));
        System.out.println(b1.right(1));
        System.out.println(b1.sibling(2));

    }
}
