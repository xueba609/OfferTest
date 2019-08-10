package FaceAndFace.JianOffer;

public class Merge {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(5);

        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(8);
        ListNode n8 = new ListNode(9);
        ListNode n9 = new ListNode(10);
        ListNode n10 = new ListNode(11);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = null;
        Merge1(n1, n5);
    }

    private static ListNode Merge1(ListNode n1, ListNode n5) {
        ListNode cur1 = n1;
        ListNode cur2 = n5;
        //储存结果
        ListNode result = null;
        //任何一个为空，返回另外一个
        if (n1 == null) {
            return n5;
        }
        if (n5 == null) {
            return n1;
        }
        //两个链表从头进行比较
        while (cur1 != null && cur2 != null) {
            if (cur1.val >= cur2.val) {
                result.val = cur1.val;
                cur1=cur1.next;
            }else{
                result.val = cur2.val;
            }

        }
        if()

    }
}

