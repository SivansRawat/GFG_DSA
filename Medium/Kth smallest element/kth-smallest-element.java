//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


// //User function Template for Java

// class Solution{
    
    
//     static void MinHeapify(int[] arr , int i,int n ){
        
//         int l = 2*i+1;
//         int r = 2*i+2;
    
//         int smallest = i;
    
//         if(l<n && arr[l] < arr[i]){
//             smallest = l;
//         }
        
//         if(r<n && arr[r] < arr[smallest]){
//             smallest = r;
//         }
        
        
//         if(smallest != i){
            
//             int temp = arr[i];
//             arr[i] = arr[smallest];
//             arr[smallest] = temp;
            
//             MinHeapify(arr, smallest, n);
//         }
//     }
    
    
    
    
//     public static int kthSmallest(int[] arr, int l, int r, int k) 
//     { 
//         //Your code here
        
//         int n = arr.length;
//         for(int i=(n-2)/2 ; i>=0 ; --i){
//             MinHeapify(arr, i, n);
//         }
        
        
//         PriorityQueue<Integer>pq= new PriorityQueue<>();
        

//         for (int i = 0; i < n; i++) {
//             pq.add(arr[i])  ;
//         }

//         int f = k - 1 ;

//         while (f > 0) {
//             pq.remove()  ;
//             f-- ;
//         }
        
        
//         return pq.peek();
        
        
//     } 
// }



class Solution{
public static int kthSmallest(int[] arr, int l, int r, int k) {
    
    
     PriorityQueue<Integer>pq= new PriorityQueue<>();
        int n = arr.length  ;

        for (int i = 0; i < n; i++) {
            pq.add(arr[i])  ;
        }

        int f = k - 1 ;

        while (f > 0) {
            pq.remove()  ;
            f-- ;
        }
         
         
         return pq.peek();
        
    
}
}