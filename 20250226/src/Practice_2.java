import java.util.Stack;
//逆波兰表达式求值
public class Practice_2 {
    //String[] token = {"2","1","+","3","*"};
    /*public int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String tmp = tokens[i];
            if (!isOperations(tmp)){
                stack.push(Integer.parseInt(tmp));
            }else{
                int v1 = stack.pop();
                int v2 = stack.pop();
                switch(tmp){
                    case "+":
                        stack.push(v1+v2);
                        break;
                    case "-":
                        stack.push(v1 -v1);
                        break;
                    case "*":
                        stack.push(v1 *v2);
                        break;
                    case "/":
                        stack.push(v1/v1);
                        break;
                }
            }
        }
        return stack.pop();
    }
    private boolean isOperations(String tmp){
        if (tmp.equals("+") || tmp.equals("-") ||
        tmp.equals("*") || tmp.equals("/")){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Practice_2 practice2 = new Practice_2();
        String[] token = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(practice2.evalRPN(token));
    }*/
    public int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens){
            if (isOperator(token)){
                int v1 = stack.pop();
                int v2 = stack.pop();
                int result = calculate(v2,v1,token);
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    public boolean isOperator(String token){
        return token.equals("+") || token.equals("-")||token.equals("*")
                ||token.equals("/");
    }
    public int calculate(int v1, int v2, String token){
        switch(token){
            case "+":
                return v1 + v2;//要是写了return就不用写break了
            case "-":
                return v1 - v2;
            case "*":
                return v1 *v2;
            case "/":
                return v1 / v2;
            default:
                throw new IllegalArgumentException("无效的操作符: " + token);
        }
    }
    public static void main(String[] args) {
        Practice_2 practice2 = new Practice_2();
        String[] token = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(practice2.evalRPN(token));
    }
}
