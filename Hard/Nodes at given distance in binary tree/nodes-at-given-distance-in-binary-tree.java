//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        Node key = findKey(root, target);
        HashMap<Node, Node> map = new HashMap<>();
        parentNode(root, map, target);
        return findKDist(map, new HashMap<>(), root, key, k);
    }
    
    private static void parentNode(Node root, HashMap<Node, Node> map, int target){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.left != null){
                map.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right != null){
                map.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }
    
    private static ArrayList<Integer> findKDist(HashMap<Node, Node> map, HashMap<Node, Boolean> map2, Node root, Node key, int k){
        Queue<Node> q = new LinkedList<>();
        q.offer(key);
        map2.put(key, true);
        int level = 0;
        while(!q.isEmpty()){
            if(level == k) break;
            level++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node curr = q.poll();
                if(curr.left != null && map2.get(curr.left) == null){
                    q.offer(curr.left);
                    map2.put(curr.left, true);
                }
                if(curr.right != null && map2.get(curr.right) == null){
                    q.offer(curr.right);
                    map2.put(curr.right, true);
                }
                if(map.get(curr) != null && map2.get(map.get(curr)) == null){
                    q.offer(map.get(curr));
                    map2.put(map.get(curr), true);
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().data);
        }
        Collections.sort(ans);
        return ans;
    }
    
    private static Node findKey(Node root, int target){
        if(root == null) return null;
        if(root.data == target) return root;
        Node left = findKey(root.left, target);
        Node right = findKey(root.right, target);
        if(right == null) return left;
        return right;
    }
};