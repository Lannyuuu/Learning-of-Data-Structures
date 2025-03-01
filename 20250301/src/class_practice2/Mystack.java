package class_practice2;

import java.util.*;

public class Mystack {
    //用队列实现栈
    //一个队列实现不了栈
    //用两个队列：
    //放不为空的队列
    //出不为空的队列
    public Queue<Integer> qu1;
    public Queue<Integer> qu2;

    public Mystack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    public void push(int x) {
        qu2.offer(x);
        while(!qu1.isEmpty()){
            qu2.offer(qu1.poll());
        }
        Queue<Integer> tmp = qu1;
        qu1 = qu2;
        qu2 = tmp;
    }

    public int pop() {
        return qu1.poll();
    }

    public int top() {
        return qu1.peek();
    }

    public boolean empty() {
        return qu1.isEmpty() && qu2.isEmpty();
    }
}
