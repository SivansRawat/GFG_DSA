//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/

class Pair{
    int first;
    int second;
    Pair(int _first,int _second){
        this.first=_first;
        this.second=_second;
    }
}



class Solution {
    public int maxArea(int M[][], int n, int m) {
        // add code here.
        
        int[] arr = new int[m];
        for(int j=0;j<m;j++){
            
            arr[j] = M[0][j];
        }
        
        
        int max = MAH(arr,m);
        
        
        for(int i =1 ; i<n;i++){
            
            // int[] arr1 = new int[m];
            for(int j =0;j<m;j++){
                
                if(M[i][j] == 0){
                    
                    arr[j] = 0;
                }
                
                else{
                    
                    arr[j] = arr[j] + M[i][j];
                }
            }
            
            max = Math.max(max,MAH(arr,m));
            
            
        }
        
        return max;
        
    }
    
    
    public int MAH(int[] heights , int n){
        
        
        int[] left = new int[n];
        
        int[] right = new int[n];
        
        
        
        Stack<Pair> stk = new Stack<>();
        
        Stack<Pair> stk1 = new Stack<>();
        
         for (int i = 0; i < n; i++) {
            while (!stk.empty() && stk.peek().first >= heights[i]) {
                stk.pop();
            }

            left[i] = stk.empty() ? -1 : stk.peek().second;
            stk.push(new Pair(heights[i], i));
        }
        
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stk1.empty() && stk1.peek().first >= heights[i]) {
                stk1.pop();
            }

            right[i] = stk1.empty() ?  n : stk1.peek().second;
            stk1.push(new Pair(heights[i], i));
        }
        
        
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
        
    }
    
}