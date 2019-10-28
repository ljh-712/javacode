import java.util.Arrays;

/**
 * @author :Administrator.
 * @date :2019/10/27 0027
 * @time:8:37
 */
class MyArrayList {
    public int usedSize;
    public int[] elem;
    public final int CAPACITY = 10;
    public MyArrayList() {
        this.usedSize = 0;
        this.elem = new int[CAPACITY];
    }
    private  boolean isFull() {//判断是否为满
        if(this.usedSize==this.elem.length) {
            return true;
        }
        return false;
    }
    private int []toLen() {//实现扩容
            return Arrays.copyOf(this.elem,this.elem.length*2);
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //1、pos是否合法
        if(pos<0||pos>elem.length) {
            throw new IndexOutOfBoundsException("下标越界");
        }
        if(isFull()) {
            this.elem=toLen();
        }
        //2、挪数据
        for(int i=this.usedSize-1;i>=pos;i--) {
            elem[i+1]=elem[i];
        }
        //3、插入数据
        this.elem[pos]=data;
        //4、usedSize++
        usedSize++;
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i <this.usedSize ; i++) {
            if (toFind == this.elem[i]) {
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (toFind ==this.elem[i]) {
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos<0||pos>this.usedSize) {
            return -1;
        }
        for (int i = 0; i < usedSize; i++) {
            if (i==pos) {
                return this.elem[i];
            }
        }
        return -1;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        //判空
        if(this.usedSize==0) {
            throw new ArrayStoreException("顺序表空");
        }

                for (int j= search(toRemove); j<this.usedSize-1; j++) {
                    elem[j]=elem[j+1];
                }
                this.usedSize--;



        }

    // 获取顺序表长度
    public int size() { return 0; }
    // 清空顺序表
    public void clear() {
        this.usedSize=0;
    }
    // 打印顺序表
    public void display() {
        for (int i = 0; i <this.usedSize ; i++) {
            System.out.print(elem[i]+" ");
        }
        System.out.println();
    }
}
public class Sep27 {
    public static void main(String[] args) {
        MyArrayList list=new MyArrayList();
        MyArrayList list2=new MyArrayList();
        list.add(0,1);
        list.add(0,2);
        list.add(0,3);
        list.add(0,4);
        list.add(0,5);
        list.add(3,1);
        list.add(3,1);
        list.add(4,1);
        list.display();
        //System.out.println(list.search(5));
        //System.out.println(list.contains(0));
        //System.out.println(list.getPos(1));
        list.remove(4);
        list.display();
        list.clear();
       //list.display();

    }
}
