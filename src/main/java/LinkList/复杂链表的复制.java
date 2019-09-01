package LinkList;
 class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
//三步走，先将新的节点复制在老节点后面
//再处理特殊指向
//最后将两个链表分开

public class 复杂链表的复制 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        //先将新节点复制在老节点的后面
         RandomListNode cur=pHead;
         while(cur!=null){
             RandomListNode newNode=new RandomListNode(cur.label);
             newNode.next=cur.next;
             cur.next=newNode;
             cur=cur.next.next;
         }

         //处理特殊指针
        cur=pHead;
         while(cur!=null){
             RandomListNode curNext=cur.next;
             if(cur.random==null){
                 curNext.random=null;
             }else{
                 curNext.random=cur.random.next;
             }
             cur=cur.next.next;
         }

         //拆分
        cur=pHead;
         RandomListNode result=pHead.next;
         while(cur!=null){
                 RandomListNode next=cur.next;
                 cur.next=next.next;
                 //处理最后的null
                 if(next.next!=null){
                     next.next=next.next.next;
                 }else {
                     next.next=null;
                 }
                 cur=cur.next;

         }
         return result;
    }
}
