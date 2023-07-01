//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();

            Solution ob = new Solution();
            int cnt = ob.setBits(N);
            System.out.println(cnt);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static int setBits(int N) {
        // code here
        
        
        int count = 0, mask = 1;
        for(int i = 0; i < 32; i++){
            if((N & mask) != 0) count++;
            
            // left shift 1 every time while running for loop if at that index 1 comes so we add count++
            mask = mask << 1;
        }
        return count;
    }
}