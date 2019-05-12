package LinkList;
/*
给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {
    private ListNode middleNode(ListNode head) {
        //快慢指针解决法
            ListNode fast=head;
            ListNode slow=head;
            while(fast!=null){
                fast=fast.next;
                if(fast==null){
                    break;
                }
                slow=slow.next;
                fast=fast.next;
            }
            return  slow;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(6);
        ListNode n4=new ListNode(3);
        ListNode n5=new ListNode(4);
        ListNode n6=new ListNode(5);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;

        MiddleNode r=new MiddleNode();
        ListNode result=r.middleNode(n1);
        System.out.println(result.val);
    }
}
