//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			long a = sc.nextInt();
			Solution obj = new Solution();
			System.out.println(obj.floorSqrt(a));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution
{
     long floorSqrt(long x)
	 {
		// Your code here
		
		int start = 1;
        int end = (int)x;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(Math.pow(mid,2) == (int)x) return mid;
            else if(Math.pow(mid,2) > (int)x ) end = mid-1;
            else start = mid+1;
         }
         return (long)start-1;
		
		
	 }
}
