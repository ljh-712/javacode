 /*
    求数组最大值
     */
    public static int max(int []arr) {
        int maxv=arr[0];
        for(int i=0;i<arr.length;i++) {

            if(arr[i]>maxv) {
                maxv=arr[i];
            }
        }
        return maxv;
    }
    /*
    求最小值
     */
    public static int min(int []arr) {
        int minn=arr[0];
        for(int i=0;i<arr.length;i++) {

            if(arr[i]<minn) {
                minn=arr[i];
            }
        }
        return minn;
    }
    /*
    求平均数
     */
    public static double ave(int []arr) {
        int sum=0;
        for (int i = 0; i <arr.length ; i++) {
            sum=sum+arr[i];
        }
        return (double)sum / (double)arr.length;
    }
    /*
    逆置
     */
    public static void reverse(int []arr) {
        int left=0;
        int right=arr.length-1;
        while(left<right) {
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    /*
    奇数放前，偶数放后
     */
    public static void fun3(int []arr) {
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            while (arr[left] % 2 == 1 && left < right) {
                left++;
            }
            while (arr[right] % 2 == 0 && left < right) {
                right--;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    /*
  数组转字符串
  */
    public static String tostring(int[] array) {
        String ret = "[";
        for (int i = 0; i < array.length; i++) {
            ret = ret + array[i];
            if (i != array.length - 1) {
                ret = ret + ",";
            }
        }
        ret = ret + "]";
        return ret;
    }
/*
调用Arrays方法数组转字符串输出
 */
    public static void main(String[] args) {
        int []arr={12,2,3,4,5};
        System.out.print(Arrays.toString(arr));

    }
    /*
    数组所有元素乘2
     */
    public static int []fun2(int[] arr) {
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = arr[i] * 2;
        }
        return ret;
    }
    public static void fun(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] * 2 + " ");
        }
    }
    /*
    递归版二分法
     */
    public static int binarySearch(int []arr,int key,int left,int right) {
        if(left<=right) {
            int mid=(left+right)/2;
            if(key>arr[mid]) {
                left=mid+1;
                return binarySearch(arr,key,left,right);
            }else if(key==arr[mid]) {
                return mid;
            }else {
                right=mid-1;
                return binarySearch(arr,key,left,right);
            }
        }
        return -1;
    }