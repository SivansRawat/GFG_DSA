//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.ArrayList; 

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N=sc.nextInt();
            int Q=sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int [][]queries=new int[Q][2];
            for(int i=0;i<Q;i++){
                queries[i][0]=sc.nextInt();
                queries[i][1]=sc.nextInt();
            }
            
            Solution obj = new Solution();
            int ans[]= obj.maximumXor(N, Q, arr, queries);
            for(int i=0;i<ans.length;i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static class Node{
        Node zero, one;
        Node(){
            zero=null;
            one=null;
        }
    }
    
    public static void insert(int n, Node root){
        Node curr = root;
        for(int i=31; i>=0; i--){
            
            int bit = (n >> i) & 1;
            if(bit == 1){
                if(curr.one==null){
                    curr.one = new Node();
                }
                curr=curr.one;
            }else{
                if(curr.zero==null){
                    curr.zero = new Node();
                }
                curr=curr.zero;
            }
        }
    }
    
    //find max Xor
    public static int findMaxXor(int n, Node root){
        Node curr = root;
        int ans = 0;
        for(int i=31; i>=0; i--){
            
            int bit = (n >> i) & 1;
            if(bit == 1){
                if(curr.zero!=null){
                    ans += (1<<i);
                    curr=curr.zero;
                }else{
                    curr=curr.one;
                }
            }else{
                if(curr.one!=null){
                    ans += (1<<i);
                    curr=curr.one;
                }else{
                    curr=curr.zero;
                }
            }
        }
        return ans;
    }
    
    //array to list
    public static List<List<Integer>> arrayToList(int[][] arr) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                row.add(arr[i][j]);
            }
            list.add(row);
        }
        return list;
    }
    
    static int[] maximumXor(int N, int Q, int arr[],int queries[][]) {
        //code here
        int ans[] = new int[Q];
        
        //convert arr to list to save index even after sort
        //because we have to return ans in given order
       //we can also make new 2d array with q[len][3]
        List<List<Integer>> list = arrayToList(queries);
        for(int i=0; i<Q; i++){
            list.get(i).add(i);
        }
        
        //sort both
        Arrays.sort(arr);
        Collections.sort(list, Comparator.comparingInt(row -> row.get(1)));
        int lastadd = 0;
        
        Node root = new Node();
        
        for(int i=0; i<Q; i++){
            int max=0;
            while(lastadd<N && arr[lastadd] <=  list.get(i).get(1)  ){
                insert(arr[lastadd], root);
                lastadd++;
            }
            if(root.one==null && root.zero==null){
                ans[list.get(i).get(2)] = -1;
            }else{
               ans[list.get(i).get(2)] = findMaxXor(list.get(i).get(0), root);
            }
        }
        return ans;
    }
}