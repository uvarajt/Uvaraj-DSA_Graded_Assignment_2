package com.greatlearning.services;

public class Count {
	public int count(boolean[] arr, boolean check) {
		int cnt=0;
		for(int j=0; j<arr.length; j++) {
			if(arr[j] == check) {
				cnt++;
			}
		}
		return cnt;
	}

}
