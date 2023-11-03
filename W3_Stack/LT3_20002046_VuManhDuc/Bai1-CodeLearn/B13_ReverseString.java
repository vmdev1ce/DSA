import java.util.Scanner;

class B13_ReverseString<E>{
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

    public static String reverseString (String str_input){
        B13_ReverseString<Character> str_output = new B13_ReverseString<>();
        char [] c = str_input.toCharArray();
        for (char c_i: c){
            str_output.push(c_i);
        }
        String str_output_results = "";
        while (str_output.isEmpty() == false){
            str_output_results += str_output.pop();
        }

        return str_output_results;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str_input = scanner.nextLine();
        scanner.close(); 
        System.out.println(reverseString(str_input));
    }
}