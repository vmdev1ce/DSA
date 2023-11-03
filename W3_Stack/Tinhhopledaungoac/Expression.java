/* Viết chương trình kiểm tra tính hợp lệ về dấu ngoặc của 1 biểu thức.

Hoàn thành phương thức boolean isValidExpr(String expr), trong lớp Expression.java

Phương thức này trả về giá trị true nếu biểu thức là hợp lệ về dấu ngoặc và trả về false nếu biểu thức không hợp lệ về dấu ngoặc.

ví dụ: biểu thức:

a+b-c*(1+2) là hợp lệ về dấu ngoặc

a+b-c(a-2+3)) là không hợp lệ

a+b)-c(a+3)( là không hợp lệ

- Hướng dẫn:

> Dùng phương thức charAt() của Đối tượng String để tham chiếu đến từng ký tự trong chuỗi biểu thức expr.

>Dùng 1 stack để lưu các dấu mở ngoặc:

--- Nếu ký tự đọc được là dấu mở ngoặc '(' thì push vào stack

--- Nếu ký tự đọc được là dấu đóng ngoặc ')' thì pop 1 phần tử trong stack ra nếu stack chưa rỗng, nếu stack rỗng thì return false

--- Khi duyệt hết các ký tự trên biểu thức, nếu stack rỗng thì return true, ngược lại return false. */

import java.util.Stack;

public class Expression{
    
    public boolean isValidExpr(String expr)
    {
        Stack<Character> stack = new Stack<>();
        for (char i : expr.toCharArray()) {
            if (i == '(' || i == '[' || i == '{')
                stack.push(i);
            else if (i == ')' || i == ']' || i == '}') {
                if (stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if (i == '(' && top != ')' || i == '[' && top != ']' || i == '{' && top != '}')
                    return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args)
    {
        
        Expression expr = new Expression();
        String f = "a+b-c(3+a)";
        System.out.println(expr.isValidExpr(f));
        
    }
    
    
}