package medium;

import java.util.Stack;

public class EvaluateRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        //Stack<char> opr = new Stack<>();
        for (int i=0; i<tokens.length; i++){
            if (tokens[i].equals("+")){
                int temp1 = nums.pop();
                int temp2 = nums.pop();
                int tmp = temp1 + temp2;
                nums.push(tmp);
            }else if(tokens[i].equals("-")){
                int temp1 = nums.pop();
                int temp2 = nums.pop();
                int tmp = temp1 - temp2;
                nums.push(tmp);
            }else if(tokens[i].equals("*")){
                int temp1 = nums.pop();
                int temp2 = nums.pop();
                int tmp = temp1 * temp2;
                nums.push(tmp);
            }else if(tokens[i].equals("/")){
                int temp2 = nums.pop();
                int temp1 = nums.pop();
                int tmp = temp1 / temp2;
                nums.push(tmp);
            }else{
                nums.push(Integer.parseInt(tokens[i]));
            }
        }
        return nums.pop();
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"4","13","5","/","+"};
        EvaluateRPN evaluateRPN = new EvaluateRPN();
        evaluateRPN.evalRPN(tokens);
    }
}
