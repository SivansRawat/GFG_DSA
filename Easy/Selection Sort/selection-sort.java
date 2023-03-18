//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n]; 
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
		
			Solution obj = new Solution();
			obj.selectionSort(arr, n);
			
			for(int i=0;i<n;i++)
		    	System.out.print(arr[i]+" ");
		    System.out.println();
			t--;
		}
		
	}
}

// } Driver Code Ends


class Solution
{
	int  select(int arr[], int i)
	{
        // code here such that selectionSort() sorts arr[]
        // System.out.println(arr[i]);
        return(arr[i]);
            
    }
	
	void selectionSort(int arr[], int n)
	{
	    //code here
	    
	    for(int i =0 ; i<n;i++)
	    {
	        for(int j = i+1;j<n;j++){
	            int x = select(arr,i);
	            int y = select(arr,j);
	            if(x>y){
	               // System.out.println("hello");
	                int m =x;
	                arr[i]= y;
	                arr[j] = m ;
	                
	               // System.out.println(x);
	               // System.out.println(y);
	                
	            }
	            
	            
	            
	        }
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}
}