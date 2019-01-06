package com.ximo.datastructuresinaction.leetcode.solution347;

import com.ximo.datastructuresinaction.queue.PriorityQueue;

import java.util.*;
import java.util.function.Function;

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

    /**
     * 用java的自带的优先队列实现
     * 统计频次最大的那个 放入
     *
     * @param nums 数组
     * @param k 前几个
     * @return 前k个元素
     */
    public List<Integer> topKFrequentByJavaQueue(int[] nums, int k) {
        // 将nums按照出现频率变为一个map
        Map<Integer, Long> numFrequency =
                Arrays.stream(nums).boxed().collect(groupingBy(Function.identity(), counting()));

        // java中采用的是小顶堆的实现
        java.util.Queue<Integer> pq = new java.util.PriorityQueue<>((prev , next) -> {
            Long compareResult = numFrequency.get(prev) - numFrequency.get(next);
            return compareResult.intValue();
        });

        // 遍历该map
        numFrequency.forEach((key, value) -> {
            // 小于前k个元素
            if (pq.size() < k) {
                // 直接添加
                pq.add(key);
                // 如果当前元素的出现频率大于堆首的元素的出现频率
            } else if (value > numFrequency.get(pq.peek())) {
                // 先删除堆首的元素
                pq.remove();
                // 再添加当前元素
                pq.add(key);
            }
        });
        return new ArrayList<>(pq);
    }



}
