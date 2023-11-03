import java.util.Scanner;

public class  B14_ConvertNumberToBinary<E> {
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
    public static int conver(int positive_integer){
        B14_ConvertNumberToBinary<Integer> binary = new B14_ConvertNumberToBinary<>();
        while (positive_integer > 0){
            int quotient = positive_integer/2;
            int remainder = positive_integer % 2;
            binary.push(remainder);
            positive_integer = quotient;
        }
        String results = "";
        while (binary.isEmpty() == false){
            results += binary.pop();
        }
        return (int) Double.parseDouble(results);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer positive_integer = scanner.nextInt();
        scanner.close(); 
        System.out.println(conver(positive_integer));
    }
}
