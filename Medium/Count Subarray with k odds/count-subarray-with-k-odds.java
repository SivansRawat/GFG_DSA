//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] nums = IntArray.input(br, n);
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.countSubarray(n, nums, k);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int countSubarray(int n, int[] nums, int k) {
        // code here
        
        
        for(int i =0 ; i< n;i++){
            
            if(nums[i] % 2 == 0){
                
                nums[i] = 0 ;
            }
            
            else{
                nums[i] = 1;
            }
        }
        
        if (nums == null || nums.length == 0) return 0;
        // key: prefix sum value, value: count of key that have been seen so far
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(0, 1);  // don't forget this trivial case
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int target = sum - k;
            ans += map.getOrDefault(target, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
        
    }
}
        
