/*1.装箱拆箱
 * 2.包装类
 * 3.泛型：泛型只存在于编译过程，运行的时候没有泛型的概念（擦除机制）*/
class MyArray {  //正常定义一个类
    public Object[] array = new Object[10];
    public Object getPos(int pos) {
        return this.array[pos];
    }
    public void setVal(int pos,Object val) {
        this.array[pos] = val;
    }
}
//<T>表示一个占位符：当前类是一个泛型类
//T是Object类型的子类。
//向上转型(T类型转换成Object)
//向下转型(Object类型转化成T) -- >强制转化(T)
class MyArray1<T> {  //泛型类
    //定义一个Object[]类型的数组
    public Object[] array = new Object[10];
    //getPos和setVal
    public T getPos(int pos) {  //把所有Object类型都换成T,这里返回值类型是T
        return (T)this.array[pos];  //获取数组中指定位置 pos 的元素。
        //由于 array 是 Object[] 类型，而返回值是 T 类型，因此需要进行强制类型转换 (T)。
    }
    public void setVal(int pos,T val) {
        /*直接将 val 存储到 array[pos] 中。由于 array
        是 Object[] 类型，而 T 是 Object 的子类，因此可以直接赋值。*/
        this.array[pos] = val; //设置数组中元素的值
    }
}
public class S_1 {
    public static void main(String[] args) {
        //T -> Integer
        //泛型只能接受类，所有的基本数据类型必须使用包装类
        // 这里只能写<Integer>不能写<int>
        MyArray1<Integer> myArray1 = new MyArray1<>();//1  后面的<>可以不写东西
        myArray1.setVal(0,10);
        myArray1.setVal(1,12);
        int ret = myArray1.getPos(1);  //12
        System.out.println(ret);
        //要求只能是Integer类，“bit”不符合，报错
        //myArray1.setVal(2,"bit");//3
    }
    public static void main3(String[] args) {
        /*1. 任何类型数据都可以存放
          2. 1号下标本身就是字符串，但是确编译报错。必须进行强制类型转换*/
        MyArray myArray = new MyArray();
        myArray.setVal(0,10);
        myArray.setVal(1,"hello");//字符串也可以存放
        String ret = (String)myArray.getPos(1);//编译报错:Object类型要强制转换成String类型
        System.out.println(ret);
    }
    public static void main2(String[] args) {
        //注意：Integer.ValueOf():要求比128小的数
        Integer a = 127; //装箱操作
        Integer b = 127;
        System.out.println(a == b); //true

        Integer aa = 128;
        Integer bb = 128;
        System.out.println(aa == bb); //false
        /*Java 对 Integer 类提供了一个缓存池，默认缓存了
        -128 到 127 之间的整数。当使用 Integer.valueOf()
        方法创建 Integer 对象时，如果值在缓存范围内，会直接返
        回缓存中的对象；如果超出范围，则会创建一个新的 Integer 对象。*/

    }
    public static void main1(String[] args) {
        //装箱：
        //自动装箱:看不见装箱过程
        Integer a = 10;
        int i = 11;
        Integer b = i;
        //显式装箱
        Integer c = Integer.valueOf(18);
        //拆箱：
        int m = a;
        int m1 = (int)a;
    }
}
