package medium;

import java.util.Stack;


/**
 * Leetcode:1209
 * */
public class RemoveAdjacentDuplicates {
    public String removeDuplicates(String s, int k) {
        if (s.length() < k){
            return s;
        }
        Stack<Integer> countStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            sb.append(s.charAt(i));
            int lastIndex = sb.length()-1;
            if (lastIndex>0 && sb.charAt(lastIndex-1) == sb.charAt(lastIndex)){
                int count = countStack.pop();
                if (count + 1 < k){
                    countStack.push(count + 1);
                }
                else {
                    sb.setLength(sb.length() - k);
                }
            }else {
                countStack.push(1);
            }
        }
        return sb.toString();
    }


}
