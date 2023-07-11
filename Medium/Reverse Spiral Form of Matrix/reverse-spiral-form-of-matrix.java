//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] reverseSpiral(int R, int C, int[][] a)
    {
        // code here
        
        // int n = a.length;
        // int m = a[0].length;
        // ArrayList<Integer> arr = new ArrayList<>()\
        
        int n = R*C;
        int[] arr = new int[n];

        int top = 0 ;
	    int bottom = R-1;
	    int right = C-1;
	    int left = 0;
	    
	    
	    int j = n-1;
	    
	    
        while(top<=bottom && left<=right){


            for(int i = left ; i<=right ;i++){
                arr[j] = (a[top][i]);
                j--;
                
            }

            top++;



            for(int i  = top ;i<=bottom;i++ ){
                arr[j] = a[i][right];
                j--;
            }

            right--;


            if(top<=bottom){

                for(int i = right;i>=left;i--){
                    arr[j] = a[bottom][i];
                    j--;
                }
                bottom--;
            }


            if(left<=right){

                for(int i = bottom;i>=top;i--){
                    arr[j] = a[i][left];
                    j--;
                }

                left++;


            }
        }


        return arr;
    }
}