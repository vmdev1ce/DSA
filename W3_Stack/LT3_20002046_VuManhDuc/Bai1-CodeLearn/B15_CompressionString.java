import java.util.*;
public class B15_CompressionString {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Stack<Character> st = new Stack<>();

            String input = sc.nextLine();
            input += "!";
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                if (st.isEmpty() || input.charAt(i) == st.peek()) {
                    st.push(input.charAt(i));
                } else {
                    int cnt = 0;
                    output.append(st.peek());
                    while (!st.isEmpty()) {
                        cnt++;
                        st.pop();
                    }
                    output.append(cnt);
                    st.push(input.charAt(i));
                }
            }
            System.out.print(output);
        }
    }
}