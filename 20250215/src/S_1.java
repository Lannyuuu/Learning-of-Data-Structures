//ArrayList的用法练习
import java.util.*;


public class S_1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(10);
        list.add(1);
        list.add(10);
        list.add(8);
        list.add(1,12);
        System.out.println(list);
        System.out.println(list.get(2));
        list.set(0,88);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.contains(12));
        //ArrayList的遍历
        //1.使用for循环：
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //2.使用增强for循环(for each)：
        for (int x : list) {
            System.out.println(x);
        }
        //3.使用迭代器：
        Iterator<Integer> iterator = list.iterator();
        //.hasNext():有下一个元素
        //.next():获得下一个元素
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //排序
        list.sort(Comparator.naturalOrder()); // 按自然顺序排序
        System.out.println(list);
        //子列表：
        System.out.println(list.subList(1,3));
    }
}
