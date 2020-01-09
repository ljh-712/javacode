package commenbit.sort1222;

import java.util.Random;

/**
 * @author :Administrator.
 * @date :2019/12/22 0022
 * @time:16:33
 */
public class Testinsert {
    public static void insertSort(int[] array) {
        long s=System.currentTimeMillis();
        int n=array.length;
        if(n<=1) {
            return;
        }else {
            for (int i = 1; i <n ; i++) {
                //待排序的第一个元素
                int value=array[i];
                //已排序的最后一个元素下标
                int j=i-1;
                for (; j >=0 ; j--) {//有序的块
                    if (value<array[j]) {
                        array[j+1]=array[j];
                    }else {//直接跳出
                        break;
                    }
                }
                //找到要插入的位置
                array[j+1]=value;//4,5,6,1,2,3中5比六大，此时j=0,5应该放在j+之后
            }
        }
        long e=System.currentTimeMillis();
        System.out.println(e-s);

    }
    public static void main(String[] args) {
        int arr[]=new int[100000];
        Random random=new Random();
        int left=50;
        int right=100000;
        for (int i =0 ; i <100000 ; i++) {
            arr[i]=random.nextInt(right)+left+1;

        }
        insertSort(arr);
        //System.out.println(Arrays.toString(arr));
    }
}
