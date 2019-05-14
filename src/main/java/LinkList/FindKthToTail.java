package LinkList;
/*
*题目描述
输入一个链表，输出该链表中倒数第k个结点。
 */
//思路：快的先走k个节点，再和慢的一起走
public class FindKthToTail {
    public ListNode FindKthToTail1(ListNode head,int k) {
          ListNode front=head;
          ListNode end=head;
          int i;
          for(i=0;front!=null&&i<k;i++){
              front=front.next;
          }
        //判断临界
        if(front==null&&i<k){
              return null;
        }else if(front==null){
              return head;
        }
          while(front!=null){
              front=front.next;
              end=end.next;
          }
          return end;
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
        FindKthToTail f=new FindKthToTail();
        System.out.println(f.FindKthToTail1(n1,3).val);
    }
}
