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
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int a[], int n) {
        // code here
        // Sum of first n natural numbers
        long SN = (long)n * (n + 1) / 2;
        // Sum of squares of first n natural numbers
        long S2N = (long)n * (n + 1) * (2 * n + 1) / 6;

        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += a[i];
            S2 += (long)a[i] * a[i];
        }

        // val1 = x - y
        long val1 = S - SN;

        // val2 = x^2 - y^2
        long val2 = S2 - S2N;

        // val2 = (x + y)(x - y)
        val2 = val2 / val1;

        // x = (val1 + val2) / 2
        long x = (val1 + val2) / 2;

        // y = x - val1
        long y = x - val1;

        int[] ans = {(int)x, (int)y};
        return ans;
    }
}