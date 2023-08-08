//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countFractions(int n, int[] numerator, int[] denominator) {
        // code here
        
        
        
        int ans = 0;
        List<Double> v = new ArrayList<>();
        Map<Double, Integer> m = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            double num = (double) numerator[i] / (double) denominator[i];
            v.add(num);
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        
        for (int i = 0; i < n; i++) {
            double num = (double) numerator[i] / (double) denominator[i];
            double a = (double) (denominator[i] - numerator[i]) / (double) denominator[i];
            m.put(num, m.get(num) - 1);
            ans += m.getOrDefault(a, 0);
        }
        
        
        
        return ans;
    }
}
        
