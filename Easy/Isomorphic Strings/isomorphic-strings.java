//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        // Your code here
        
        int n = str1.length();
        int m  = str2.length();
        
        
        HashMap<Character,Character> map = new HashMap<>();
        
        
        if((str1.length()) != str2.length()){
            return false;
        }
        
        for(int i =0 ;i<n;i++){
            
            
            char p1 = str1.charAt(i);
            char p2 = str2.charAt(i);
            
            if(map.containsKey(p1)){
                
                if(map.get(p1) != p2){
                    return false;
                }
                
            }
            
            
            else if(map.containsValue(p2)){
                return false;
            }
            
            else{
                map.put(p1,p2);
            }
        }
        
        
        
        
        
        return true;
        
    }
}