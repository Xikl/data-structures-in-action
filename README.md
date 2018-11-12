# data-structures-in-action
### 第一章
- 1.数组：
```java
// arr中的所有元素都默认是0
int[] arr = new int[10];
```
- 2.均摊分析数组中的resize操作时间复杂度
```
假设容量为10，需要进行10+1次add操作才能进行resize，resize消耗10，故所有的操作和为20 + 1
=> 然后(20 + 1) / (10 + 1) 约等于 2

推导到n:
假设容量为n，需要进行n+1次add操作才能进行resize，resize消耗2n，故所有的操作和为2n + 1
=> 然后(2n + 1) / (n + 1) 约等于 2

故可以看成时间复杂度为O(1)
```
 - 2.1复杂度震荡!
 ```
 capacity = n, 满的时候addLast， resize，此时在进行removeLast,还是会触发resize，
 如此循环 都是O(n)
 
 解决办法 采用lazy的形式进行resize，具体看Array类中的remove方法
 ```
- 3 循环队列
```
循环队列为空的标志：
front == tail
满的标志(tail + 1) % capcity = front
```
两种遍历循环队列的方法
```java
for(i = 0; i < size; i++) {
    System.out.println(data[(i + front) % data.length])
}

for(i = front; i != tail; i = (i + 1) % data.length) {
    System.out.println(data[i])
}
```
- 4 删除树中的任意元素
删除左右都有孩子的节点D
找到 该值的右侧最小的值 S
S 就是D的后继
然后 需要删除S的最小值 S.right = removeMin(D.right)
然后S.left = D.left
删除D, S是新的子树的根
- 5 树的时间复杂度为 O(h) h为树的高度
其中 假设 一个树为满二叉树
他的节点个数为 2^0 + 2^1 + 2^2 + 2^3 + ... + 2^h-1 = 1 * (1-2^h)/(1-2) = 2^h-1 = n
所以h = logn 故 O(h) = O(logn) 
这是一种非常快的速度 当然只是平均的时间 最坏的情况 当树变成一个链表的时候 将会变O(n)



