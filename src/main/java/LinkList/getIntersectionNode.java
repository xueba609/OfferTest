package LinkList;
/*
*编写一个程序，找到两个单链表相交的起始节点。
 */
//思路：长-短的，然后一起走
public class getIntersectionNode {
    private int getLength(ListNode head) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int p1 = getLength(headA);
        int p2 = getLength(headB);
        ListNode longer = headA;
        ListNode shorter = headB;
        int len = p1 - p2;
        if (p1 < p2) {
            longer = headB;
            shorter = headA;
            len = p2 - p1;
        }
        for (int i = 0; i < len; i++) {
            longer = longer.next;
        }
        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }
        return longer;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(4);
        ListNode n8 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next =n5;
        n5.next = null;

        n6.next = n7;
        n7.next = n8;
        n8.next = null;
       getIntersectionNode g = new getIntersectionNode();
        ListNode node=g.getIntersectionNode1(n1, n6);
        System.out.println(node);
    }
}
