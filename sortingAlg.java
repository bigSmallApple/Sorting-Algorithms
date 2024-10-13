package sortingAlg;

import java.util.Arrays;
import java.util.Random;

public class SortingAlg {

    public static void main(String[] args) {
        //Generates the different size arrays
        int[] fiftyKArray = generateArray(50000);
        int[] tenKArray = generateArray(100000);
        int[] fTeenKArray = generateArray(150000);
        int[] twenKArray = generateArray(200000);
        int[] twen5KArray = generateArray(250000);
        int[] thirtyKArray = generateArray(300000);

        int[] twoMilArray = generateArray(2000000);
        int[] threeMilArray = generateArray(3000000);
        int[] fourMilArray = generateArray(4000000);
        int[] fiveMilArray = generateArray(5000000);

        System.out.printf("""
                   This is time in miliseconds      
                          
                   Arrary\t\tSelection\t\tInsertion\t\tBubble\t\tMerge\t\tQuick
                   Size  \t\tSort     \t\tSort     \t\tSort  \t\tSort \t\tSort
                   50000 \t\t%6d    \t\t%6d     \t\t%6d  \t%6d  \t%6d       
                   100000 \t\t%6d    \t\t%6d     \t\t%6d  \t%6d  \t%6d
                   150000 \t\t%6d    \t\t%6d     \t\t%6d  \t%6d  \t%6d
                   200000 \t\t%6d    \t\t%6d     \t\t%6d  \t%6d  \t%6d
                   250000 \t\t%6d    \t\t%6d     \t\t%6d  \t%6d  \t%6d
                   300000 \t\t%6d    \t\t%6d     \t\t%6d  \t%6d  \t%6d
                   \n""",
                selectSortTime(copyArray(fiftyKArray)), insertSortTime(copyArray(fiftyKArray)), bubbleSortTime(copyArray(fiftyKArray)), mergeSortTime(copyArray(fiftyKArray)), quickSortTime(copyArray(fiftyKArray)),
                selectSortTime(copyArray(tenKArray)), insertSortTime(copyArray(tenKArray)), bubbleSortTime(copyArray(tenKArray)), mergeSortTime(copyArray(tenKArray)), quickSortTime(copyArray(tenKArray)),
                selectSortTime(copyArray(fTeenKArray)), insertSortTime(copyArray(fTeenKArray)), bubbleSortTime(copyArray(fTeenKArray)), mergeSortTime(copyArray(fTeenKArray)), quickSortTime(copyArray(fTeenKArray)),
                selectSortTime(copyArray(twenKArray)), insertSortTime(copyArray(twenKArray)), bubbleSortTime(copyArray(twenKArray)), mergeSortTime(copyArray(twenKArray)), quickSortTime(copyArray(twenKArray)),
                selectSortTime(copyArray(twen5KArray)), insertSortTime(copyArray(twen5KArray)), bubbleSortTime(copyArray(twen5KArray)), mergeSortTime(copyArray(twen5KArray)), quickSortTime(copyArray(twen5KArray)),
                selectSortTime(copyArray(thirtyKArray)), insertSortTime(copyArray(thirtyKArray)), bubbleSortTime(copyArray(thirtyKArray)), mergeSortTime(copyArray(thirtyKArray)), quickSortTime(copyArray(thirtyKArray)));

        System.out.println("That table shows times for larger array sizes.\nIf an sorting algorithm took more than 3 hours, the time will says TTL (took too long)\n");

        System.out.println("Selection Sort:");
        System.out.println("2,000,000 " + selectSortTime(copyArray(twoMilArray)));
        System.out.println("3,000,000 " + selectSortTime(copyArray(threeMilArray)));
        System.out.println("4,000,000 " + selectSortTime(copyArray(fourMilArray)));
        System.out.println("5,000,000 " + selectSortTime(copyArray(fiveMilArray)));

        System.out.println("\nBubble Sort:");
        System.out.println("2,000,000 " + "TTL");  //I have run these seperatly and got the time
        System.out.println("3,000,000 " + "TTL");  //The times were well over 3 hours, so I coded the output to say TTL
        System.out.println("4,000,000 " + "TTL");  //I have included the screenshots of the long times
        System.out.println("5,000,000 " + "TTL");

        System.out.println("\nInsertion Sort:");
        System.out.println("2,000,000 " + insertSortTime(copyArray(twoMilArray)));
        System.out.println("3,000,000 " + insertSortTime(copyArray(threeMilArray)));
        System.out.println("4,000,000 " + insertSortTime(copyArray(fourMilArray)));
        System.out.println("5,000,000 " + insertSortTime(copyArray(fiveMilArray)));

        System.out.println("\nMerge Sort:");
        System.out.println("2,000,000 " + mergeSortTime(copyArray(twoMilArray)));
        System.out.println("3,000,000 " + mergeSortTime(copyArray(threeMilArray)));
        System.out.println("4,000,000 " + mergeSortTime(copyArray(fourMilArray)));
        System.out.println("5,000,000 " + mergeSortTime(copyArray(fiveMilArray)));

        System.out.println("\nQuickSort:");
        System.out.println("2,000,000 " + quickSortTime(copyArray(twoMilArray)));
        System.out.println("3,000,000 " + quickSortTime(copyArray(threeMilArray)));
        System.out.println("4,000,000 " + quickSortTime(copyArray(fourMilArray)));
        System.out.println("5,000,000 " + quickSortTime(copyArray(fiveMilArray)));
    }

    static public int[] generateArray(int length) {
        int[] array = new int[length];
        Random randomInt = new Random(); //Genereates random numbers

        for (int i = 0; i < length; i++) {
            array[i] = randomInt.nextInt(5001) - 2500; //Fills the array with random integers ranging from -2500 to 2500
        }
        return array;
    }

    static public int[] copyArray(int[] array) {
        return Arrays.copyOf(array, array.length); //copies the array
    }

    static public long selectSortTime(int[] array) {
        long startTime = System.currentTimeMillis();    // get start time
        //selection sort task

        int[] sequenceS = Arrays.copyOf(array, array.length);
        int arrayLength = sequenceS.length;

        for (int i = 0; i < arrayLength - 1; i++) {  //this loop selects the first index you will be comparing stuuff to 
            int minIndex = i;   //this is the index (location) of that value

            for (int j = i + 1; j < arrayLength - 1; j++) {   //this will select the others and compare the value to the first
                if (sequenceS[j] < sequenceS[minIndex]) {    //this does the comparing
                    minIndex = j;   //this switches the index of the smallest if a smaller value is found
                }
            }

            int smallerNumber = sequenceS[minIndex];
            sequenceS[minIndex] = sequenceS[i];
            sequenceS[i] = smallerNumber;

        }
        long endTime = System.currentTimeMillis();  //get end time
        long executionTime = endTime - startTime;   //calculate task duration
//        System.out.println("Select: " + arrayLength + " | countOp:" + countOp + " | countLo:" + countLo);
        return executionTime;   //return task duraction
    }

    static public long insertSortTime(int[] array) {
        long startTime = System.currentTimeMillis();    // get start time
        //insertion sort task
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j -= 1;
            }
            array[j + 1] = key;
        }
        long endTime = System.currentTimeMillis();  //get end time
        long executionTime = endTime - startTime;   //calculate task duration
//        System.out.println("Insert: " + length + " | countOp:" + countOp + " | countLo:" + countLo);
        return executionTime;   //return task duraction
    }

    static public long bubbleSortTime(int[] array) {
        long startTime = System.currentTimeMillis();    // get start time
        //bubble sort task
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        long endTime = System.currentTimeMillis();  //get end time
        long executionTime = endTime - startTime;   //calculate task duration
        return executionTime;   //return task duraction
    }

    static public long mergeSortTime(int[] array) {
        long startTime = System.currentTimeMillis();    // get start time
        //merge sort task
        mergeSort(array, array.length);
        long endTime = System.currentTimeMillis();  //get end time
        long executionTime = endTime - startTime;   //calculate task duration
        return executionTime;   //return task duraction       
    }

    public static void mergeSort(int[] array, int length) {
        if (length < 2) {   //base case to stop partion in array is 1 length long
            return;
        }
        int mid = length / 2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[length - mid];

        System.arraycopy(array, 0, leftHalf, 0, mid); //copies the left half
        for (int i = mid; i < length; i++) {  //copies the right half
            rightHalf[i - mid] = array[i];
        }
        mergeSort(leftHalf, mid);   //calls itself to further split the left half until it is one elelemnt long
        mergeSort(rightHalf, length - mid); //calls itself to further split the right half until it is one elelemnt long

        merge(array, leftHalf, rightHalf, mid, length - mid);   //calls merege to merge and sort the two halfs
    }

    public static void merge(int[] array, int[] leftHalf, int[] rightHalf, int leftLength, int rightLength) {
        int i = 0, j = 0, k = 0;    // Initializing pointers for leftHalf (i), rightHalf (j), and merged array (k)
        while (i < leftLength && j < rightLength) {
            if (leftHalf[i] <= rightHalf[j]) {   // If the current element in leftHalf is smaller or equal to the current element in rightHalf
                array[k++] = leftHalf[i++];      // Put the element from leftHalf into the merged array and increment both leftHalf and merged array pointers
            } else {
                array[k++] = rightHalf[j++];     // Otherwise, put the element from rightHalf into the merged array and increment both rightHalf and merged array pointers
            }
        }
        // If there are any remaining elements in leftHalf or rightHalf, add them to the merged array
        while (i < leftLength) {
            array[k++] = leftHalf[i++];    // Add remaining elements from leftHalf to the merged array
        }
        while (j < rightLength) {
            array[k++] = rightHalf[j++];   // Add remaining elements from rightHalf to the merged array
        }
    }

    static public long quickSortTime(int[] array) {
        long startTime = System.currentTimeMillis();    // get start time
        //quick sort task
        quickSort(array, 0, array.length - 1);
        long endTime = System.currentTimeMillis();  //get end time
        long executionTime = endTime - startTime;   //calculate task duration
        return executionTime;   //return task duraction       
    }

    static void quickSort(int[] array, int low, int high) {
        if (low < high) { // If the array has more than one element

            // Partition the array and get the index of the pivot element
            int pi = partition(array, low, high);

            // Recursively sort the subarrays before and after the pivot element
            quickSort(array, low, pi - 1);  // Sort the left subarray
            quickSort(array, pi + 1, high); // Sort the right subarray
        }
    }

    static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Select the pivot element (in this implementation, it's the last element)

        int i = (low - 1); // Index of smaller element

        // Iterate through the array and move elements smaller than the pivot to the left side of the pivot
        for (int j = low; j <= high - 1; j++) {
            if (array[j] < pivot) { // If current element is smaller than the pivot
                i++; // Increment index of smaller element
                swap(array, i, j); // Swap array[i] and array[j]
            }
        }
        swap(array, i + 1, high); // Swap the pivot element (which is at index high) with the element at index i + 1
        return (i + 1); // Return the index of the pivot element after partitioning
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i]; // Temporary variable to hold the value of array[i]
        array[i] = array[j]; // Assign the value of array[j] to array[i]
        array[j] = temp; // Assign the value of temp (initially array[i]) to array[j]
    }

}
