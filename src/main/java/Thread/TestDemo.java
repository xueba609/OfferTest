package Thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestDemo {
    private static  Lock lock =new ReentrantLock();
    private static  int num=0;
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();

    static class Thread1 extends Thread{
        @Override
        public void run() {
           lock.lock();
               try {
                  if(num!=0)
                      A.await();
                   System.out.println("A");
                   num++;
                   B.signal();

               } catch (InterruptedException e) {
                   e.printStackTrace();
               }finally {
                   lock.unlock();
               }
        }
    }
    static class Thread2 extends Thread{

        @Override
        public void run() {
            lock.lock();
            try {
                if(num!=1)
                    B.await();
                System.out.println("B");
                num++;
                C.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

            }
        }

    static class Thread3 extends Thread{

        @Override
        public void run() {
            lock.lock();
            if(num==2){
                System.out.println("C");
                    lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
                 new Thread1().start();
                 new Thread2().start();
                 Thread3 thread3 = new Thread3();
                 thread3.start();

    }
}