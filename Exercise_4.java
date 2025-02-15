class MergeSort 
{ 
    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    void merge(int arr[], int l, int m, int r) 
    {  
       //Your code here
        int size1 = m - l + 1;
        int size2 = r - m;

        /* Create temp arrays */
        int leftArr[] = new int [size1];
        int rightArr[] = new int [size2];

        /*Copy data to temp arrays*/
        for (int i=0; i<size1; ++i)
            leftArr[i] = arr[l + i];
        for (int j=0; j<size2; ++j)
            rightArr[j] = arr[m + 1+ j];


        /* Merging arrays */
        int i = 0, j = 0;


        int k = l;
        while (i < size1 && j < size2)
        {
            if (leftArr[i] <= rightArr[j])
            {
                arr[k] = leftArr[i];
                i++;
            }
            else
            {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        /* remaining elements of leftArray */
        while (i < size1)
        {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        /* remaining elements of rightArray */
        while (j < size2)
        {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int arr[], int l, int r) 
    { 
	//Write your code here
        //Call mergeSort from here
        if(l == r){
            return;
        }
        else {
            int mid = (l + r)/2;
            sort(arr, l, mid);
            sort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
    // Driver method 
    public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
  
        System.out.println("Given Array"); 
        printArray(arr); 
  
        MergeSort ob = new MergeSort(); 
        ob.sort(arr, 0, arr.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
    } 
} 