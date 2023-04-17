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
      int k = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.subarrayCount(a,n,k);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    
    
    static int subarrayCount(int arr[], int N, int k) {
    // code here
    
    
    
    // subarray with atmost k distinct integer - subarray with atmost (k-1)distinct integer
		//  will give subrray with exact k distinct integer
		return atMost(arr, N, k)-atMost(arr, N, k-1) ;

	}

	private static int atMost(int[] arr, int n, int k) {
		int i = 0;
		int j = 0;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		while (j < n) {
			map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
			
			while (map.size() > k) {
				map.put(arr[i], map.get(arr[i]) - 1);
				if (map.get(arr[i]) == 0) {
					map.remove(arr[i]);
				}
				i++;
			}
			
			if (map.size() <= k) {
				count = count + (j - i) + 1;
			}
			j++;
		}
		return count;
      
  }
  
  
}