package xyz.grafgeest.concurrency.example1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;

public class InterThreadCommunicationExample {

    private static final Logger LOG = LogManager.getLogger(InterThreadCommunicationExample.class);

    public static void main(String args[]) {
        LOG.info("Start..");

        final Queue sharedQ = new LinkedList();

        Thread producer = new Producer(sharedQ);
        Thread consumer1 = new Consumer(sharedQ, "Consumer_1");
        Thread consumer2 = new Consumer(sharedQ, "Consumer_2");

        producer.start();
        consumer1.start();
        consumer2.start();

    }
}
