//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    public static int allocatedStudents(int A[],int pages){
        int students=1,studentPages=0;
        for(int i=0;i<A.length;i++){
            if(studentPages+A[i]<=pages) studentPages+=A[i];
            else{
                students++;
                studentPages=A[i];
            }
        }
        return students;
    }
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        if(M>N) return -1;
        int minPages=Integer.MIN_VALUE,maxPages=0;
        for(int i:A){
            minPages=Math.max(minPages,i);
            maxPages+=i;
        }
        int l=minPages,r=maxPages;
        while(l<=r){
            int mid=(l+r)/2;
            int currStudents=allocatedStudents(A,mid);
            if(currStudents<=M) r=mid-1;
            else l=mid+1;
        }
        return l;
    }
};