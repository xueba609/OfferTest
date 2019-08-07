package LinkList;

import java.util.List;

/*
*反转一个单链表。
示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
//方法一：主要是开辟开辟另外一个链表，用来接收刺链表的头插
//方法二：用三个变量用来存储从头到尾的节点（pre cur next)，将cur.next=pre使链表方向
//然后往后走
class ListNode {
     int val;
     ListNode next;
   public ListNode(int x) {
       this.val = x;
   }
  }
public class reverseList {
    public ListNode reverseList1(ListNode head){
        //用来保存结果，
        ListNode result=null;
        ListNode cur=head;
        while(cur!=null){
            //保存下一个结点,因为下面的操作会使cur.next改变
            ListNode next=cur.next;
            //头插到result
            cur.next=result;
            result=cur;
            cur=next;
        }
        return result;
    }
    public ListNode reverseList2(ListNode head){
        if(head==null){
            return null;
        }
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(6);
        ListNode n4=new ListNode(3);
        ListNode n5=new ListNode(4);
        ListNode n6=new ListNode(5);
        ListNode n7=new ListNode(6);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
       reverseList r=new reverseList();
       ListNode result=r.reverseList2(n1);
       while(result!=null){
           System.out.format("%d --->",result.val);
           result=result.next;
       }
       System.out.println("null");
    }
}
