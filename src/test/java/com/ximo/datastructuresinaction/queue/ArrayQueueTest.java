package com.ximo.datastructuresinaction.queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Ximo
 * @date 2018/10/23 22:19
 */
public class ArrayQueueTest {

    @Test
    public void testArrayQueue() {
        Queue<Integer> queue = new ArrayQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }
}