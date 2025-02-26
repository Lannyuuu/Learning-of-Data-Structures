import java.util.Stack;

public class Practice_1 {
    //判断括号是否匹配：
    public boolean isValid(String s){
        //字符串遍历完成 && 栈为空 - 匹配
        Stack<Character> stack = new Stack<>();
        //字符串遍历
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //左括号push进栈里
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                //右括号前面根本没有左括号
                if (stack.empty()){
                    return false;
                }
                char top = stack.peek();
                if (top == '(' && c == ')' || top == '[' && c == ']'
                        || top == '{' && c == '}'){
                    stack.pop();
                }else{
                    return false;
                }
            }
            //右括号和栈顶的左括号进行匹配，匹配成功pop
            //数据结构：用栈来判断-后进先出
        }
        if (!stack.empty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Practice_1 practice = new Practice_1();
        String s1 = "{)}({[";
        String s2 = "(){}[]";
        System.out.println(practice.isValid(s1));
        System.out.println(practice.isValid(s2));
    }
}

