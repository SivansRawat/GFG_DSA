//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int x = Integer.parseInt(inputLine[1]);
		    
		    int arr[] =  new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    new Solution().sortABS(arr,n, x);
		    StringBuilder sb = new StringBuilder();
		    for(int y : arr)
		        sb.append(y+ " ");
		    System.out.println(sb.toString());
		    
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to sort the array according to difference with given number.
    static void sortABS(int arr[], int n,int k)
    {
        
        
        TreeMap<Integer,ArrayList<Integer>> m = new TreeMap<>();
        
        for(int i = 0 ; i<n;i++){
            int diff = Math.abs(arr[i]-k);
            if(m.containsKey(diff)){
                ArrayList<Integer> al = m.get(diff);
                al.add(arr[i]);
                m.put(diff,al);
            }
             else{
                 
                ArrayList<Integer> al = new ArrayList<Integer>();
                al.add(arr[i]);
                m.put(diff,al);
                 
             }
            
        }
        
        int indx = 0 ;
        for(Map.Entry entry : m.entrySet()){
            ArrayList<Integer> al = m.get(entry.getKey());
            for(int i  =0 ; i<al.size() ; i++){
                arr[indx++]  =al.get(i);            
                
            }
        }
        
        
        
            
        }

}
