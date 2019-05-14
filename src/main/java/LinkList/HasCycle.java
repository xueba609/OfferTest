package LinkList;

/*
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
为了表示给定链表中的环，
我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
如果 pos 是 -1，则在该链表中没有环。
说明：不允许修改给定的链表。
 */
/*
*思路：快慢指针，快的走2步，慢的走一步。判断是否有环
* 如果快的==null,没有环，如果快的等于==慢的则有环
* 起始点到入口点的距离：L  圆的周长：R    环入口到相遇点：C
* 满指针：L+C   快指针L+C+nR(n>1)     2(L+C)
* 解方程：L=nR-C=(n-1)R+(R-C)
 */

public class HasCycle {
    public ListNode detectCycle(ListNode head){
        if(head==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        do{
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
        }while (fast!=null&&slow!=null);//fast等于null,没有环，fast==slow有环
        if(fast==null){
            return null;
        }
        //一个从起点出发
        ListNode p1=head;
        //一个从相遇点出发
        ListNode p2=slow;
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
}
