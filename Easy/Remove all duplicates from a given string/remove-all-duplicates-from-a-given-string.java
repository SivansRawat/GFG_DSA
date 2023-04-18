//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str = br.readLine().trim();

            String ans = new Solution().removeDuplicates(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    String removeDuplicates(String str) {
        // code here
        LinkedHashSet<Character> set=new LinkedHashSet<>();
        for(int i=0;i<str.length();i++)
        {
            set.add(str.charAt(i));
        }
        str="";
        for(char ch: set) str=str+ch;
        return str;
        
        
        // set.add(str);
        
        // for
        // String s = "";
        // HashMap<Character,Integer> map = new HashMap<>();
        
        // for(int i =0 ;i<str.length() ;i++){
        //     // char a = str.charAt(i);
        //     map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
            
        //     if(map.get(str.charAt(i)) == 2){
                
        //         s += str.charAt(i);
        //     }
        // }
        
        
    }
}

