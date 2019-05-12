package LinkList;
class Node{
    char data;
    Node next;
    public Node(char data){
        this.data=data;
        this.next=null;
    }
}
public class MyLinkList{
    public Node head;
    public MyLinkList(){
        this.head=null;
    }
    //头插
    void pushFront(Node node){
        node.next=this.head;
        this.head=node;
    }
    //尾插
    void pushBack(Node node){
        if(head == null){
            this.head=node;
        }else{
            Node last=getLast();
            last.next=node;
        }
    }
    //查找链表最后一个节点
    private Node getLast(){
        if(this.head==null){
            throw new Error();
        }
        Node last=this.head;
        while(last.next!=null){
            last=last.next;
        }
        return last;
    }
    //依次打印链表的值
    public void display (){
        Node cur=this.head;
        while(cur!=null){
            System.out.format("%s -->",cur.data);
            cur=cur.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        MyLinkList list=new MyLinkList();
        list.pushFront(new Node('a'));
        list.pushFront(new Node('b'));
        list.pushFront(new Node('c'));
        list.display();
        list.pushBack(new Node('k'));
        list.display();
    }
}
