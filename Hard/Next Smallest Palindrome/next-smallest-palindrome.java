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
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    
    
    public Vector<Integer> generateNextPalindrome(int num[], int n) {
        int i = n / 2, j = n / 2;
        int[] v = Arrays.copyOf(num, n);
        if ((n & 1) == 0) i--;

        while (i >= 0) {
            if (v[j] > v[i]) break;
            if (v[i] > v[j]) {
                while (i >= 0) {
                    v[j] = v[i];
                    i--;
                    j++;
                }
                return convertArrayToVector(v);
            }
            i--;
            j++;
        }

        i = n / 2;
        j = n / 2;
        if ((n & 1) == 0) i--;

        while (i >= 0) {
            if (num[i] != 9) {
                if (num[j] >= num[i]) num[i]++;
                while (i >= 0) {
                    num[j] = num[i];
                    j++;
                    i--;
                }
                return convertArrayToVector(num);
            } else {
                num[i] = 0;
                num[j] = 0;
                i--;
                j++;
            }
        }

        Vector<Integer> ans = new Vector<>();
        ans.add(1);
        for (int x = 0; x < n - 1; x++) { // Change is here
            ans.add(0);
        }
        ans.add(1);
        return ans;
    }

    private Vector<Integer> convertArrayToVector(int[] array) {
        Vector<Integer> vector = new Vector<>();
        for (int num : array) {
            vector.add(num);
        }
        return vector;
    }
}