package demostack;

import java.util.Stack;

//Stack：先进后出
public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        //将元素压入栈顶
        stack.push(12);
        stack.push(23);
        stack.push(34);
        stack.push(45);//最后一个进入，栈顶
        //移除并返回栈顶元素
        System.out.println(stack.peek());//获取栈顶元素但是不删除
        System.out.println(stack.pop());//删除栈顶元素并返回栈顶
        System.out.println(stack.peek());
    }
}
