package com.greatlearning.services;

public class LinearSearch {
	public int search(double[]arr, double key, int size) {
		for(int i=0; i<size; i++) {
			if(arr[i] == key) {
				return i;
			}
		}
		return -1;
	}
}
