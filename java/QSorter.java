    public static int partition(int[] a, int start, int end, int pivot) {
        int pivotValue = a[pivot];
        int index = start;
        swap(a, start, pivot);
        for (int i = start; i < end; i++) {
            if (pivotValue > a[i]) {
                swap(a, index, i);
                index++;
            }
        }
        return index;
    }

    public static void qsort(int[] a, int start, int end) {
        if (end > start) {
            Random rand = new Random();
            int pivot = rand.nextInt(end - start) + start;
            int newPivot = partition(a, start, end, pivot);
            qsort(a, start, newPivot - 1);
            qsort(a, newPivot + 1, end);
        }
    }
