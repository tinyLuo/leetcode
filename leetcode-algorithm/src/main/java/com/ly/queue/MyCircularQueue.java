package com.ly.queue;

/**
 * 
 * 双指针队列
 * @author ly
 *
 */
public class MyCircularQueue {
    
    private int[] data;
    
    private int curSize;
    
    private final int size;
    
    private int head;
    
    private int tail;
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new int[k];
        size = k;
        curSize = 0;
        head = 0;
        tail = -1;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(curSize == size) {
            return false;
        }
        if(tail == size - 1) {
            data[0] = value;
            tail = 0;
        }else {
            data[++tail] = value;
        }
        curSize++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(curSize == 0) {
            return false;
        }
        if(head == size - 1) {
            head = 0;
        }else {
            head++;
        }
        curSize--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(curSize == 0) {
            return -1;
        }
        return data[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(curSize == 0) {
            return -1;
        }
        return data[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return curSize == 0 ? true : false;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return curSize == size ? true : false;
    }
    
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3

        System.out.println(circularQueue.enQueue(1));  // 返回 true

        System.out.println(circularQueue.enQueue(2));  // 返回 true

        System.out.println(circularQueue.enQueue(3));  // 返回 true

        System.out.println(circularQueue.enQueue(4));  // 返回 false，队列已满

        System.out.println(circularQueue.Rear());  // 返回 3

        System.out.println(circularQueue.isFull());  // 返回 true

        System.out.println(circularQueue.deQueue());  // 返回 true

        System.out.println(circularQueue.enQueue(4));  // 返回 true

        System.out.println(circularQueue.Rear());  // 返回 4
    }
}
