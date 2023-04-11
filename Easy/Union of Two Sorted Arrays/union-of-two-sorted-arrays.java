//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String st[] = read.readLine().trim().split(" ");
            int N = Integer.parseInt(st[0]);
            int M = Integer.parseInt(st[1]);
            
            int arr1[] = new int[N];
            int arr2[] = new int[M];
            
            st = read.readLine().trim().split(" ");
            for(int i = 0; i < N; i++)
              arr1[i] = Integer.parseInt(st[i]);
            
            st = read.readLine().trim().split(" ");  
            for(int i = 0; i< M; i++)
              arr2[i] = Integer.parseInt(st[i]);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(arr1, arr2, N, M);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println(); 
        }
    }
}



// } Driver Code Ends


//User function Template for Java

//arr1,arr2 : the arrays
// n, m: size of arrays
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        
        ArrayList<Integer> arrList = new ArrayList<>();
        int i =0 ,j=0;
        
        while(i<n && j<m){ 
            
            // if element in arr1[] is smaller than in arr1[]
            if(arr1[i] < arr2[j]){
                if((arrList.size()>0) && (arrList.get(arrList.size()-1) != arr1[i])){
                    arrList.add(arr1[i]);
                }
                
                else if(arrList.size() == 0){
                    arrList.add(arr1[i]);
                }
                
                i++;  // increment i index 
                    
            }
               
            
            // if element in arr2[] is smaller than in arr1[]
            
            else if(arr2[j] < arr1[i]){
                if((arrList.size() >0) &&(arrList.get(arrList.size()-1) != arr2[j])){
                arrList.add(arr2[j]);
                }
                
                else if(arrList.size() == 0){
                    arrList.add(arr2[j]);
                }
               
                j++;  // increment j index 
            }
            
            
            
            // if elements in both the arrays are equal then you can pick element from any array
            
            else{
                if((arrList.size() >0) && (arrList.get(arrList.size()-1) != arr2[j])){
                    arrList.add(arr2[j]);
                }
                
                else if(arrList.size() ==0 ){
                    arrList.add(arr2[j]);
                    
                }
                j++; // increment both i and j index 
                i++;
            }
            
        }
        
        
        
        // to check if any other elements sre remaining in arr1[]
        
        while(i<n){
            if(arrList.get(arrList.size()-1) != arr1[i]){
                arrList.add(arr1[i]);
                
            }
            
            i++;
           
            // i++;
        }
        
        
        // to check if any other elements are remaining are elements are remaing in list arr1[]
        
        while(j<m){
            if(arrList.get(arrList.size()-1) != arr2[j]){
                arrList.add(arr2[j]);
                
            }
            j++;
            
            // j++;
            
        }
        
        
        return arrList;
    }
}



