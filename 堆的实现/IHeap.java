package commenbit.heap;

/**
 * @author :Administrator.
 * @date :2019/12/27 0027
 * @time:12:57
 */
public interface IHeap {
    //向下调整
    void adjustDown(int root,int len);
    //初始化
    void initHeap(int[] array);
    //向上调整
    void adjustUp(int child);
    //插入item到堆中
    void pushHeap(int item);
    //返回堆顶元素，删除数据元素
    int popHeap();
    //返回堆顶元素，不删除数据
    int getHeapTop();
    //堆排序
    void HeapSort();
    //打印堆
    void show();


}
