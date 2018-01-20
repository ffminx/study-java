package zh.ffminx.study.java.collection;

import java.util.Stack;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2018-01-18 22:37
 */
public class StackTest {
    
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    //    public void push(int node) {
    //        stack1.push(node);
    //    }
    //
    //    public int pop() {
    //        int result;
    //        int stack1Size = stack1.size();
    //        for (int i = 0; i < stack1Size - 1; i++) {
    //            stack2.push(stack1.pop());
    //        }
    //        int stack2Size = stack2.size();
    //        result = stack1.pop();
    //        for (int i = 0; i < stack2Size; i++) {
    //            stack1.push(stack2.pop());
    //        }
    //        return result;
    //    }
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    public static void main(String[] args) {
        StackTest test = new StackTest();
        test.push(1);
        test.push(2);
        test.push(3);
        System.out.println(test.pop());
        System.out.println(test.pop());
        test.push(4);
        System.out.println(test.pop());
        test.push(5);
        System.out.println(test.pop());
        System.out.println(test.pop());
    }
}
