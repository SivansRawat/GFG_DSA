//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int arr[])
    {
        // Code here
        
        
          int ans = 0;
        int n = arr.length;
        int[] temp = Arrays.copyOf(arr, n);
        Arrays.sort(temp);
        Map<Integer, Integer> h = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            h.put(arr[i], i);
        }
        
        int init = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] != temp[i]) {
                ans++;
                init = arr[i];

                // Swap elements
                int tempIndex = h.get(temp[i]);
                arr[i] = arr[tempIndex];
                arr[tempIndex] = init;

                // Update the positions in the map
                h.put(init, tempIndex);
                h.put(temp[i], i);
            }
        }
        
        return ans;
    }
}