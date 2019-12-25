package commenbit.bit_queue.implement;

import commenbit.bit_queue.Queue;

/**
 * @author :Administrator.
 * @date :2019/12/20 0020
 * @time:11:16
 */
public class LinkedQueue<E> implements Queue<E> {
    private Node head;//当前队列头节点
    private Node tail;//当前队列尾节点
    private int size;//当前队列长度
    private class Node {
        private E data;
        private Node next;

        public Node(E data, Node node) {
            this.data = data;
            this.next = next;
        }
    }
    @Override
    public void enQueue(E e) {
        Node newNode=new Node(e,null);
        if (head==null) {
            head=tail=newNode;
        }else {
            tail.next=newNode;
            tail=tail.next;
        }
        size++;

    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            System.err.println("队列为空");
            return null;
        }
        E result=head.data;
        head.data=null;//置空便于垃圾回收
        head=head.next;
        size--;
        return result;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            System.err.println("队列为空");
            return null;
        }
        return head.data;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
