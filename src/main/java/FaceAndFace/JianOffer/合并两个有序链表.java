package FaceAndFace.JianOffer;
/*
*输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
/*
*思路：1.先判断两个是否为空，任何一个为空，返回另外一个
*      当两个都不为空的时候，两个都从头开始比较，谁小的填到result上.next，并向后移动
*      最后，任何一个为空，跳出循环，在进行判断，谁空把另外一个赋给result。
*
*      2.先判断两个是否为空，任何一个为空，返回另外一个
 *      当两个都不为空的时候，两个都从头开始比较，谁小的填到result上，result.next=merge(cur1.next,n5)
 */
public class 合并两个有序链表 {
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
       //ListNode result=Merge1(n1, n5);
        //递归
        ListNode result=Merge2(n1,n5);
       while(result!=null){
           System.out.format("%d------>",result.val);
           result=result.next;
       }

    }

    private static ListNode Merge2(ListNode n1, ListNode n5) {
        if (n1 == null) {
            return n5;
        }
        if (n5 == null) {
            return n1;
        }
        ListNode cur1 = n1;
        ListNode cur2 = n5;
        //储存结果
        ListNode result = null;
        if(cur1.val<=cur2.val){
            result=cur1;
            result.next=Merge2(cur1.next,cur2);
        }else{
            result=cur2;
            result.next=Merge2(cur1,cur2.next);
        }
      return result;
    }

    private static ListNode Merge1(ListNode n1, ListNode n5) {
        if (n1 == null) {
            return n5;
        }
        if (n5 == null) {
            return n1;
        }
        ListNode cur1 = n1;
        ListNode cur2 = n5;
        //储存结果
        ListNode result = null;
        //储存result中最后一个下标
        ListNode last=null;
        //任何一个为空，返回另外一个
        //两个链表从头进行比较
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                ListNode next=cur1.next;
                cur1.next=null;
                if(result==null){
                    result=cur1;
                }else{
                    last.next=cur1;
                }
                //执行完更新数组 下标
                last=cur1;
                cur1=next;
            } else {
                ListNode next=cur2.next;
                cur2.next=null;
                if(result==null){
                    result=cur2;
                }else{
                    last.next=cur2;
                }
                //执行完更新数组 下标
                last=cur2;
                cur2=next;
            }

        }
        if(cur1==null){
            last.next=cur2;
        }
        if(cur2==null){
            last.next=cur1;
        }
        return result;
    }

}

