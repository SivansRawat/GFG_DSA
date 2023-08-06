//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String s){
       ArrayList<String> arr=new ArrayList<>();
       func(s,0,arr);
       Collections.sort(arr);
       return arr;
    }
	
	private void func(String s,int index,ArrayList<String> arr){
	    if(index==s.length()){
	        arr.add(s);
	        return ;
	    }
	    
	    for(int i=index;i<s.length();i++){
	        s=swap(s,index,i);
	        func(s,index+1,arr);
	        s=swap(s,index,i);
	    }
	}
    public String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
}
