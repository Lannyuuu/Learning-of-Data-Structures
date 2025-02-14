package listdemo;

public class Test {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.display();
        //myArray.add(-1,11);
        boolean ret1 =myArray.contains(2);
        System.out.println(ret1);
        int ret2 = myArray.indexOf(1);
        System.out.println(ret2);
        myArray.set(1,12);
        myArray.set(4,9);
        myArray.display();
        myArray.remove(0);
    }
}
