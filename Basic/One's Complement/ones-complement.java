//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.onesComplement(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int onesComplement(int N){
        //code here
        
        int n = (int)(Math.log(N) /Math.log(2)) + 1;  // n represents the number of bits of a number 
        
        return ((1<<n) -1) ^ N;
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}