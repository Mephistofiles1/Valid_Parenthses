import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "({[{}})";
        Solution solution = new Solution();

        System.out.println(solution.isValid(s));
    }
}

class Solution {
    public boolean isValid(String s) {
        char[] proverk = new char[s.length()];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                proverk[++top] = c;
            } else if (c == ')' && top >= 0 && proverk[top] == '(') {
                --top;
            } else if (c == '}' && top >= 0 && proverk[top] == '{') {
                --top;
            } else if (c == ']' && top >= 0 && proverk[top] == '[') {
                --top;
            } else {
                return false;
            }
        }
        return top == -1;
    }
}