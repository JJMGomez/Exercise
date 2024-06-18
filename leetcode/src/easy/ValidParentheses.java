package easy;

import java.util.Stack;
/**
 * Leetcode 20
 * */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] input = s.toCharArray();
        for (int i=0; i<input.length; i++){
            if (input[i]=='('
                    || input[i]=='['
                    || input[i]=='{'){
                stack.push(input[i]);
                continue;
            }else if(input[i]==')'){
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                    continue;
                }
            }else if(input[i]==']'){
                if (!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                    continue;
                }
            }else if(input[i]=='}'){
                if (!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                    continue;
                }
            }
            return false;
        }
        return stack.isEmpty();
    }
}
