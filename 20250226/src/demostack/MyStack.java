package demostack;

public class MyStack {
    public int[] elem;
    public int usedSize;

    public MyStack(){
        elem = new int[10];
    }
    public void push(int val){
        //1.满了进行扩容
        if (isFull()){
            expendCapacity();
        }
        //2.才可以入栈
        elem[usedSize] = val;
        //3.us++
        usedSize ++;
    }
    public boolean isFull(){
        return usedSize == elem.length;
    }
    public void expendCapacity(){
        int[] newElem = new int[elem.length * 2];

        System.arraycopy(elem,0,newElem,0,usedSize);

        elem = newElem;
    }
}
