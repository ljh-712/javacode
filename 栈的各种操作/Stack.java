package biteke.bit_stack;

/**
 * @author :Administrator.
 * @date :2019/12/19 0019
 * @time:18:15
 */
/*
栈、

先进后出LTFO
栈也是一种线性表，只允许在一端插入和删除元素
栈顶：数据插入与删除的一端
栈的实现：
入栈：push
出栈：pop
返回栈顶元素：peek

顺序栈：基于数组实现
链栈：基于链表实现
 */
public interface Stack <T>{
    /**
     * 入栈
     */
    boolean push(T t);
    /**
     * 出栈
     */
    T pop();
    /**
     * 返回栈顶元素但不出栈
     */
    T peek();
    /**
     * 返回栈元素个数
     */
    int getSize();
    /**
     * 是否为空
     */
    boolean isEmpty();

}

