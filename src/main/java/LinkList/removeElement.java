package LinkList;

/*
删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 */
public class removeElement {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeElements1(ListNode head, int val) {
        //用来保存结果链表
        ListNode result =null;
        //记录结果链表的最后一个节点
        ListNode last=null;
        ListNode cur=head;
        while(cur!=null){
            //
            ListNode next=cur.next;
            if(cur.val!=val){
                cur.next=null;
                if(result==null){
                    result=cur;
                }else {
                    last.next=cur;
                }
                last=cur;
            }
            //如果使用cur.next会导致和上面null冲突
            cur=next;
        }
        return result;
    }
    public ListNode removeElements2(ListNode head, int val) {
        if(head==null){
            return null;
        }
        //用来保存结果链表
        ListNode cur = head;
        while (cur.next != null) {
            if(cur.next.val!=val){
                cur=cur.next;
            }else {
                cur.next=cur.next.next;
            }
        }
        //判断头结点是否是要删除的数
        if(head.val== val){
            return head.next;
        }else {
            return head;
        }
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
        removeElement element=new removeElement();
        ListNode result=element.removeElements2(n1,6);
        ListNode cur=result;
        while (cur!=null){
            System.out.format("%d --->",cur.val);
            cur=cur.next;
        }
    }
}
