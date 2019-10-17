public static void sum(int [][]arr) {
        int sum1 = 0;
        int sum2 = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    sum1 = sum1 + arr[i][i];
                }if(i+j==2) {
                    sum2=sum2+arr[i][j];
                }

            }
        }
        System.out.println(sum1);
        System.out.println(sum2);
    }