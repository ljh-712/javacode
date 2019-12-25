package commenbit.bit_queue.implement;

import commenbit.bit_queue.Queue;

/**
 * @author :Administrator.
 * @date :2019/12/20 0020
 * @time:13:14
 */
public class ArrayLoopQueue<E> implements Queue<E> {
    private Object[] elementData;
    private int head;
    private int tail;
    private int size;
    public  ArrayLoopQueue(int maxSize) {
        elementData=new Object[maxSize+1];//多加一块空间来判断该环形队列是否为空
    }
    @Override
    public void enQueue(E e) {
        if ((tail+1)%elementData.length==head) {//判满
            System.err.println("队列已满");
            return;
        }else {
            elementData[tail]=e;
            tail=(tail+1)%elementData.length;
            size++;
        }

    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            System.err.println("队列为空");
            return null;
        }
        E result=(E)elementData[head];
        head=(head+1)%elementData.length;
        size--;
        return result;
    }





    @Override
    public E peek() {
        if (isEmpty()) {
            System.err.println("队列为空");
            return null;
        }

        return (E)elementData[head];

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head==tail;
    }
}
