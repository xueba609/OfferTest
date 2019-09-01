
class Node{
    int val;
    Node next;
}
public class test3 {
    static Node removeAll(Node node, int key) {
        Node result = null;
        Node cur = node;
        Node last=null;
        while (cur != null) {
            //如果当前的值不等于key，就赋给新的链表
            if (cur.val != key) {
                if (result == null) {
                    result = cur;
                } else {
                   last.next=cur;
                }
                last=cur;
            }
        }
        //3 3 3 3 3 3 3
        if(last!=null){
            last.next=null;
        }
        return result;
    }
}
