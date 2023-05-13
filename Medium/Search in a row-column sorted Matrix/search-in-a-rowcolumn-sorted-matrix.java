//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG{
	public static void main(String args[]) throws IOException { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
       		int rows=sc.nextInt();
       		int columns=sc.nextInt();
			
			int matrix[][]=new int[rows][columns];
          
        	for(int i=0; i<rows;i++){            
            	for(int j=0; j<columns;j++){
                	matrix[i][j]=sc.nextInt();
            	}
         	}
         	int target = sc.nextInt();
         	
			Solution x = new Solution();
			
			if (x.search(matrix, rows, columns, target)) 
				System.out.println(1); 
			else
				System.out.println(0); 
			t--;
		}
	} 
}
// } Driver Code Ends




class Solution 
{ 
    //Function to search a given number in row-column sorted matrix.
	static boolean search(int matrix[][], int n, int m, int x) 
	{  
	    // code here 
	    
	    boolean result = false;
	    
	    int column = m-1 , row = 0;
	    
	    while(column >= 0 && row<=n-1){
	        
	        if (matrix[row][column] == x){
	            
	            result = true;
	            break;
	        }
	        
	        else if(matrix[row][column] < x){
	            row++;
	        }
	        
	        else{
	            column--;
	        }
	            
	            
	     }
	    
	    
	    return result;
	    
	} 
} 
