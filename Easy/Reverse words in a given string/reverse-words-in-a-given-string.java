//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        int i =S.length()-1;

        String ans = "";

        while(i >=0) {
            
            while(i >=0 && S.charAt(i)== '.') {
                i--;
            }

            int j=i;

            if(i < 0) {
                break;
            }

            while(i >=0 && S.charAt(i) != '.'){
                i--;
            }

            if(ans.isEmpty()) {

                ans = ans.concat(S.substring(i+1,j+1));

            }
            else {

                ans = ans.concat("." +S.substring(i+1,j+1));

            }

        }

        return ans;
        
        
        
    
    
    
    }
}