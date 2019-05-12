package LinkList;
/*
*编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。
注意：分割以后保持原来的数据顺序不变。
 */
public class Parttition {
        private ListNode partition(ListNode pHead, int x) {
            ListNode samll = null;  //小于x
            ListNode samllLast = null; //小于x的最后一个节点
            ListNode big = null;  //大于x
            ListNode bigLast = null;//大于等于x的最后一个节点
            ListNode cur = pHead;
            while (cur != null) {
                ListNode next = cur.next;
                if (cur.val < x) {
                    //记得将cur.next置空，要不然cur.next依然指向原来的链表的数字
                    cur.next=null;
                    if (samll == null) {
                        samll = cur;
                    } else {
                        samllLast.next = cur;
                    }
                    samllLast = cur;
                } else {
                    cur.next=null;
                    if (big == null) {
                        big = cur;
                    } else {
                        bigLast.next = cur;
                    }
                    bigLast = cur;
                }
                cur = next;
            }
            if(samll!=null){
                samllLast.next=big;
                return samll;
            }else{
                return big;
            }
    }
    public static void main(String[] args) {
            ListNode n1=new ListNode(1);
            ListNode n2=new ListNode(2);
            ListNode n3=new ListNode(6);
            ListNode n4=new ListNode(3);
            ListNode n5=new ListNode(4);
            ListNode n6=new ListNode(5);
            ListNode n7=new ListNode(7);
            n1.next=n2;
            n2.next=n3;
            n3.next=n4;
            n4.next=n5;
            n5.next=n6;
            n6.next=n7;
            Parttition r=new Parttition();
            ListNode result=r.partition(n1,5);
            while(result!=null){
                System.out.format("%d --->",result.val);
                result=result.next;
            }
            System.out.println("null");
        }
}
