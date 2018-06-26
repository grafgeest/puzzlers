package xyz.grafgeest.concurrency.example1;

import java.util.Queue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Consumer extends Thread {
    private static final Logger LOG = LogManager.getLogger(Consumer.class);
    private final Queue sharedQ;

    public Consumer(Queue sharedQ) {
        super("Consumer");
        this.sharedQ = sharedQ;
    }

    public Consumer(Queue sharedQ, String name) {
        super(name);
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        while(true) {

            synchronized (sharedQ) {
                //waiting condition - wait until Queue is not empty
                while (sharedQ.size() == 0) {
                    try {
                        LOG.debug("Queue is empty, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                int number = (Integer) sharedQ.poll();
                LOG.debug("consuming : " + number );
                sharedQ.notify();

                //termination condition
                if(number == 3){break; }
            }
        }
    }

}
