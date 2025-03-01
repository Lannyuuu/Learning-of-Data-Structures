package CircularQueue;

public class MyCircularQueue2 {
    public int[] elem; //数组
    public int front; //队头指针
    public int rear; //队尾指针
    //使用标记flg判断满了还是空的
    private boolean flg;

    public MyCircularQueue2(int k) {
        elem = new int[k];
        front = 0;
        rear = 0;
        flg = false;
    }

    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        elem[rear] = value;
        flg = true;
        rear = (rear+1)%elem.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        front = (front+1) %elem.length;
        flg = false;
        return true;
    }

    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return elem[front];
    }

    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        int index = (rear==0) ? elem.length-1 : rear-1;
        return elem[index];
    }

    public boolean isEmpty() {
        if (front == rear && flg == false){
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (front == rear && flg == true){
            return true;
        }
        return false;
    }
}
