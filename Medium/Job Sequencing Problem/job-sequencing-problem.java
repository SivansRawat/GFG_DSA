//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
       
        TreeSet <Integer> ts = new TreeSet<>();
        int profit = 0, count = 0;
        int [] rtn = new int [2];
         Arrays.sort(arr, new Sort());
        
        for(int i = 1;i <= n;i++ ){
            ts.add(i);
        }
        
        for(int i = 0;i<n;i++){
            int element = arr[i].deadline;
            if(ts.floor(element) != null){
                int num = ts.floor(element);
                ts.remove(num);
                profit+=arr[i].profit;
                count++;
            }
            
        }
        rtn[0] = count;
        rtn[1] = profit;
        
        return rtn;
        
    }
}

// Sort
class Sort implements Comparator <Job>{
    public int compare(Job j1, Job j2){
        int val1 = j2.profit - j1.profit;
        int val2 = j1.deadline - j2.deadline;
        if(val1 == 0){
            return val2;
        }
        else return val1;
    }
}

