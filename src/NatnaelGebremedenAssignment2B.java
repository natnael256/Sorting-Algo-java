import java.util.Scanner;
public class NatnaelGebremedenAssignment2B {
    public static void main(String[] args) {
       // crating intger Array to hold user input
        int [] natnaelGebremedenArray = natnaelGebremedenGetArray();
        System.out.println("Integer number form the user");
        natnaelGebremedenPrintArray(natnaelGebremedenArray);

        // Sort the array using insertion sort
        System.out.println("\nINSERTION SORT");
        int[] YourNameArrayI = natnaelGebremedenCopyArray(natnaelGebremedenArray);
        natnaelGebremedenInsertionSort(YourNameArrayI);
        natnaelGebremedenPrintArray(YourNameArrayI);

        // Sort the array using bubble sort
        System.out.println("\nBUBBLE SORT");
        // coping the original Array
        int[] natnaelGebremedenArrayB = natnaelGebremedenCopyArray(natnaelGebremedenArray);
        natnaelGebremedenBubbleSort(natnaelGebremedenArrayB);
        natnaelGebremedenPrintArray(natnaelGebremedenArrayB);

        // Sort the array using merge sort
        System.out.println("\nMERGE SORT");
        // coping the original Array
        int[] natnaelGebremedenArrayM = natnaelGebremedenCopyArray(natnaelGebremedenArray);
        natnaelGebremedenMergeSort(natnaelGebremedenArrayM);
        natnaelGebremedenPrintArray(natnaelGebremedenArrayM);

        // Sort the array using quick sort
        System.out.println("\nQUICK SORT");
        // coping the original Array
        int[] natnaelGebremedenArrayQ = natnaelGebremedenCopyArray(natnaelGebremedenArray);
        natnaelGebremedenQuickSort(natnaelGebremedenArrayQ);
        natnaelGebremedenPrintArray(natnaelGebremedenArrayQ);

    }
    public static int[] natnaelGebremedenGetArray() {
        Scanner scanner = new Scanner(System.in);
        int[] A = new int[10];
        System.out.println("Enter 10 integer numbers: ");
        for (int i = 0; i < 10; i++) {
            A[i] = scanner.nextInt();
        }
        return A;
    }

    public static int[] natnaelGebremedenCopyArray(int A[]) {
        int B[] = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i];
        }
        return B;
    }

    public static void natnaelGebremedenPrintArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + "\t");
        }
        System.out.println();
    }

    public static void  natnaelGebremedenInsertionSort (int [] A){
        for (int i = 1;  i < A.length; i++){
            int currentElement = A[i];
            int k;
            for (k = i - 1; k>= 0 && A[k] > currentElement; k-- ) {
                A[k+1] = A [k];
            }
            A[k+1] = currentElement;
        }
    }

    public static void natnaelGebremedenBubbleSort (int [] A){
        boolean needNextPass = true;
        for (int k = 1; k < A. length && needNextPass; k++){
            needNextPass = false;
            for (int i = 0 ; i < A.length - k; i++ ){
                if (A[i] > A[i+1]){
                    int temp = A[i];
                    A[i] = A[i+1];
                    A[i+1] = temp;
                    needNextPass = true;
                }
            }
        }
    }
    public static void  natnaelGebremedenMergeSort (int [] A){
        if (A.length > 1) {
            int [] firstHalf = new int [A.length/2];
            System.arraycopy(A , 0 , firstHalf, 0 , A.length/2);
            natnaelGebremedenMergeSort(firstHalf);
            // merge sort the second half
            int secondHalfLength = A.length - A.length/2;
            int [] secondHalf = new int [secondHalfLength];
            System.arraycopy(A,A.length/2,secondHalf,0 ,secondHalfLength);
            natnaelGebremedenMergeSort(secondHalf);
            // merging the both half by invoking the merge method
            merge(firstHalf,secondHalf,A);
        }

    }
    public static void  natnaelGebremedenQuickSort (int [] A){
        natnaelGebremedenQuickSort(A , 0 , A.length - 1);
    }
    public static void  natnaelGebremedenQuickSort (int [] A,int first, int last){
        if ( last> first) {
            int pivotIndex = partition (A, first, last);
            natnaelGebremedenQuickSort (A, first, pivotIndex - 1);
            natnaelGebremedenQuickSort (A, pivotIndex + 1, last);
        }

    }
    public  static void merge(int [] list1 ,int [] list2,int [] temp ){
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;
        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2]) {
                temp[current3++] = list1[current1++];
            } else {
                temp[current3++] = list2[current2++];
            }
        }
        while (current1 < list1.length) {
            temp[current3++] = list1[current1++];
        }

        while (current2 < list2.length) {
            temp[current3++] = list2[current2++];
        }
    }

    public static int partition(int[] list, int first, int last) {
        int pivot = list[first];
        int low = first + 1;
        int high = last;
        // Search forward from left
        while (high > low) {
            while (low <= high && list[low] <= pivot) {
                low++;
            }
            // Sarch backward from right
            while (low <= high && list[high] > pivot) {
                high--;
            }
            // swap two elements in the list if (high low)
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        while (high > first && list[high] >= pivot) {
            high--;
        }
        // Swap pivot ith list[high]
        if (pivot != list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }
}
