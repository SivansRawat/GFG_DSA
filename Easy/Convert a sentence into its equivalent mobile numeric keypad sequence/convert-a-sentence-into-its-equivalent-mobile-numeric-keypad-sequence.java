//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String S = read.readLine();
            Solution obj = new Solution();
            System.out.println(obj.printSequence(S));
            
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String printSequence(String S) 
    { 
        // code here
        
        Map<Character, String> keypad = new HashMap<>();
        keypad.put('A', "2");
        keypad.put('B', "22");
        keypad.put('C', "222");
        keypad.put('D', "3");
        keypad.put('E', "33");
        keypad.put('F', "333");
        keypad.put('G', "4");
        keypad.put('H', "44");
        keypad.put('I', "444");
        keypad.put('J', "5");
        keypad.put('K', "55");
        keypad.put('L', "555");
        keypad.put('M', "6");
        keypad.put('N', "66");
        keypad.put('O', "666");
        keypad.put('P', "7");
        keypad.put('Q', "77");
        keypad.put('R', "777");
        keypad.put('S', "7777");
        keypad.put('T', "8");
        keypad.put('U', "88");
        keypad.put('V', "888");
        keypad.put('W', "9");
        keypad.put('X', "99");
        keypad.put('Y', "999");
        keypad.put('Z', "9999");
        keypad.put(' ', "0");

        String result = "";
        for (char c : S.toCharArray()) {
            result += keypad.get(Character.toUpperCase(c));
        }

        return result;
        
        
    }
}