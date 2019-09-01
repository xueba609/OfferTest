package LinkList;
/*
*给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
要求返回这个链表的深拷贝。
 */
public class copyRandomList {
    class Node {
        public int val;
        public Node next;
        public Node random;
        public Node(int val) {
            this.val = val;
        }
    }
    public Node copyRandomList(Node head) {
        //遍历原链表的每一个节点，创建新节点
        //把新节点插入到原节点的后面
        Node cur=head;
        while(cur!=null){
            Node newNode=new Node(cur.val);
            newNode.next=cur.next;
            cur.next=newNode;
            //让cur走向下一节点
            cur=cur.next.next;
        }
        
        //设置新的节点random
        cur=head;
        while(cur!=null){
            Node newNode=cur.next;
            if(cur.random==null){
                newNode.random=null;
            }else {
                newNode.random=cur.random.next;
            }
            //cur走到下一个老节点
            cur=cur.next;
        }
      //拆分两个链表
        cur=head;
        Node result=head.next;
        while(cur!=null){
            Node newNode=cur.next;
            cur.next=newNode.next;
            //处理最后的null
            if(newNode.next!=null){
                newNode.next=newNode.next.next;
            }
            cur=cur.next;
        }
        return result;
    }
}
