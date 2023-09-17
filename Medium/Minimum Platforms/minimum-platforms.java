//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Pair[] pp = new Pair[n];
        int res=1;
        
        for(int i=0;i<n;i++)
            pp[i] = new Pair(arr[i],dep[i]);
        
        Arrays.sort(pp,(a,b)->a.a-b.a);
        ArrayList<Pair> list = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            helper(list,pp[i]);
            res = list.size();
        }
        
        return res;
    }
    
    static void helper(ArrayList<Pair> list,Pair p){
        for(int i=0;i<list.size();i++){
            if(list.get(i).d < p.a){
                list.set(i,p);
                return;
            }
        }
        list.add(p);
    }
    
}

class Pair{
    int a;
    int d;
    Pair(int x,int y){
        a = x;
        d = y;
    }
    
}

