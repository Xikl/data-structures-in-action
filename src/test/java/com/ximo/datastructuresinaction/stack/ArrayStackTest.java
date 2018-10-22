package com.ximo.datastructuresinaction.stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Ximo
 * @date 2018/10/23 0:14
 */
public class ArrayStackTest {


    @Test
    public void testArrayStack() {

        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

    }
}