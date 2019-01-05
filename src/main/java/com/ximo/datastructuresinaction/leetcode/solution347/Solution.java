package com.ximo.datastructuresinaction.leetcode.solution347;

import com.ximo.datastructuresinaction.queue.PriorityQueue;

import java.util.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author xikl
 * @date 2019/1/5
 */
public class Solution {

    private class Freq implements Comparable<Freq> {
        /** 元素的值 */
        private Integer element;

        /** 元素出现个数 */
        private Long freq;

        public Freq(Integer element, Long freq) {
            this.element = element;
            this.freq = freq;
        }

        public Freq() {
        }

        /** 因为自己的优先队列是最大堆 这里的判断大小要反过来 */
        @Override
        public int compareTo(Freq another) {
//            if (this.freq < another.freq) {
//                return 1;
//            } else if (this.freq > another.freq) {
//                return -1;
//            } else {
//                return 0;
//            }
            // 上面的代码可以改写为这样
            Long compareResult = another.freq - this.freq;
            return compareResult.intValue();
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        return topKFrequentByMyQueue(nums, k);
    }

    public List<Integer> topKFrequentByMyQueue(int[] nums, int k) {
        // 将nums按照出现频率变为一个map
        Map<Integer, Long> numFrequency =
                Arrays.stream(nums).boxed().collect(groupingBy(num -> num, counting()));

        PriorityQueue<Freq> pq = new PriorityQueue<>();

        numFrequency.forEach((key, value) -> {
            if (pq.getSize() < k) {
                pq.enqueue(new Freq(key, value));
            } else if (value > pq.getFront().freq){
                pq.dequeue();
                pq.enqueue(new Freq(key, value));
            }
        });

        List<Integer> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            result.add(pq.dequeue().element);
        }

        return result;
    }

    /** 用java的自带的优先队列实现 */
    public List<Integer> topKFrequentByJavaQueue(int[] nums, int k) {
        // 将nums按照出现频率变为一个map
        Map<Integer, Long> numFrequency =
                Arrays.stream(nums).boxed().collect(groupingBy(num -> num, counting()));

        // java中采用的是小顶堆的实现
        java.util.Queue<Integer> pq = new java.util.PriorityQueue<>((prev , next) -> {
            Long compareResult = numFrequency.get(prev) - numFrequency.get(next);
            return compareResult.intValue();
        });

        numFrequency.forEach((key, value) -> {
            if (pq.size() < k) {
                pq.add(key);
            } else if (value > numFrequency.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        });
        return new ArrayList<>(pq);
    }



}
