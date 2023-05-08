//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

  public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Pair{

    int x;

    int d;

    Pair(int x,int d){

        this.x=x;

        this.d=d;

    }

   

    

}

class Solution {

    int[] printKClosest(int[] arr, int n, int k, int x) {

       PriorityQueue<Pair>pq = new PriorityQueue<Pair>((a,b)->{

           if(a.d==b.d)return a.x-b.x;

           else return b.d-a.d;

       });

       for(int i =0;i<n;i++)

       {

           int d =Math.abs(x-arr[i]);

           if(d!=0){

               pq.add(new Pair(arr[i],d));

           }

       }

     

       while(pq.size()>k)

       pq.poll();

       

       int size = pq.size();

       int[]ans = new int[size];

       for(int i =size-1;i>=0;i--)

        {

         

            Pair p = pq.poll();

              

            ans[i] = p.x;

        }

        return ans;

    }

}