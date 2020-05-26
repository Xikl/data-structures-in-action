package com.ximo.datastructuresinaction.string;

/**
 * @author xikl
 * @date 2020/5/26
 */
public class StringTest {

    public static void main(String[] args) {
        final String s = concatString("1", "2", "a");
        System.out.println(s);
    }

    /**
     * <code>
     *     // access flags 0x9
     *   public static concatString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
     *     // parameter  s1
     *     // parameter  s2
     *     // parameter  s3
     *    L0
     *     LINENUMBER 15 L0
     *     NEW java/lang/StringBuilder
     *     DUP
     *     INVOKESPECIAL java/lang/StringBuilder.<init> ()V
     *     ALOAD 0
     *     INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
     *     ALOAD 1
     *     INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
     *     ALOAD 2
     *     INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
     *     INVOKEVIRTUAL java/lang/StringBuilder.toString ()Ljava/lang/String;
     *     ARETURN
     *    L1
     *     LOCALVARIABLE s1 Ljava/lang/String; L0 L1 0
     *     LOCALVARIABLE s2 Ljava/lang/String; L0 L1 1
     *     LOCALVARIABLE s3 Ljava/lang/String; L0 L1 2
     *     MAXSTACK = 2
     *     MAXLOCALS = 3
     * }
     * </code>
     * 会转化为StringBuilder来操作
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public static String concatString(String s1, String s2, String s3) {
        return s1 + s2 + s3;
    }



}
