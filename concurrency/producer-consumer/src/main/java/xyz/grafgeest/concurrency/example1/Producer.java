package xyz.grafgeest.concurrency.example1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Queue;

public class Producer extends Thread {
    private static final Logger LOG = LogManager.getLogger(Producer.class);
    private final Queue sharedQ;

    public Producer(Queue sharedQ) {
        super("Producer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {

        for (int i = 0; i < 4; i++) {

            synchronized (sharedQ) {
                //waiting condition - wait until Queue is not empty
                while (sharedQ.size() >= 1) {
                    try {
                        LOG.debug("Queue is full, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                LOG.debug("producing : " + i);
                sharedQ.add(i);
                sharedQ.notifyAll();
            }
        }
    }

}
