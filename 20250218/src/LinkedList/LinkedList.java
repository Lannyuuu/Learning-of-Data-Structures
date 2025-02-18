package LinkedList;

public class LinkedList {
    ListNode head = null;
    //尾插法： 在尾部插入节点
    public void insertAtTail(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null){
            head = newNode;
            return;
        }
        ListNode curNode = head;
        while(curNode.next != null){
            curNode = curNode.next;
        }
        curNode.next = newNode;
    }
    //打印链表：
    public void display(){
        ListNode cur = head; //cur是一个Node类的变量，包含data和next两个成员变量
        while(cur != null){
            System.out.print(cur.val + " ->");
            cur = cur.next; //注意：这里不能用head.next来实现，head永远指的都是头节点
        }
        System.out.println("null");
    }
    //合并两个有序链表，返回的也是有序的链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        //[1,2,4]
        //[1,3,4]
        //=[1,1,2,3,4,4]
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode newHead = new ListNode(0);
        ListNode tempH = newHead;
        while( list1 != null && list2 != null){
            if (list1.val <list2.val){
                //谁小谁放在前面
                tempH.next = list1;
                tempH = tempH.next;
                list1 = list1.next;
            }else {
                tempH.next = list2;
                tempH = tempH.next;
                list2 = list2.next;
            }
        }
        //先走完的链表tempH先到null，tempH连接到剩下的链表
        if (list1.next == null){
            tempH.next = list2;
        }else if (list2.next == null){
            tempH.next = list2;
        }
        return newHead.next;//注意：不能返回newHead：是新的head，只有地址域是有效的没有值
    }

    public int size(ListNode head){
        int count = 0;
        ListNode curNode = head;
        while(curNode != null){
            curNode = curNode.next;
            count++;
        }
        return count;
    }

    //单链表判断回文：
    public boolean isPalindrome(){
        //找到量表的中间位置：findMiddleNode()
        //把后面的链表反转过来：reverse()

        //1.找到中间节点
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //2.反转后半部分 ：slow->curNode->curNodeNext
        ListNode curNode = slow.next;
        while(curNode!=null){
            ListNode curNodeNext = curNode.next;
            //curNode -> slow
            curNode.next = slow;
            slow = curNode;
            curNode = curNodeNext;
        }
        //3.判断
        while(head != slow){
            if (head.val != slow.val){
                return false;
            }
            //偶数回文结束标志：head.next == slow
            if (head.next == slow){
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //如果两个链表相交了：后面的都相同
        //把长的链表比短链表多出来的一段剪掉（肯定不是相交的链表段），判断后面就行
        //1.求两个链表的长度，假设A链表最长
        ListNode pl = headA;
        ListNode ps = headB;

        int lenA = size(headA);
        int lenB = size(headB);

        //2.根据链表的长度，确定pl指向哪个链表 ps指向哪个链表
        if (lenA<lenB){
            pl = headB;
            ps = headA;
        }
        //3.pl走len步
        int len = Math.abs(lenA - lenB);
        while(len != 0){
            pl = pl.next;
            len--;
        }
        //4.一起走直到相遇
        while(pl != ps){
            pl = pl.next;
            ps = ps.next;
        }
        if (pl == null){
            return null;
        }
        return pl;
    }
    //判断一个链表是否有环
    //fast一次走两步
    //slow一次走一步
    //这样保证：要是存在环：fast和slow一定相遇
    //一次走三步一次走一步不行：有可能永远相遇不了
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow ){
                return true;
            }
        }
        return false;
    }
    //找到环的入口点
    //三个点：起始点、入口点、相遇点
    //slow 的路程： X + (C - Y)
    //fast 的路程： X + C + (C-Y)
    //-> X = Y
    //把fast放在起始点，重新开始走，和slow相遇的地方就是入口点
    public ListNode detectCycle(ListNode head) {
        //判断有没有环：
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while( fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
        if (fast == null || fast.next == null) return null;
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
