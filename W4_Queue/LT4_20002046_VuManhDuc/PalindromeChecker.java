import java.util.*;

class PalindromeChecker {
    static class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
            next = null;
        }
    }

    static class Stack {
        Node top;

        public void push(char data) {
            Node new_node = new Node(data);
            new_node.next = top;
            top = new_node;
        }

        public char pop() {
            if (top == null) {
                return ' ';
            }
            char popped = top.data;
            top = top.next;
            return popped;
        }

        public char peek() {
            if (top == null) {
                return ' ';
            }
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    static class Queue {
        char[] arr;
        int front, rear;

        public Queue(int size) {
            arr = new char[size];
            front = rear = -1;
        }

        public void enqueue(char data) {
            if (front == -1) {
                front = 0;
            }
            arr[++rear] = data;
        }

        public char dequeue() {
            if (front == -1 || front > rear) {
                return ' ';
            }
            return arr[front++];
        }

        public char peek() {
            if (front == -1 || front > rear) {
                return ' ';
            }
            return arr[front];
        }

        public boolean isEmpty() {
            return front == -1 || front > rear;
        }
    }

    public static boolean isPalindrome(String str) {
        int len = str.length();

        // Create a stack and queue to store characters
        Stack stack = new Stack();
        Queue queue = new Queue(len);


        // Push characters onto the stack and enqueue them in the queue
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            stack.push(c);
            queue.enqueue(c);
        }

        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (stack.pop() != queue.dequeue()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcba"));
    }
}