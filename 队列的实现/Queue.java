package commenbit.bit_queue;

/**
 * @author :Administrator.
 * @date :2019/12/20 0020
 * @time:11:09
 */

/**
 * 队列LTFO先进先出
 * 在队尾插入，在队首取得元素
 * 阻塞队列缓存
 * @param <E>
 */
public interface Queue<E> {
    //入队,在队尾
    void enQueue(E e);
    //出队，在队首
    E deQueue();
    //返回队首元素，但不出队
    E peek();
    //求队列长度
    int getSize();
    //判断是否为空
    boolean isEmpty();
}
