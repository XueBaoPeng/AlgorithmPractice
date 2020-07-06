package org.xbp.algorithm.category.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xuebaopeng
 * @Date 2020/7/6 23:50
 * 为了实现队列，我们可以使用动态数组和指向队列头部的索引。
 * 队列应支持两种操作：入队和出队。入队会向队列追加一个新元素，而出队会删除第一个元素。 所以我们需要一个索引来指出起点
 * 上面的实现很简单，但在某些情况下效率很低。 随着起始指针的移动，浪费了越来越多的空间。 当我们有空间限制时，这将是难以接受的
 *
 * @Version 1.0
 **/
class Queue {
    //存储的数据
    private List<Integer> data;
    //指向队列头部的指针
    private int p_start;

    /**
     * 设置队列的存储数组，并且制定起始头部为0下标
     */
    public Queue(){
        data=new ArrayList<Integer>();
        p_start=0;
    }

    /**
     * 入队，在队列尾部插入数据，头部指针不变
     * @param x
     * @return
     */
    public boolean inQueue(int x){
        data.add(x);
        return true;
    }

    /**
     * 删除队列，该方法队列的头部后移一位
     * @return
     */
    public boolean deQueue(){
        if (isEmpty()){
            return  false;
        }
        p_start++;
        return  true;
    }
    //获取开始节点
    public  int Front(){
        return data.get(p_start);
    }

    public boolean isEmpty(){
        return p_start>=data.size();
    }
}

public class QueueMain{
    public static void main(String[] args) {
        Queue queue=new Queue();
        queue.inQueue(6);
        queue.inQueue(3);
        if (queue.isEmpty()==false){
            System.out.println(queue.Front());
        }
        queue.deQueue();
        if (queue.isEmpty() == false) {
            System.out.println(queue.Front());
        }
        queue.deQueue();
        if (queue.isEmpty() == false) {
            System.out.println(queue.Front());
        }
    }
}


