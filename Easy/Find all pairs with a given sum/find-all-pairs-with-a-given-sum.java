//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long N = Long.parseLong(stt.nextToken());
            long M = Long.parseLong(stt.nextToken());
            long X = Long.parseLong(stt.nextToken());
            long A[] = new long[(int)(N)];
            long B[] = new long[(int)(M)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < N; i++) {
                A[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < M; i++) {
                B[i] = Long.parseLong(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            pair [] answer = obj.allPairs(A, B, N, M, X);
            int sz = answer.length;
            
            if(sz==0)
            System.out.println(-1);
            else{
                StringBuilder output = new StringBuilder();
                for(int i=0;i<sz;i++){
                    if(i<sz-1)
                    output.append(answer[i].first +" "+ answer[i].second + ", ");
                    else
                    output.append(answer[i].first +" "+ answer[i].second);
                    
                }
                System.out.println(output);
            }
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/
    
    
    
    
class Solution {
    
    // Main function 
    public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        // Your code goes here
        // pair<Long,Long> pr = new pair<Long,Long>();
        
        ArrayList<pair> al=new ArrayList<>();
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0;i<A.length;i++){
            long val=A[i];
            if(binarySearch(B,X-val)!=-1){
                al.add(new pair(val,X-val));
            }
        }
        pair [] arr=new pair[al.size()];
        al.toArray(arr);
        return arr;
    }
        
    
    
    // Binary search function  (OG Level)
    public static int binarySearch(long [] array,long target){
        int low=0;
        int high=array.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(array[mid]==target){
                return mid;
            }
            else if(array[mid]<target){
                low++;
            }
            else{
                high--;
            }
        }
        return -1;
    }
        
        
        
    
}