//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Searching
{
    public static void main (String[] args)throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
           String a[] = read.readLine().trim().split("\\s+");
           int n = Integer.parseInt(a[0]);
           long x = Long.parseLong(a[(int)1]);
           String st[] = read.readLine().trim().split("\\s+");
        
           long arr[] = new long[n];
           for(int i = 0; i < n; i++)
           {
               arr[i] = Long.parseLong(st[i]);
           }
           
           out.println(new Solution().findFloor(arr, n, x));
          
        }
        out.close();
    }
    
}
// } Driver Code Ends


class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    
    static int findFloor(long arr[], int n, long x)
    {
        int start = 0;
        int end = n-1;
        
        int floor = -1;

        while(start <= end) {
            int mid = (start+end)/2;

            if(x == arr[mid]) {
                // a[mid] is the floor               
                return (int)mid;
            } 
            else if (x < arr[mid]) {
                end = mid-1;
            } 
            
            else {
                // a[mid] is the largest element found so far that is smaller than x. So it is a candidate for the floor of x
                floor = (int)mid; 
                start = mid+1;
            }
        }

        return floor;
        
        
        
    }

        
        
        
        
     
  
    
}


