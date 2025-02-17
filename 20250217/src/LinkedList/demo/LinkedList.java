package LinkedList.demo;

public class LinkedList {
    Node head;

    public LinkedList(){
        this.head = null;
    }
    //头插法： 在头部插入节点
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        //newNode的next地址指向head头节点
        newNode.next = head;
        //让新的head编程newNode(head的前一个节点)
        head = newNode;
    }

    //尾插法： 在尾部插入节点
    public void insertAtTail(int data) {
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

    //中间插入： 在指定节点后插入节点
    //需要知道index位置的前一个节点preNode
    public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("Previous node cannot be null.");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }
    public int size(){
        int count = 0;
        Node cur = head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    public void addIndex(int index,int val){
        //index不合法
        if(index < 0 || index > size()){
            return;
        }
        //头插法
        if (index == 0){
            insertAtHead(val);
            return;
        }
        //尾插法
        if (index == size()){
            insertAtTail(val);
            return;
        }
        //中间插入
        Node preNode = findIndex(index);
        Node node = new Node(val);
        node.next = preNode.next;//新节点 node 的 next 指针（引用）指向 preNode 的下一个节点
        preNode.next = node;//将 preNode 的 next 指针（引用）指向新节点 node
    }
    //找到index前一个节点
    public Node findIndex(int index){
        Node preNode = head;
        int count = 0;
        while(count != index-1){
            preNode = preNode.next;
            count++;
        }
        return preNode;
    }
    //打印链表：
    public void display(){
        Node cur = head; //cur是一个Node类的变量，包含data和next两个成员变量
        while(cur != null){
            System.out.print(cur.data + " ->");
            cur = cur.next; //注意：这里不能用head.next来实现，head永远指的都是头节点
        }
        System.out.println("null");
    }
    //从指定位置开始打印
    public void show(int index){
        Node cur = findIndex(index+1);
        while(cur != null){
            System.out.print(cur.data + "-> ");
            cur = cur.next;
        }
        System.out.println("null");
    }
    //删除节点：第一个出现的关键字key
    //注意：要是方法的参数是val/index/data需要找到该节点的前一个节点，要另写一个方法来找
    public void remove(int key){
        //cur要走到删除节点的前一个位置
        //if(cur.next.data == key)
        if (head == null) {
            return;
        }
        if (head.data == key){
            head = head.next;
            return;
        }
        Node preNode = findKey(key);
        if (preNode == null){
            System.out.println("没有你要删除的Key");
            return;
        }
        Node delNode = preNode.next;
        preNode.next = delNode.next;
        //或：preNode.next = preNode.next.next
        //找到删除节点的前一个节点之后：实现删除
        //preNode.next = cur.next

    }
    public Node findKey(int key){ //找到要删除的节点的前一个节点
        Node preNode = head;
        while(preNode.next != null){
            if(preNode.next.data == key){
                return preNode;
            }
            preNode = preNode.next;
        }
        //没找到返回null
        return null;

    }
    public void removeAllKey(int key){
        //删除所有的关键词Key
        //要求：只遍历列表一遍
        Node preNode = head;
        Node curNode = head.next;
        while(curNode != null){ //注意：curNode != null 循环不包含头节点，最后要考虑头节点
            if (curNode.data == key){
                preNode.next = curNode.next;
                curNode = curNode.next;
            }else{
                preNode = curNode;
                curNode = curNode.next;
            }
        }
        if (head.data == key){
            head = head.next;
        }
    }
    public void clear(){
        Node curNode = head;
        while(curNode != null){
            Node nodeN = null;//定义一个空节点
            curNode.next = null;
            curNode = nodeN;//让当前节点等于这个空节点
        }
        head = null;
    }
    //链表的反转：链表整个结构的反转
    //head 变成 Tail了
    //其余节点一个一个头插到head（刷新）前面
    public Node reverseList() {
        //头插法：
        //空链表：
        if (head == null) {
            return head;
        }
        //head -> curNode -> curNodeNext
        //1.curNode -> head
        //2.curNode作为新的head
        //3.curNode刷新成下一个节点，再插入前面
        Node curNode = head.next;
        head.next = null; //头节点转换成尾节点：head.next = null
        while (curNode != null) {
            Node curNodeNext = curNode.next;
            curNode.next = head; //把curNode放在head前面，指向head
            head = curNode; //curNode作为新的head
            curNode = curNodeNext;
        }
        return head;//head可以直接指代整个链表
    }
    //需要遍历两次
    public Node findMiddleNode(){ //Node类型作为返回值
        if (head == null){
            return null;
        }
        int len = size();
        int count = 0;
        Node cur = head;
        while(count != len/2){
            cur = cur.next;
            count++;
        }
        return cur;
    }
    //只遍历一次：
    //fast,slow
    public Node findMiddleNode1(){
        Node fast= head;
        Node slow = head;
        //fast每次走两步:一定先走到尾节点
        //slow每次走一步
        //当走到fase == null 或 fast.next == null
        //slow就是中间Node
        if (head ==null){
            return null;
        }
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //返回倒数第k个节点
    //k的合法性：
    //k<=0 || k>size()
    public int reverseK( int k){
        if( k <= 0 || k > size() ){
            return -1;
        }
        int len = size();
        int count = 0;
        Node curNode = head;
        while(curNode != null){
            curNode = curNode.next;
            count ++;
            if (count == len-k){
                return curNode.data;
            }
        }
        return -1;
    }
    public int reverseK2(int k){
        Node fast = head;
        Node slow = head;
        if( k <= 0 || k > size() ){
            return -1;
        }
        int count =k-1;
        while (count != 0){
            fast = fast.next;
            count --;
        }
        while(fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.data;
    }
}

