//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
        int capacity=sc.nextInt();
        LFUCache obj = new LFUCache(capacity);
        int runs=sc.nextInt();
        for(int i = 0;i<runs;i++){
            int s=sc.nextInt();
            if(s==1){
                int key=sc.nextInt();
                int param_1 = obj.get(key);
                System.out.println(param_1);
            }else{
                int key=sc.nextInt(),value=sc.nextInt();
                obj.put(key,value);
            }
        }
    }
  }
}

// } Driver Code Ends


//User function Template for Java


class LFUCache {

    public Map<Integer, int[]> map = new LinkedHashMap<>();
    int capacity;

    public LFUCache(int cap) {
        capacity = cap;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int[] temp = map.get(key);
            temp[1]++;
            return temp[0];
        } else return -1;
    }

    public void put(int key, int value) 
    {
        if (capacity <= 0) 
        {
            return;
        }

        if (map.containsKey(key)) 
        {
            int[] temp = map.get(key);
            temp[0] = value;
            temp[1]++;
        }
        else 
        {
            if (map.size() >= capacity) 
                removeLeastFrequent();
            
            int[] temp = new int[2];
            temp[0] = value;
            temp[1] = 1;
            map.put(key, temp);
        }
    }

    private void removeLeastFrequent() {
        int minKey = -1;
        int minFrequency = Integer.MAX_VALUE;

        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int frequency = entry.getValue()[1];
            if (frequency < minFrequency) {
                minFrequency = frequency;
                minKey = entry.getKey();
            }
        }

        if (minKey != -1) {
            map.remove(minKey);
        }
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */