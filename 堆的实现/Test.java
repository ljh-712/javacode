package commenbit.heap;

/**
 * @author :Administrator.
 * @date :2019/12/27 0027
 * @time:14:28
 */
public class Test {
    public static void main(String[] args) {
        TestHeap heap=new TestHeap();
        int arr[]={1,2,3,4,5,6,7,8,9};
        heap.initHeap(arr);
        heap.show();
        heap.pushHeap(10);
        heap.show();
        heap.popHeap();
        heap.show();
        heap.HeapSort();
        heap.show();
    }
}
