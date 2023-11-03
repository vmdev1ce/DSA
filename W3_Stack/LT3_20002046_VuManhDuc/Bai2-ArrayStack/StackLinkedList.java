class StackLinkedList<E>{
    class Node{
        E element;
        Node next;
    }
    private Node stack;


    public void push(E element){
        Node temp = new Node();
        temp.element = element;
        temp.next = stack;
        stack = temp;
    }

    public E pop(){
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        E element = stack.element;
        stack = stack.next;
        return element;
    }

    public boolean isEmpty(){
        return stack == null;
    }

    public static void main(String[] args) {
        StackLinkedList<Integer> stack1 = new StackLinkedList<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        while (stack1.isEmpty() == false){
            System.out.println(stack1.pop());
        }
    }
}