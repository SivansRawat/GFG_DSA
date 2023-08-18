//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends



class Solution{
    
    
    int fun(int pos, int[] price, int[] vis){
        if(vis[pos]!=-1)return vis[pos];
        int max=price[pos-1];
        int i=1;
        while(i<=pos/2){
            vis[i]=fun(i, price, vis);
            vis[pos-i]=fun(pos-i, price, vis);
            max=Math.max(max, vis[i]+vis[pos-i]);
            i++;
        }
        return max;
    }
    
    
    public int cutRod(int price[], int n) {
        //code here
        int max=0;
        int vis[]=new int[n+1];
        for(int i=2; i<n; i++){
            vis[i]=-1;
        }
        vis[0]=0;
        vis[1]=price[0];
        vis[n]=price[n-1];
        for(int i=0; i<n; i++){
            vis[i]=fun(i, price, vis);
            vis[n-i]=fun(n-i, price, vis);
            max=Math.max(max, vis[i]+vis[n-i]);
        }
        return max;
    }
}