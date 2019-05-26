package Queue;
public class   MyQueue {
    private class Node{
        int value;
        Node next;
    }
    Node head;
    Node last;
    public MyQueue(){
        this.head=this.last=null;
    }
    //入队列
    public void push(int v){
        Node node=new Node();
        node.value=v;
        node.next=null;
        if(this.head==null){
            this.head=this.last=node;
        }else {
            this.last.next=node;
            //更新最后一个节点
            this.last=node;
        }

    }
    //出队列
    public int  pop(){
           int v=this.head.value;
           this.head=this.head.next;
           if(this.head==null){
               this.last=null;
           }
           return v;
    }
    //返回队首元素
    public int front(){
        if(this.head==null){
            //异常
        }
        return this.head.value;
    }
    public int size(){
        int count=0;
        Node cur=this.head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    public boolean isEmpty(){
        return this.head==null;
    }
}