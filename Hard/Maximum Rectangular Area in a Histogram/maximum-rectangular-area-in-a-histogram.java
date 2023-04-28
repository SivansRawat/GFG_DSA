//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends



class Pair{
    int first;
    int second;
    Pair(int _first,int _second){
        this.first=_first;
        this.second=_second;
    }
}



class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        
        int[] left = new int[(int) n];
        int[] right = new int[(int) n];
        
        int pseudoindex = -1;
        
        // int count = n-1;
        Stack<Pair> stk = new Stack<>();
        
        // for(int i=0;i<n;i++){
            
            
        //     if(stk.size() == 0){
                
        //         // nums[count] = -1;
        //         left.add(pseudoindex);
        //         // count--;
        //     }
            
        //     else if((stk.size() > 0) && (stk.peek().first < hist[i])){
                
        //         // nums[count] = stk.peek() ;
                
        //         left.add(stk.peek().second);
        //         // count--;
        //     }
            
            
        //     else if(((long)stk.size() > 0) && (stk.peek().first >= hist[i] )){
                
        //         while(((long)stk.size() > (long)0) && (stk.peek().first >= hist[i])){
                    
        //             stk.pop();
        //         }
                
                
        //         if(stk.size() == 0){
                    
        //             // nums[count] = -1;
        //             left.add(pseudoindex);
        //             // count--;
        //         }
                
        //         else{
        //             // nums[count] = stk.peek();
        //             left.add(stk.peek().second);
        //             // count--;
        //         }
        //     }
            
            
        //     stk.push(new Pair((int)hist[i],i));
        //     // count--;
            
            
        // }
        
        
        
         for (int i = 0; i < n; i++) {
            while (!stk.empty() && stk.peek().first >= hist[i]) {
                stk.pop();
            }

            left[i] = stk.empty() ? -1 : stk.peek().second;
            stk.push(new Pair((int)hist[i], i));
        }
        
        
        // for(int i  =0;i<n;i++){
        //     System.out.print(left[i]);
        //     System.out.print(" ");
        // }
        // System.out.println();
            
        
        
        
        // ArrayList<Integer> right = new ArrayList<>();
        
        // int pseudoindex1 = (int)n;
        
        // int count = n-1;
        Stack<Pair> stk1 = new Stack<>();
        
        // for(int i = (int)n-1;i>=0;i--){
            
            
        //     if(stk1.size() == 0){
                
        //         // nums[count] = -1;
        //         right[i] = pseudoindex1;
        //         // count--;
        //     }
            
        //     else if((stk1.size() > 0) && (stk1.peek().first < hist[i])){
                
        //         // nums[count] = stk.peek() ;
                
        //         right[i] = stk1.peek().second;
        //         // count--;
        //     }
            
            
        //     else if((stk1.size() > 0) && (stk1.peek().first >= hist[i] )){
                
        //         while((stk1.size() > 0) && (stk1.peek().first >= hist[i])){
                    
        //             stk1.pop();
        //         }
                
                
        //         if(stk1.size() == 0){
                    
        //             // nums[count] = -1;
        //             right[i] = pseudoindex1;
        //             // count--;
        //         }
                
        //         else{
        //             // nums[count] = stk.peek();
        //             right[i] = stk1.peek().second;
        //             // count--;
        //         }
        //     }
            
            
        //   stk1.push(new Pair((int)hist[i],i));
        //     // count--;
            
            
        // }
        
        
        for (int i = (int) n - 1; i >= 0; i--) {
            while (!stk1.empty() && stk1.peek().first >= hist[i]) {
                stk1.pop();
            }

            right[i] = stk1.empty() ? (int) n : stk1.peek().second;
            stk1.push(new Pair((int)hist[i], i));
        }
        
        
        
        // Collections.reverse(right);
        
        
        // for(int i  =0;i<n;i++){
        //     System.out.print(right.get(i));
        //     System.out.print(" ");
        // }
        // System.out.println();
        
        
        // ArrayList<Integer> width = new ArrayList<>();
        
        
        // for(int i=0;i<n;i++){
            
            
        //     width.add(right[i] - left[i] -1);
        // }
        
        
        // ArrayList<Long> area = new ArrayList<>();
        
        // for(int i=0;i<n;i++){
            
        //     area.add(hist[i]*width.get(i));
            
            
        // }
        
        // long max = Integer.MIN_VALUE;
        
        // for(int i =0 ;i<n;i++){
            
        //     if(area.get(i) > max){
                
        //         max = area.get(i);
        //     }
        // }
        
        
        // return max;
        
        
        
        long maxArea = 0;
        for (int i = 0; i < n; i++) {
            long width = right[i] - left[i] - 1;
            long area = hist[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
        
        
        
        
        
    }
        
}



