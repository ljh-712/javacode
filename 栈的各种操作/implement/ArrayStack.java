package biteke.bit_stack.implement;

import biteke.bit_stack.Stack;

import java.util.Arrays;

/**
 * @author :Administrator.
 * @date :2019/12/19 0019
 * @time:18:21
 */
public class ArrayStack<T> implements Stack<T> {
    private Object[] elementData;//存放数据
    private int maxSize;//最多存放数据的个数
    private int curentSize;//当前栈中的元素个数
//构造方法对数组进行初始化
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.elementData=new Object[maxSize];
    }

    @Override
    public boolean push(T t) {
        //判断栈满
        if (curentSize==maxSize) {
//            System.out.println("栈已满无法放置新元素");
//           return false;
            //扩容
            int oldSize=maxSize;
            int newSize=oldSize<<1;
            if (newSize+8>Integer.MAX_VALUE) {
                System.out.println("栈太大");
                return false;
            }else {
                maxSize=newSize;
                elementData=Arrays.copyOf(elementData,maxSize);
            }
        }
        elementData[curentSize++]=t;
        return true;

    }

    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return null;
        }
        return (T)elementData[--curentSize];//
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return null;
        }
        return (T)elementData[curentSize-1];
    }

    @Override
    public int getSize() {
        return curentSize;
    }

    @Override
    public boolean isEmpty() {
        return curentSize==0;
    }
}
