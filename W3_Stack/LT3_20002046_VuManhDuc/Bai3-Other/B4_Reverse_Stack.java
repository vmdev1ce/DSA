import java.util.Stack;

public class B4_Reverse_Stack {

    public void reverse(Stack<Integer> stack){

        if(stack.isEmpty()==false){

            int x = stack.pop();
            reverse(stack);

            insert_at_bottom(stack, x);
        }
    }

    public void insert_at_bottom(Stack<Integer> stack, int x){

        if(stack.isEmpty()){
            stack.push(x);
            return;
        }

        int y = stack.pop();
        insert_at_bottom(stack, x);

        stack.push(y);
    }

    public static void main(String[] args) {
        Stack<Integer> originalStack = new Stack<>();
        originalStack.push(8);
        originalStack.push(9);
        originalStack.push(202);
        originalStack.push(2);
        originalStack.push(7);

        System.out.println("Original Stack: " + originalStack);

        B4_Reverse_Stack r = new B4_Reverse_Stack();
        r.reverse(originalStack);

        System.out.println("Reversed Stack: " + originalStack);
    }
}