//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String s) {
	
        s = s.trim();
        
        if (s.isEmpty()) {
            return 0;
        }

       
        int ans = 0, i = 0;
        boolean neg = s.charAt(0) == '-';
        boolean pos = s.charAt(0) == '+';

        
        
        if (neg || pos) {
            i++;
        }

        
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            
            int digit = s.charAt(i) - '0';

           

            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            
            ans = ans * 10 + digit;
            i++;
        }

       
       if (i < s.length() && !Character.isDigit(s.charAt(i))) {
                return -1; 
            }
            
        return neg ? -ans : ans;
	
	
    }
}
