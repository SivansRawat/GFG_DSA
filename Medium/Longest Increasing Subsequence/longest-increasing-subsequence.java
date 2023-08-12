//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(a[0]);
        int length = 1;

        for (int i = 1; i < a.length; i++) {
            if (a[i] > ans.get(ans.size() - 1)) {
                ans.add(a[i]);
                length++;
            } else {
                int index = lowerBound(ans, a[i]);
                ans.set(index, a[i]);
            }
        }
        return length;
        
    }
    
    
    
     private static int lowerBound(ArrayList<Integer> list, int target) {
        int low = 0;
        int high = list.size();

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
} 