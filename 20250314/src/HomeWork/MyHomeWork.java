package HomeWork;
class HasStatic{
    private static int x = 100; //静态成员变量

    public static void main(String[] args) { //静态成员方法
        HasStatic hs1 = new HasStatic();
        HasStatic hs2 = new HasStatic();
        hs1.x++; //101
        hs2.x++; //102
        hs1.x++; //103
        //不属于实例化的变量，x是类的属性
        System.out.println("x=" +x); //x=103
    }
}
class Circle{
    private static int r;
    final double PI = 3.142;

    public Circle(int r){
        this.r = r;
    }

    public double Perimeter(){
        return 2 * PI * r;
    }

    public double Area(){
        return PI * r *r;
    }
}

public class MyHomeWork {
    public static void main2(String[] args) {
        Circle myCircle = new Circle(2);
        double perimeter = myCircle.Perimeter();
        double area = myCircle.Area();
        System.out.println("半径为2的圆的周长为：" + perimeter
                            + "\n面积为" + area);
    }
}
