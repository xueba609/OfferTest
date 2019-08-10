package FaceAndFace.JianOffer;
/*
*输入一个链表，输出该链表中倒数第k个结点。
 */
/*
*思路：快慢指针，快指针先走k个节点,再和慢指针一起走
 */
 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class FindKthToTail {
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
        System.out.println(FindKthToTail1(n1,7).val);
    }
    public static ListNode FindKthToTail1(ListNode head, int k) {
      ListNode quick=head;
      ListNode slow=head;
      int i;
      for( i=0;i<k&&quick!=null;i++){
          quick=quick.next;
      }
      //判断临界,quick==null两种情况：第一种本来就是空的，另外一种如果倒数第K个就到达头结点
    if(quick==null&i<k){
          return null;
    }else if(quick==null){
          return head;
    }
    while(quick!=null){
          quick=quick.next;
          slow=slow.next;
    }
    return slow;
    }
}
