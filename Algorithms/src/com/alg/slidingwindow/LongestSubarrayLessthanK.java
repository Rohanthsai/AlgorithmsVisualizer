package com.alg.slidingwindow;

public class LongestSubarrayLessthanK { // varient 2
public static void main(String[] args) {
	int arr[]= {2,5,1,7,10,11,3,1};
	int k = 14;
	extremeBruteForce(arr,k);
	bruteForce(arr,k);
	better(arr,k);
}
private static void extremeBruteForce(int arr[],int k) {
	int n = arr.length; int sum =0; int max = Integer.MIN_VALUE;
	for(int i=0;i<n;i++) {		// approach generate all subarrays
		for(int j=i;j<n;j++) {	// sub of sub arrays and check if it is lessthan k
			sum =0;									//O(n^3)
			for(int l=i;l<=j;l++) {
				sum +=arr[l];
			}
			if(sum<k ) {
			max = Math.max(max,j-i+1);
			}
		}
	}
	System.out.println("max length of longest sub lessthan k:"+max);
}

private static void bruteForce(int arr[],int k) {
	int sum =0; int maxLen = Integer.MIN_VALUE;
	int n = arr.length;
	for(int i=0;i<n;i++) {
		sum = 0;
		for(int j=i;j<n;j++) {
			sum +=arr[j];
			if(sum<k) {
				maxLen = Math.max(maxLen, j-i+1);
			}
		}
	}
	System.out.println(maxLen);
}

private static void better(int arr[],int k) {
	int n = arr.length;
	int l=0,r=0,sum =0;
	int maxLen =Integer.MIN_VALUE;
	
	while(r<n) {
		sum +=arr[r];
		
		while(sum>k) {
			sum= sum-arr[l];
			l=l+1;
		}
		if(sum<=k) {
			maxLen = Math.max(maxLen, r-l+1);
			r=r+1;
		}
	}
	System.out.println(maxLen);
	
}
}
