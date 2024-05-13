
public class Main {
    public static void main(String[] args) {
        ArrayCreator arrayCreator = new ArrayCreator();
        int[] array = arrayCreator.create(1000);
        //bubbleSort(array);
        //insertionSort(array);
        array = mergeSort(array);
        for (int num: array) {
            System.out.println(num);
        }
    }

    //sortowanie bąbelkowe
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for(int i=0;i<=n-1;i++) {
            for(int j=0;j<n-i-1;j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j+1] = temp;
                }
            }
        }
    }

    //sortowanie przez podstawianie
    public static void insertionSort(int[] array) {
        int n = array.length;
        for(int i=1;i<n;i++) {
            int j = i;
            while (j > 0 && array[j-1] > array[j]) {
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j = j-1;
            }
        }
    }

    //sortowanie przez scalanie
    public static int[] mergeSort(int[] array) {
        int n = array.length;
        if(n == 1) {
            return array;
        }

        int[] leftArr = new int[n/2];
        int[] rightArr = new int[n - n/2];
        System.arraycopy(array, 0, leftArr, 0, n/2);
        System.arraycopy(array, n/2, rightArr, 0, n-n/2);

        leftArr = mergeSort(leftArr);
        rightArr = mergeSort(rightArr);

        return merge(leftArr, rightArr);
    }

    private static int[] merge(int[] leftArr, int[] rightArr) {
        int[] mergedArr = new int[leftArr.length + rightArr.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;

        while(leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if(leftArr[leftIndex] <= rightArr[rightIndex]) {
                mergedArr[mergedIndex] = leftArr[leftIndex];
                leftIndex++;
            } else {
                mergedArr[mergedIndex] = rightArr[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }
        while (leftIndex < leftArr.length) {
            mergedArr[mergedIndex] = leftArr[leftIndex];
            mergedIndex++;
            leftIndex++;
        }
        while (rightIndex < rightArr.length) {
            mergedArr[mergedIndex] = rightArr[rightIndex];
            mergedIndex++;
            rightIndex++;
        }
        return mergedArr;
    }

}