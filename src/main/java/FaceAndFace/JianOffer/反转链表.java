package FaceAndFace.JianOffer;
/*
*输入一个链表，反转链表后，输出新链表的表头。
 */
/*
*思路：一次操作三个节点，当前节点的前一个节点，当前节点后一个节点
 */
public class 反转链表 {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(6);
        ListNode n7=new ListNode(7);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        ListNode result=ReverseList1(n1);
        while(result!=null){
            System.out.format("%d --->",result.val);
            result=result.next;
        }
        System.out.println("null");
    }

    private static ListNode ReverseList1(ListNode n1) {
        ListNode pre=null;
        ListNode cur=n1;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;

    }
}
