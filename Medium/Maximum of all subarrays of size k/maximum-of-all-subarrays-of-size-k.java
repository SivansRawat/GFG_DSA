//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        
        ArrayList<Integer> arr_f = new ArrayList<Integer>(); // final arraylist to be returned 
        // ArrayDeque<Integer> deq = new ArrayDeque<Integer> ();  // deque to store maximum values 
        
        int i=0,j=0;
        // int n = nums.length;
        // int[] arr  = new int[n-k+1];

        ArrayDeque<Integer> deq = new ArrayDeque<>();

        while(j<n){
            while(!deq.isEmpty() && arr[j] > deq.peekLast()){
                deq.removeLast();
            }

            deq.addLast(arr[j]);
            // System.out.println(deq);


            if(j-i+1<k){
                j++;

            }


            else if(j-i+1 == k){
                arr_f.add(deq.peekFirst());

                if(deq.peek()==arr[i]){
                    deq.removeFirst();
                }

                i++;
                j++;
            }

        }


        return arr_f;
        
    }
}