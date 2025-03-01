package class_practice1;

import java.util.Stack;

public class getMinStack {
    //定义两个栈：一个正常栈、一个最小栈
    //正常栈
    public Stack<Integer> stack;
    //最小栈
    public Stack<Integer> minstack;
    public getMinStack() { //构造方法
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minstack.isEmpty()){
            minstack.push(val);
        }else{
            if (val <= minstack.peek()){
                minstack.push(val);
            }
        }
    }

    public void pop() {
        //stack
        int stacktop = stack.pop();
        if (minstack.peek() == stacktop){
            minstack.pop();
        }
    }

    public int top() {
        return stack.pop();
    }

    public int getMin() {
        return stack.peek();
    }
}
