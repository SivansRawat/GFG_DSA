class Solution {
    public ArrayList<Integer> rangeSumQueries(int[] arr, int[][] queries) {
        // code here
        
        int n = arr.length;
        
        ArrayList<Integer> result = new ArrayList<>();
       
        int[] pre = new int[n];
        pre[0] = arr[0];
        
        for(int i = 1 ; i< n ;i++){
            pre[i] = pre[i-1] + arr[i];
            
            
            
        }
        
        
        for(int i = 0 ;  i < queries.length ; i++){
            
            int l = queries[i][0];
            int r = queries[i][1];
            
            int res = 0;
            
            if(l ==0)  res = pre[r];
            
            if(l > 0){
                
            
             res = pre[r] - pre[l-1];
            
            }
            
            
            result.add(res);
            
            
            
        }
        
        
        return result;
            
            
            
            
            
        }
        
    
}