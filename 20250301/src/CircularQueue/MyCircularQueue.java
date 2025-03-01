package CircularQueue;

public class MyCircularQueue {
    public int[] elem; //数组
    public int front; //队头指针
    public int rear; //队尾指针
    public int usedSize; //当前队列中元素数量

    public MyCircularQueue(int k) {
        elem = new int[k];
        front = 0;
        rear = 0;
        usedSize = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        elem[rear] = value;
        rear = (rear+1) % elem.length;
        usedSize++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front+1) % elem.length;
        usedSize--;
        return true;
    }

    public int Front() {
        if (usedSize == 0){
            return -1;
        }
        return elem[front];
    }

    public int Rear() {
        if (usedSize == 0){
            return -1;
        }
        // 队尾指针的前一个位置是队尾元素
        int index = (rear == 0) ? elem.length -1: rear-1;
        return elem[index];
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    public boolean isFull() {
        return usedSize == elem.length;
    }
}
