package class_practice1;

public class Test_P {
    public static void main(String[] args) {
        int[] pushV = {1,2,3,4,5};
        int[] popV = {5,4,3,2,1};
        P_1 testp1 = new P_1();
        System.out.println(testp1.IsPopOrder(pushV, popV));
    }
}
