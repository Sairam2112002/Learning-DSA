package stack;

public class ValidParentheses {
    int length;
    char[] stack;
    int top;

    void push(char element) {
        top += 1;
        stack[top] = element;
    }
    void pop() {
        top -= 1;
    }

    char peek() {
        if(top == -1) {
            return '@';
        }
        return stack[top];
    }
    public boolean isValid(String s) {
        length = s.length();
        stack = new char[length];
        top = -1;
        if(s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']') {
            return false;
        }
        for(int i = 0; i < length; i++) {
            char current = s.charAt(i);
            if(current == '(' || current == '{' || current == '[') {
                push(current);
            } else if((current == ')' && peek() == '(') || (current == '}' && peek() == '{') || (current == ']' && peek() == '[')) {
                if(peek() == '@') {
                    return false;
                } else {
                    pop();
                }
            } else {
                return false;
            }
        }
        return top == -1;
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("(){}}{"));
    }
}
