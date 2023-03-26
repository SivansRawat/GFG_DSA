//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution{
    static String isStringExist(String arr[],int N,String S){
        // code here
        for(int i=0;i<N;i++)
        {
            int count = 0;
            if(arr[i].length() == S.length())
            {
                String temp = arr[i];
                for(int j=0;j<temp.length();j++)
                {
                    if(temp.charAt(j) != S.charAt(j))
                        count++;
                }
                if(count==1)
                    return "True";
            }
        }
        return "False";
        
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split(" ");
            String X =read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.isStringExist(input_line, N, X));
        }
    }
}
// } Driver Code Ends