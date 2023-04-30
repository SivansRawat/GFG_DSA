//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        
        // ArrayList<Integer> arrList = new ArrayList<Integer>();
        
        
        
        
        // for(int i =0;i<n;i++){
            
        //     arrList1.add(arr[i]);
        // }
        
        // // ArrayList<Integer> arrList1 = new ArrayList<Integer>();
        
        // // for(int i = 0 ; i<n ;i++){
            
        // //     arrList.add(arr[i]);
        // // }
        
        
        
        // // for(int i = 0 ;i<n;i++){
        // //     arrList.remove(Integer.valueOf(i));
            
        // // }
        
        
        
        // // if(arrList.isEmpty()){
        // //     arrList.add(-1);
            
        // // }
        
        
        
        // // HashMap<Integer,Integer> map = new HashMap<>();
        
        // // for(int i = 0 ; i<n ;i++){
        // //     map.put(arr[i], map.getOrDefault(arr[i],0)+1);

            
        // //     // if(map.get(arr[i]) ==2){
        // //     //     arrList.add(arr[i]);
        // //     // }
            
        // // }
        
        
        
        // // // for(int i=0;i<n;i++){
            
        // // //     if(map.get(arr[i]) ==2){
        // // //         arrList.add(arr[i]);
        // // //     }
        // // // }
        
        // // Iterator <Integer> it = map.keySet().iterator(); 
        // // while(it.hasNext())  {  
        // //     int key=it.next();
        // //     if(map.get(key) >1){
        // //         arrList.add(key);
        // // }
        // // }
        
        
        
        // HashSet<Integer> set = new HashSet<>();
        
        // for(int i=0;i<n;i++){
            
        //     set.add(arr[i]);
        // }
        
        
        // arrList.addAll(set);
        
        
        
        // int m = arrList.size();
        
        
        // for(int i=0;i<m;i++){
            
        //     arrList1.remove(arrList.get(i));
        // }
        
        // if (arrList1.isEmpty()) arrList1.add(-1);
        
        // // Collections.sort(arrList);   
        // return arrList1;
        
        
        ArrayList<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        // getting the frequency of each element
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        //finding out the numbers that have more than one frequency
        for(Map.Entry<Integer,Integer> m: map.entrySet()){
            if(m.getValue()>1) list.add(m.getKey());
        }
        //sorting and returning the list
        Collections.sort(list);
        if(list.size()==0){
            list.add(-1);
            return list;
        }
        else return list;
        
    }
}
