//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        
        
        
        // To count occurrences of Every character in the String 
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        // char[] chr_array = pat.toCharArray();
        
        // for(char c : chr_array){
        //     if(map.containskey(c)){
        //         map.put(c,map.get(c)+1);
                
        //     }
            
        //     else{
        //         map.put(c,1);
        //     }
        // }
        
        
        
        for(int i=0;i<pat.length();i++){
            if(map.containsKey(pat.charAt(i))){
                map.put(pat.charAt(i) , map.get(pat.charAt(i))+1);
            }
            
            else{
                map.put(pat.charAt(i) ,1);
            }
        }
        
        
        int i=0;
        int j=0;
        int ans = 0;
        int count = map.size();
        
        
        while(j<txt.length()){
            
            
            if(map.containsKey(txt.charAt(j))){
                
                map.put(txt.charAt(j) , map.get(txt.charAt(j)) -1);
                
                
                
                if(map.get(txt.charAt(j)) == 0){
                
                count--;
                }
            }
            
            
            
            
            
            
            if(j-i+1 < pat.length()){
                j++;
            }
            
            
            else if(j-i+1 == pat.length()){
                
                if(count==0){
                    ans++;
                }
                
                
                
                if (map.containsKey(txt.charAt(i))) {
                    map.put(txt.charAt(i), map.get(txt.charAt(i)) + 1);
                    if (map.get(txt.charAt(i)) == 1) {
                        count++;
                    }
                }
                
                
                
                i++;
                j++;
                
                // if(map.containskey(txt.charAt(j))){
                // map.put(txt.charAt(j),map.get(txt.charAt(j))+1);
                
                // }
            
                // else{
                //     map.put(txt.charAt(j),1);
                // }
            }
            
            
            
            
           
            
            

            
            
        }
        
        return ans;
        
        
        
        
        
        
        
    }
}