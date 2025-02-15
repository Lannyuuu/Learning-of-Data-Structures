package demolist;
//代码实现单链表：
public class MySingleList {
    //成员变量：节点类+头节点
    //1.定义节点类：
    private static class Node {
        int data;
        Node next; //注意这里表示指针域直接用Node表示
        //构造方法：
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    //2.头节点
    public Node head; //head是Node类的变量，作为MySingleList类的成员变量，有data和next两个成员变量

    // 头插法
    //把这个节点插入到头节点的前面作为新的头节点
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    // 尾插法
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    //成员方法：打印链表
    //1..打印链表：
    public void display(){
        Node cur = head; //cur是一个Node类的变量，包含data和next两个成员变量
        while(cur != null){
            System.out.print(cur.data + " ->");
            cur = cur.next; //注意：这里不能用head.next来实现，head永远指的都是头节点
        }
        System.out.println("null");
    }

}
