package CircularQueue;

public class MyCircularQueue3 {
    //浪费一个空间
    public int[] elem;
    public int front;
    public int rear;

    public MyCircularQueue3(int k) {
        elem = new int[k+1];
        front = 0;
        rear = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        elem[rear] = value;
        rear = (rear+1) %elem.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        front = (front +1)% elem.length;
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
        int index = (rear == 0) ? elem.length-1 : rear-1;
        return elem[index];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear+1) %elem.length == front;
    }
}
