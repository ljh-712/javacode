package commenbit.heap;

import java.util.Arrays;

/**
 * @author :Administrator.
 * @date :2019/12/27 0027
 * @time:13:07
 */
public class TestHeap implements IHeap {
    private int[] elem;
    private int usedSize;
    private final int DEFAULT_SIZE=10;
    public TestHeap() {
        this.elem=new int[DEFAULT_SIZE];
        this.usedSize=0;
    }

    @Override
    public void initHeap(int[] array) {
        for (int i=0;i<array.length;i++) {
            this.elem[i]=array[i];
            this.usedSize++;
        }
        for (int i = (elem.length-1-1)/2; i>=0  ; i--) {
            adjustDown(i,this.usedSize);

        }
    }
    @Override
    public void adjustDown(int root, int len) {
        int parent=root;
        int child=parent*2+1;
        while(child<len) {
            if (child+1<len&&elem[child+1]>elem[child]) {
                child++;

            }
            if (elem[parent]<elem[child]) {
                int t=elem[parent];
                elem[parent]=elem[child];
                elem[child]=t;
                parent=child;
                child=parent*2+1;
            }else {
                break;
            }
        }
    }

    @Override
    public void adjustUp(int child) {
        int parent=(child-1)/2;
        while(child>0) {
            if (elem[child]>elem[parent]) {
                int t=elem[child];
                elem[child]=elem[parent];
                elem[parent]=t;
                child=parent;
                parent=(child-1)/2;
            }else {
                break;
            }
        }
    }
    public boolean isFull() {
        if (this.usedSize==this.elem.length) {
            return true;
        }
        return false;
    }
    @Override
    public void pushHeap(int item) {
        if (isFull()) {//扩容
            this.elem= Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[this.usedSize]=item;
        this.usedSize++;
        adjustUp(this.usedSize-1);

    }

    @Override
    public int popHeap() {
        if (this.usedSize==0) {
            throw new UnsupportedOperationException("堆为空");
        }
        int t=this.elem[0];
        elem[0]=elem[this.usedSize-1];
        elem[usedSize-1]=t;
        this.usedSize--;
        adjustDown(0,this.usedSize);
        return 0;
    }

    @Override
    public int getHeapTop() {
        if (this.usedSize==0) {
            throw new UnsupportedOperationException("堆为空");
        }
        return this.elem[0];
    }

    @Override
    public void HeapSort() {
        int end=this.usedSize-1;
        while (end>0) {
            int t=elem[0];
            elem[0]=elem[end];
            elem[end]=t;
            adjustDown(0,end);
            end--;
        }

    }

    @Override
    public void show() {
        for (int i = 0; i <this.usedSize ; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
}
