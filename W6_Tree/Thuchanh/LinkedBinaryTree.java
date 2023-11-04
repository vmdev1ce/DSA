public class LinkedBinaryTree<E, T> implements BinaryTreeInterface<T> {
    protected static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
        public char[] getElement;

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }
    }

    private Node<E> root;
    private int size;

    public Node<E> addRoot(E element) {
        root = new Node<E>(element, null, null, null);
        size++;
        return root;
    }

    public Node<E> addLeft(Node<E> p, E element) {
        Node<E> leftChild = new Node<E>(element, p, null, null);
        p.left = leftChild;
        size++;
        return leftChild;
    }

    public Node<E> addRight(Node<E> p, E element) {
        Node<E> rightChild = new Node<E>(element, p, null, null);
        p.right = rightChild;
        size++;
        return rightChild;
    }

    public void set(Node<E> p, E element) {
        p.element = element;
    }

    @Override
    public T root() {
        return (T) root.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int numChildren(T p) {
        Node<E> node = (Node<E>) p;
        int children = 0;
        if (node.left != null) {
            children++;
        }
        if (node.right != null) {
            children++;
        }
        return children;
    }

    @Override
    public T parent(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.parent.element;
    }

    @Override
    public T left(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.left.element;
    }

    @Override
    public T right(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.right.element;
    }

    @Override
    public T sibling(T p) {
        Node<E> node = (Node<E>) p;

        if (node.parent == null) {
            return null;
        }

        if (node.parent.left == node) {
            if (node.parent.right == null) {
                return null; 
            }
            return (T) node.parent.right.element;
        } else {
            if (node.parent.left == null) {
                return null; 
            }
            return (T) node.parent.left.element;
        }
    }

}
