package LinkedList.demo;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList mySingleList = new LinkedList();
        mySingleList.insertAtTail(12);
        mySingleList.insertAtTail(23);
        mySingleList.insertAtTail(34);
        mySingleList.insertAtTail(45);
        mySingleList.insertAtTail(56);
        mySingleList.display();
        System.out.println("链表的大小是:"+mySingleList.size());
        mySingleList.addIndex(2,89);
        mySingleList.display();
        mySingleList.remove(89);
        mySingleList.display();
        mySingleList.insertAtTail(56);
        mySingleList.display();
        mySingleList.removeAllKey(56);
        mySingleList.display();
        /*mySingleList.clear();
        mySingleList.display();*/
        mySingleList.reverseList();
        mySingleList.display();
        mySingleList.show(1);
        System.out.println(mySingleList.reverseK2(2));

    }
}
