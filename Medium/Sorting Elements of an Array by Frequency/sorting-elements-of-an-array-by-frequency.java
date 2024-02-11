//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Map.Entry;


class Driverclass 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(sc.readLine());
	    while(n != 0)
		{
			int size = Integer.parseInt(sc.readLine());
			int arr[] = new int[size];
			String[] temp = sc.readLine().trim().split("\\s+");
			
			for(int i = 0; i < size; i++)
			    arr[i] = Integer.parseInt(temp[i]);
			    
			 ArrayList<Integer> ans = new ArrayList<Integer>();
			 ans = new Solution().sortByFreq(arr, size);
			 for(int i=0;i<ans.size();i++)
			    System.out.print(ans.get(i)+" ");
		    System.out.println();
			n--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java

    class Pair{
        int num;
        int freq;
        Pair(int num, int freq){
            this.num=num;
            this.freq=freq;
        }
    }
    
    

class Solution
{
    //Function to sort the array according to frequency of elements.
    static ArrayList<Integer> sortByFreq(int nums[], int n)
    {
        // add your code here
        HashMap<Integer, Integer>h=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            h.put(nums[i], h.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.freq==b.freq?b.num-a.num: a.freq-b.freq);
        for(int i: h.keySet()){
            pq.add(new Pair(i, h.get(i)));
        }
        // int arr[]=new int[nums.length];
        ArrayList<Integer> arr = new ArrayList<>();
        // int j=0;
        while(!pq.isEmpty()){
            int m=pq.peek().num;
            int f=pq.peek().freq;
            pq.poll();
            for(int i=0; i<f; i++){
                // arr[j]=n;
                // j++;
                arr.add(m);
            }
        }
        
        
        Collections.reverse(arr);
        return arr;
        
        
    }
}