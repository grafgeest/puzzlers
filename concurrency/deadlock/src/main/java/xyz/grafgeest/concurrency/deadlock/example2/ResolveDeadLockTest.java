package xyz.grafgeest.concurrency.deadlock.example2;

public class ResolveDeadLockTest {
    public static void main(String[] args) {
        final Foo firstThread = new Foo();
        final Foo secondThread = new Foo();

        Runnable block1 = () -> {
            System.out.println("Block 1 start");
            synchronized (secondThread) {
                try {
                    //add a delay so that both threads can start
                    //blocking resources
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Thread-1 took secondThread but also needs firstThread
                synchronized (firstThread) {
                    System.out.println("In block 1");
                }
            }
        };

        // Thread-2
        Runnable block2 = () -> {
            System.out.println("Block 2 start");
            synchronized (secondThread) {
                //Thread-2 took secondThread but also needs firstThread
                synchronized (firstThread) {
                    System.out.println("In block 2");
                }
            }
        };

        new Thread(block1).start();
        new Thread(block2).start();
    }
}
