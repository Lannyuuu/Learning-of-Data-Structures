package LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList();
        myLinkedList.insertAtTail(12);
        myLinkedList.insertAtTail(23);
        myLinkedList.insertAtTail(34);
        myLinkedList.insertAtTail(23);
        myLinkedList.insertAtTail(12);
        myLinkedList.display();
        boolean ret = myLinkedList.isPalindrome();
        System.out.println(ret);
    }
}
