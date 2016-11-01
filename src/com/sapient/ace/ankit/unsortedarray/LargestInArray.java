package com.sapient.ace.ankit.unsortedarray;

import java.util.Arrays;

public class LargestInArray {

	static void printArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] unsortedArray = {4,1,3,10,9,15,2};
		System.out.println("Unsorted array:");
		LargestInArray.printArray(unsortedArray);
		Arrays.sort(unsortedArray);
		int len = unsortedArray.length;
		System.out.println("Largest element:"+unsortedArray[len-1]);
		System.out.println("2nd Largest element:"+unsortedArray[len-2]);
	}

}
