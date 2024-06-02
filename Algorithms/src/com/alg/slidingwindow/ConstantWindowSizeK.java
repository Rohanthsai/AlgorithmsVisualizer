package com.alg.slidingwindow;

public class ConstantWindowSizeK {
public static void main(String[] args) {
	int arr[] = {2,5,1,7,10};
	int k = 3; // size of the window
	maxSumOfK(arr,k);
	
	maxSumOfKreturnElements(arr,k);
			
}

private static void maxSumOfK(int[] arr,int k) {
	int n = arr.length;
	int maxSum = Integer.MIN_VALUE;
	int winSum =0; 
	for(int i=0;i<k;i++) {
		winSum = winSum +arr[i];
	}
	maxSum = winSum;
	
	
	for(int i=k;i<n;i++) {
		winSum = winSum -arr[i-k]+arr[i];
		
		maxSum = Math.max(maxSum, winSum);
		
	}
	System.out.println(maxSum);
	
}

private static void maxSumOfKreturnElements(int arr[],int k) {
	int n =arr.length;
	int maxSum =Integer.MIN_VALUE;
	int winSum = 0;
	int si=0, ei=0;
	for(int i=0;i<k;i++) {
		winSum = winSum +arr[i];
	}
	maxSum = winSum;
	
	for(int i=k;i<n;i++) {
		winSum = winSum -arr[i-k]+arr[i];
		if(maxSum < winSum) {
			maxSum = winSum;
			si = i-k;
			ei = i;
		}
	}
//	System.out.println(maxSum);
//	System.out.println(si);
//	System.out.println(ei);
	for(int i=si;i<ei;i++) {
		System.out.print(arr[i]+" ");	// printing max sum elements
	}
}
}
