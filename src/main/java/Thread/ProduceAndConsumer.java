package Thread;

import LinkList.PalindromeList;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Goods{
    private final Lock lock=new ReentrantLock();
    private final Condition ProduceQuene=lock.newCondition();
    private final Condition ConsumerQuene=lock.newCondition();
    //商品名字
    private String name;
    //商品数量
    private int count=0;

    //生产方法
     public void set(String name){
         lock.lock();
       try{
          while(count==3){
              System.out.println("亲，还有狗粮，请您购买");
              ProduceQuene.await();
          }
          this.name=name;
          this.count=count+1;
          Thread.sleep(1000);
          System.out.println("生产"+toString());
          //通知消费者跟快消费
           ConsumerQuene.signalAll();

       }catch (InterruptedException e){
              e.printStackTrace();
       }finally {
           lock.unlock();
       }
    }
    //消费方法
    public void get(){
         lock.lock();
         try{
             while(this.count==0){
                 System.out.println("亲，狗粮已经卖完啦，这边正在加紧生产中");
                 ConsumerQuene.await();
             }
             this.count=count-1;
             Thread.sleep(500);
             System.out.println("消费"+toString());
             //通知生产者跟紧生产
             ProduceQuene.signalAll();
         } catch (InterruptedException e) {
             e.printStackTrace();
         } finally {
             lock.unlock();
         }
    }
    @Override
    public String toString() {
        return "Goods [goodsName=" + name + ", 库存为" + count + "]";
    }
}
class Produce implements Runnable{
    private Goods goods;
    public Produce(Goods goods){
        this.goods=goods;
    }
    @Override
    public void run() {
        this.goods.set("狗❤粮");
    }
    //生产者
}
class Consumer implements Runnable{
    private  Goods goods;
   public Consumer(Goods goods){
           this.goods=goods;
    }
    @Override
    public void run() {
       this.goods.get();
    }
}

public class ProduceAndConsumer {
    public static void main(String[] args) {
        Goods goods=new Goods();
        Thread thread1=new Thread(new Produce(goods));
        Thread thread2=new Thread(new Produce(goods));
        Thread thread3=new Thread(new Produce(goods));
        Thread thread4=new Thread(new Produce(goods));
        Thread thread5=new Thread(new Consumer(goods));
        Thread thread6=new Thread(new Consumer(goods));
        Thread thread7=new Thread(new Consumer(goods));
        Thread thread8=new Thread(new Consumer(goods));
         thread1.start();
         thread2.start();
         thread3.start();
         thread4.start();
         thread5.start();
         thread6.start();
         thread7.start();
         thread8.start();
    }
}
