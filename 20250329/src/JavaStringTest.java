public class JavaStringTest {
    public static void main(String[] args) {
        //字符串的创建:
        //方法1：直接创建
        String str1 = "abcdef";
        //方法2：new关键字创建
        String str2 = new String("hijklmn");
        System.out.println(str1);
        System.out.println(str2);
        //字符串的使用：
        //1.基本信息与访问
        System.out.println(str1.length()); //length()：字符串长度
        System.out.println(str1.charAt(2));//charAt()：指定下标的元素
        System.out.println(str1.isEmpty());//isEmpty()：判断是不是空字符串
        //2.子串与查找
        String str3 = "bc";
        System.out.println(str1.substring(2, 4));
        System.out.println(str1.indexOf(str3));//indexOf():子串第一次出现的下标
        //3.比较与转换
        System.out.println(str1.equals(str3));
        System.out.println(str1.compareTo(str2));
        System.out.println(str2.toUpperCase());
        System.out.println(str2.toCharArray());
        //字符串与其他类型的转换
        //字符串->基本类型 : parse
        int num = Integer.parseInt("123");
        double d = Double.parseDouble("3.14");
        //基本类型->字符串 :
        //String.valueOf/Integer.toString
        String s1 = String.valueOf(123);
        String s2 = Integer.toString(456);
        //遍历字符串
        //方法1：
        for (int i = 0; i < str1.length();i++){
            System.out.print(str1.charAt(i)+" ");
        }
        System.out.println();
        //方法2：
        for (char c : str2.toCharArray()){
            System.out.print(c + " ");
        }
    }
}
