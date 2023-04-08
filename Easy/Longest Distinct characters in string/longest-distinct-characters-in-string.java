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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        
        int i  =0 , j=0;
        int max = Integer.MIN_VALUE;
        
        int size = S.length();
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        while(j<size){ 
            
            map.put(S.charAt(j) , map.getOrDefault(S.charAt(j) , 0 ) +1);
            
            
            // if(map.size() < k){
            //     j++;
            // }
            
            if (map.size() == j-i+1){
                
                max = Math.max(max,j-i+1);
                
                j++;
            }
            
            else if(map.size() < j-i+1){
                
                while(map.size() < j-i+1){
                    
                    if(map.containsKey(S.charAt(i))){
                        
                        map.put(S.charAt(i) , map.get(S.charAt(i)) -1 );
                    }
                    
                    if(map.get(S.charAt(i)) == 0){
                        
                        map.remove(S.charAt(i));
                        
                    }
                    
                    i++;
                    
                   
                }
                
                j++;
            }
            
            
            
        }
        
       
        return max;
        
    }
}