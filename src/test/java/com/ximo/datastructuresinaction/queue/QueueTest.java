package com.ximo.datastructuresinaction.queue;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author Ximo
 * @date 2018/10/23 22:19
 */
public class QueueTest {

    @Test
    public void testArrayQueue() {
        Queue<Integer> arrayQueue = new ArrayQueue<>();

        testQueue(arrayQueue);

        Queue<Integer> loopQueue = new LoopQueue<>();
        testQueue(loopQueue);
    }

    private void  testQueue(Queue<Integer> queue) {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }


    @Test
    public void testUniqueQueue() {
        int count = 100_000;
        Queue<Integer> queue1 = new LoopQueue<>();
        long time1 = timeConsuming(queue1, 100_000);
        System.out.println("Queue1:" + time1);


        Queue<Integer> queue2 = new ArrayQueue<>();
        long time2 = timeConsuming(queue2, count);
        System.out.println("Queue2:" + time2);

    }

    private static long timeConsuming(Queue<Integer> queue, int count) {
        Instant start = Instant.now();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }
        Instant end = Instant.now();
        Duration timeConsuming = Duration.between(start, end);
        return timeConsuming.toMillis() / 1000;
    }
}