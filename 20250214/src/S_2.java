//写一个泛型类，求一个泛型数组中的最大值
class Alg<T>{
    public T findMax(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            //< 运算符只能用于基本数据类型（如 int、double 等），
            // 不能用于引用类型（如 Integer、String 等）。
            /*if(max < array[i]){   泛型参数代表的都是引用类型
                max = array[i];
            }*/
            //为了比较引用类型的对象，需要使用 Comparable 接口或 Comparator 接口。
        }
        return max;
    }
}
/*T extends Comparable<T>：
限制 T 必须是实现了 Comparable 接口的类型*/
class Alg1<T extends Comparable<T>> {
    public T findMax(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) { // 使用 compareTo 方法
                max = array[i];
            }
        }
        return max;
    }
}
public class S_2 {
    // 定义一个泛型方法（静态）：可以输出任何类型的数组
    //如果要比较（引用类型）：Comparable接口
    //public static <T extends Comparable<T>> T findMax(T[] array)
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"Hello", "World"};

        // 调用泛型方法
        printArray(intArray); // 输出: 1 2 3 4 5
        printArray(strArray); // 输出: Hello World
    }
}
