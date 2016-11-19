    public static void down(int[] a, int i, int end){
        while(2*i+1<end) {
            int j = 2 * i+1;
            if (j + 1 <end && a[j] < a[j + 1]) {
                j++;
            }
            if (a[i] < a[j]) {
                swap(a, i, j);
            }
            i = j;
        }
    }

    public static void buildMaxHeap(int[] a){
        for(int n=a.length/2; n>=0; n--){
            down(a, n, a.length);
        }
    }

    public static void heapSort(int[] a){
        buildMaxHeap(a);
        for(int n=a.length-1;n>0;n--){
            swap(a, 0, n);
            down(a, 0, n);
        }
    }
