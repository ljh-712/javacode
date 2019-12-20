package biteke.bit_stack.implement;


import biteke.bit_stack.Stack;

/**
 * @author :Administrator.
 * @date :2019/12/19 0019
 * @time:18:36
 */
public class LinkStack<T> implements Stack<T> {
    private Node top;//维护栈顶
    private int currentSize;//元素个数
    private T t;//元素值

    private class Node {

        private T t;
        private Node next;

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }
    }



    @Override
    public boolean push(T t) {//要头插
        //先new 一个新节点
        Node node=new Node(t,null);
        //如果栈为空
        if(top==null) {
            top=node;
        }else {
            node.next=top;
            top=node;
        }
        currentSize++;
        return true;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println("当前栈为空");
            return null;
        }
        T ret=top.t;
        top=top.next;
        currentSize--;
        return ret;


    }

    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("当前栈为空");
            return null;
        }
        return top.t;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize==0;
    }
}
