//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.countSubstring(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int countSubstring(String s) {
        // code here
        
        int N = s.length();
        int k = 3;
        // subarray with atmost k distinct integer - subarray with atmost (k-1)distinct integer
		//  will give subrray with exact k distinct integer
		return atMost(s, N, k)-atMost(s, N, k-1) ;

	}

	private static int atMost(String s , int n, int k) {
		int i = 0;
		int j = 0;
		int count = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (j < n) {
			map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
			
			while (map.size() > k) {
				map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
				if (map.get(s.charAt(i)) == 0) {
					map.remove(s.charAt(i));
				}
				i++;
			}
			
			if (map.size() <= k) {
			    
			    // count addition ... 
				count = count + (j - i) + 1;
			}
			j++;
		}
		return count;
    }
}
        
