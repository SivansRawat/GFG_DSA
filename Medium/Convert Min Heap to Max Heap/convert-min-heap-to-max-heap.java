//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      obj.convertMinToMaxHeap(n,a);
      for(int e : a)
      {
          System.out.print(e+" ");
      }
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static void MaxHeapify(int[] arr , int i,int n ){
        
        int l = 2*i+1;
        int r = 2*i+2;
    
        int largest = i;
    
        if(l<n && arr[l]>arr[i]){
            largest = l;
        }
        
        if(r<n && arr[r] > arr[largest]){
            largest = r;
        }
        
        
        if(largest != i){
            
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
            MaxHeapify(arr,largest,n);
        }
    }
    
    
    static void convertMinToMaxHeap(int n, int arr[]) {
    // code here
    
    for(int i=(n-2)/2  ; i>=0 ; --i){
        MaxHeapify(arr,i,n);
    }
 
  }
}

     