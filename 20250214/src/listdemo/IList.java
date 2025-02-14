package listdemo;

//接口里面的抽象方法不写方法体
public interface IList {   //接口里面默认是public abstract，通常不写
    // 新增元素,默认在数组最后新增
    void add(int data);
    // 在 pos 位置新增元素
    void add(int pos, int data);
    // 判定是否包含某个元素
    boolean contains(int toFind);
    // 查找某个元素对应的位置
    int indexOf(int toFind);
    // 获取 pos 位置的元素
    int get(int pos);
    // 给 pos 位置的元素设为 value
    void set(int pos, int value);
    //删除第一次出现的关键字key
    void remove(int toRemove);
    // 获取顺序表长度
    int size();
    // 清空顺序表
    void clear();
    // 打印顺序表，注意：该方法并不是顺序表中的方法，为了方便看测试结果给出的
    void display();
    //判断数组是否已经满了
    boolean isFull();
    boolean isEmpty();
    void removeAllValue(int value);
}
