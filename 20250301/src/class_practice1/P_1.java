package class_practice1;

import java.util.Stack;

public class P_1 {
    //判断两个数组符不符合栈的压入和染出顺序
    public boolean IsPopOrder(int[] pushV, int[] popV){
        Stack<Integer> stack = new Stack<>(); //定义一个栈
        int popIndex = 0;
        if (pushV.length != popV.length) return false;
        for (int num : pushV){
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == popV[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

}
