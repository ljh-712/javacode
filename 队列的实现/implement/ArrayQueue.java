package commenbit.bit_queue.implement;

import commenbit.bit_queue.Queue;

/**
 * @author :Administrator.
 * @date :2019/12/20 0020
 * @time:11:39
 */
public class ArrayQueue<E> implements Queue<E> {
    private  Object[] elementData;//存放数据的数组，注意不能是E[] elementData,因为泛型不能new 一个数组
    private int head;
    private int tail;

    public ArrayQueue(int maxSize) {//通过构造方法初始化队列的最大长度
        elementData = new Object[maxSize];
    }

    @Override
    public void enQueue(E e) {
        if (tail==elementData.length) {//判队满
            if (head==0) {
                System.err.println("当前队列已满");
                return;
            }else {//数据搬移
                for (int i = head; i <tail ; i++) {
                    elementData[i-head]=elementData[i];
                }
                tail=tail-head;
                head=0;//重新赋值头尾节点

            }

        }
        elementData[tail++]=e;//先取值再++

    }
//    public void enQueue(E e) {
//        if (tail==elementData.length) {//判队满
//            System.err.println("当前队列已满");
//            return;
//        }
//        elementData[tail++]=e;//先取值再++
//
//    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            System.err.println("当前队列为空");
            return null;
        }else {
            return (E)elementData[head++];

        }

    }

    @Override
    public E peek() {
        if (isEmpty()) {
            System.err.println("当前队列为空");
            return null;
        }else {
            return (E)elementData[head];
        }
    }

    @Override
    public int getSize() {
        return tail-head;
    }

    @Override
    public boolean isEmpty() {
        return head==tail;
    }
}
