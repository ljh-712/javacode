/* 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，

* 因此从左下角开始查找，当要查找数字比左下角数字大时。右移

* 要查找数字比左下角数字小时，上移

*/

public class Solution {
    public boolean Find(int target, int [][] array) {
        int rows=array.length;
        int cols=array[0].length;
        int i=rows-1;
        int j=0;
        while(i>=0 && j<cols){
            if(target<array[i][j])
                i--;
            else if(target>array[i][j])
                j++;
            else
                return true;
        }
        return false;
    }
}