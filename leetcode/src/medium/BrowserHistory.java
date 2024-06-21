package medium;

import java.util.Stack;

/**
 * leetcode: 1472
 * */
public class BrowserHistory {
    Stack<String> stack1 = new Stack<>();
    Stack<String> stack2 = new Stack<>();

    public BrowserHistory(String homepage) {
        stack1.add(homepage);
    }

    public void visit(String url) {
        stack1.add(url);
        stack2 = new Stack<>();
    }

    public String back(int steps) {
        while (stack1.size()>1 && steps > 0){
            stack2.add(stack1.pop());
            steps--;
        }
        return stack1.peek();
    }

    public String forward(int steps) {
        while (stack2.size()>0 && steps > 0){
            stack1.add(stack2.pop());
            steps--;
        }
        return stack1.peek();
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));
    }
}
