//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class GfG { 
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    int[] arr = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++)arr[i] = Integer.parseInt(inputLine[i]);
		    
		    Solution obj = new Solution();
		    System.out.println(obj.firstElementKTime(arr, n, m));
		}
	}
}

// } Driver Code Ends


class Solution
{
    public int firstElementKTime(int[] a, int n, int k) { 
        if(k == 1){
            return a[0];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int number = -1;
        int freq = -1;
        for(int i=0;i<n;i++){
            number = a[i];
            if(!map.containsKey(number)){
                map.put(number,1);
            }
            else{
                freq = map.get(number);
                freq++;
                map.put(number,freq);
                
                if(map.get(number) == k){
                    return number;
                }
            }
        }
        return -1;
        
        
    } 
}