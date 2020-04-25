package com.ximo.datastructuresinaction.algorithmsfourthedition;

/**
 * @author xikl
 * @date 2020/4/25
 */
public class Chapter01 {

    public static boolean isPrime(int n) {
        // 大于1的数字才是
        if (n < 2) {
            return false;
        }

        // 2 和 3 本身只有1和本身
        if (n == 2 || n == 3) {
            return true;
        }

        // 排除偶数
        if (n % 2 == 0) {
            return false;
        }

        // 根据定理
        // 避免求根号，改为平方
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(13));
    }


}
