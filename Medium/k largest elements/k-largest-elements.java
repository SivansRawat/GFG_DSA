//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().kLargest(arr, n, k);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    int[] kLargest(int[] arr, int n, int k) {
    
    
    PriorityQueue<Integer> mini = new PriorityQueue<>(k);
        
        for (int i = 0; i < n; i++) {
            if (mini.size() < k)
                mini.offer(arr[i]);
            else {
                if (arr[i] > mini.peek()) {
                    mini.poll();
                    mini.offer(arr[i]);
                }
            }
        }
        
        
        
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            
            
            ans[i] = mini.poll();        }
        
        return ans;
    
    }
}