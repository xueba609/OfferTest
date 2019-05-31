package LinkList;
/*
*在一个排序的链表中，存在重复的结点，
* 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
* 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
//思路：两个指针来进行跑，
public class deleteDuplication {
    public ListNode deleteDuplication1(ListNode pHead) {
        if(pHead==null){
            return null;
        }
        //建立一个假节点,消除第一个节点没有前驱
        ListNode dummy=new ListNode(0);
        dummy.next=pHead;
        ListNode pre=dummy;
        ListNode p1=pHead;
        ListNode p2=pHead.next;
        while(p2!=null){
            if(p1.val!=p2.val){
                //p1hep2有序，所以p1和p2不等，所以p1和p2.next更不会相等
                pre=pre.next;
                p1=p1.next;
                p2=p2.next;
            }else{
                while(p2!=null&&p2.val==p1.val){
                    p2=p2.next;
                }
                pre.next=p2;
                p1=p2;
               if(p2!=null) {
                   p2 = p2.next;
               }
            }
        }
            return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(2);
        ListNode n4=new ListNode(3);
        ListNode n5=new ListNode(3);
        ListNode n6=new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        deleteDuplication d=new deleteDuplication();
       ListNode cur=d.deleteDuplication1(n1);
        while (cur!=null){
            System.out.format("%d --->",cur.val);
            cur=cur.next;
        }

    }
}
