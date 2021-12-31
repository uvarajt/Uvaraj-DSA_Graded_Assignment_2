package com.greatlearning.services;

public class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(double arr[], int l, int m, int r, char order)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        double L[] = new double[n1];
        double R[] = new double[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
        	if(order == 'a') {
        		if (L[i] <= R[j]) {
        			arr[k] = L[i];
        			i++;
        		}else {
        			arr[k] = R[j];
        			j++;
        		}
        	}else if(order == 'd') {
        		if (L[i] >= R[j]) {
        			arr[k] = L[i];
        			i++;
        		}else {
        			arr[k] = R[j];
        			j++;
        		}
        	}
        	k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
  
    // Main function that sorts arr[l..r] using
    // merge()
    public void sort(double arr[], int l, int r, char order)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            sort(arr, l, m, order);
            sort(arr, m + 1, r, order);
  
            // Merge the sorted halves
            merge(arr, l, m, r, order);
        }
    }
}
