package biteke.bit_stack;

import biteke.bit_stack.implement.ArrayStack;
import biteke.bit_stack.implement.LinkStack;

/**
 * @author :Administrator.
 * @date :2019/12/19 0019
 * @time:18:08
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
/**
 * 栈的应用：操作系统虚拟机
 * 函数调用
 * 表达式求值
 * 括号匹配
 */


public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack=new ArrayStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.getSize());
        System.out.println(stack.peek());
//        Stack<Integer> stack1=new LinkStack<>();
//        stack1.push(1);
//        stack1.push(2);
//        stack1.push(3);
//        stack1.push(4);
//        stack1.push(5);
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack.getSize());
//        System.out.println(stack.peek());
    }
}
