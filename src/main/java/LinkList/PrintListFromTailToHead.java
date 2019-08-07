package LinkList;

import sun.plugin.javascript.navig4.Link;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
*输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class PrintListFromTailToHead {
    public static void main(String[] args) {
      ListNode n1=new ListNode(1);
      ListNode n2=new ListNode(2);
      ListNode n3=new ListNode(3);
      ListNode n4=new ListNode(4);
      ListNode n5=new ListNode(5);
      n1.next=n2;
      n2.next=n3;
      n3.next=n4;
      n4.next=n5;
        ArrayList<Integer> arrayList=printListFromTailToHead(n1);
        System.out.println(arrayList);
    }

    private static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        List<Integer> list=new LinkedList<>();
        while(listNode!=null){
            list.add(listNode.val);
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
        //拿到长度
        int len=list.size();
        ArrayList<Integer>  arrayList=new ArrayList<>();
        for(int i=len-1;i>=0;i--){
            arrayList.add(list.get(i));
        }
        return arrayList;
    }
}
