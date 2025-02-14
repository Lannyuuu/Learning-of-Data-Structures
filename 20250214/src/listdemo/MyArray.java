package listdemo;

import java.util.Arrays;

//ArrayList代码练习：

//插入IList接口要重写接口里面的所有抽象方法
public class MyArray implements IList{
    public int[] elem;
    public int usesize; //有效的数据个数

    public MyArray(){ //构造方法
        this.elem = new int[10];
    }

    @Override
    public boolean isFull() {
        //当usesize(有效数据个数)和elem.length(数组长度)大小相等的时候满了
        return usesize == elem.length;
    }

    @Override
    //默认把data放在当前有效数据的最后一个位置
    public void add(int data) {
        //如果已经满了需要扩容
        if(isFull()){
            resize();
        }
        elem[usesize] = data;
        usesize++;
    }

    //扩容方法：
    private void resize(){
        //Syntax : Arrays.copyOf(original,newlength)
        elem = Arrays.copyOf(elem,2*elem.length);
        /*如果 newLength 大于原始数组长度，新数组的多余部分会用默认值填充：
        对象类型数组：null
        基本数据类型数组：0、false 等。*/
    }
    @Override
    //把data放在pos位置
    public void add(int pos, int data) {
        //(0)满了要扩容+pos不合法(a.pos小于0;b.pos定在了有效位之外)
        if(pos < 0 || pos > usesize){
            System.out.println("这不对吧");
        }
        //(1)数据的挪动：
        //1.找到pos位置的值，把这个值以及后面的值整体往后挪
        //2.从最后的有效数开始挪 elem[i+1] = elem[i];i--
        //3.当 i<pos 时结束
        for (int i = usesize-1; i >= pos ; i--) {
            elem[i+1] = elem[i];
        }
        //(2)存放数据
        elem[pos] = data;
        usesize++;
    }

    @Override
    public boolean isEmpty() {
        return usesize == 0;
    }

    @Override
    //判断数组中是否有toFind值
    public boolean contains(int toFind) {
        //可以不写
        /*if (isEmpty()){
            return false;
        }*/
        //遍历数组
        for (int i = 0; i < usesize; i++) {
            if (toFind == elem[i]){
                return true;
            }
        }
        return false;
    }

    @Override
    //找到数组中toFind值的下标，返回下标，要是不存在在数组中就返回0
    public int indexOf(int toFind) {
        for (int i = 0; i < usesize; i++) {
            if (elem[i] == toFind){
                return i;
            }
            //注意：equals来判断引用类型是否相等
        }
        return 0;
    }

    @Override
    public int get(int pos) {
        if (pos < 0 || pos >= usesize){
            System.out.println("pos不太对捏");
        }
        if (isEmpty()){
            return -1;
        }
        return elem[pos];
    }

    @Override
    //更新--要求pos位置必须时有效的位置
    public void set(int pos, int value) {
        if (isEmpty()){
            System.out.println("空了");
        }
        //注意：usesize是有效的数据个数
        //usesize作为下标的时候是最后一个有效数的后面一个位置(空)
        if (pos < 0 || pos >= usesize){
            System.out.println("这不对吧");
        }
        elem[pos] = value;
    }

    @Override
    public void remove(int toRemove) {
        //1.找到pos的位置
        //2.删除之后把elem[i] = elem[i+1]
        int index = indexOf(toRemove);
        if (index == -1){
            return;
        }
        //挪动元素,从后往前挪
        for (int i = index; i < usesize-1; i++) {
            elem[i] = elem[i+1];
        }
        usesize--;
    }

    @Override
    //返回数组的有效大小
    public int size() {
        return this.usesize;
    }

    @Override
    public void clear() {
        //基本数据类型：
        usesize = 0;
        //引用类型：遍历，使每个元素为null
        /*for (int i = 0; i < usesize; i++) {
            elem[i] = null;
        }*/
    }

    @Override
    public void display() {
        for (int i = 0; i < usesize; i++) {
            System.out.print(elem[i] + " ");
        }
        System.out.println();//回车
    }

    @Override
    public void removeAllValue(int value) {
        if (isEmpty()){
            System.out.println("空了");
        }
        for (int i = 0; i < usesize; i++) {
            if (elem[i] == value){
                for (int j = i; j < usesize -1; j++) {
                    elem[j] = elem[j+1];
                }
                usesize--;
            }
        }
    }
}
