package LinkList;
/*
*将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */

public class mergetwoList {
    private ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode cur1=l1;
        ListNode cur2=l2;
        ListNode result=null;
        //用来 记录最后一个节点
        ListNode last=null;
        while(cur1!=null && cur2!=null){
            if(cur1.val<=cur2.val){
                ListNode next=cur1.next;
                cur1.next=null;
                if(result==null){
                    result=cur1;
                }else {
                    last.next=cur1;
                }
                //更新最后的坐标，
                last=cur1;
                cur1=next;
            }else {
                ListNode next=cur2.next;
                cur2.next=null;
                if(result==null){
                    result=cur2;
                }else {
                    last.next=cur2;
                }
                //更新最后的坐标
                last=cur2;
                cur2=next;
            }
        }
        //上面走完之后，会有其中一个为空
        if(cur1!=null){
            last.next=cur1;
        }
        if(cur2!=null){
            last.next=cur2;
        }
    return result;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(6);

        ListNode n5=new ListNode(4);
        ListNode n6=new ListNode(5);
        ListNode n7=new ListNode(7);
        ListNode n8=new ListNode(8);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=null;
        n5.next=n6;
        n6.next=n7;
        n7.next=n8;
        n8.next=null;
        mergetwoList  r=new mergetwoList ();
        ListNode result=r.mergeTwoLists1(n1,n5);
        while(result!=null){
            System.out.format("%d --->",result.val);
            result=result.next;
        }
        System.out.println("null");
    }
}
