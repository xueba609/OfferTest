package LinkList;



/*
*题目描述
对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。

给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。

测试样例：
1->2->2->1
返回：true
 */
//思路：先找中点节点，把后面一段翻转过来
public class PalindromeList {
    public int getLength(ListNode A) {
         if(A==null){
             return 0;
         }
         int i=0;
         while (A!=null){
             i++;
             A=A.next;
         }
         return i;
    }
    private ListNode reverse1(ListNode  midCur){
        ListNode pre=null;
        ListNode cur=midCur;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
    public boolean chkPalindrome(ListNode A) {
            int length=getLength(A);
            int mid=length/2;
            ListNode midCur=A;
            for(int j=0;j<mid;j++){
                midCur=midCur.next;
            }
            ListNode C1=A;
            ListNode C2=reverse1(midCur);
          while(C1!=null&&C2!=null){
              if(C1.val!=C2.val){
                  return false;
              }
              C1=C1.next;
              C2=C2.next;
          }
          return true;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(3);
        ListNode n5=new ListNode(2);
        ListNode n6=new ListNode(1);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;

        PalindromeList p=new PalindromeList();
        System.out.println(p.chkPalindrome(n1));
    }
}
