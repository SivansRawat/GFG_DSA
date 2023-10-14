//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;
import java.math.*;

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

// } Driver Code Ends
//User function Template for Java


class Solution

{

    //Function to find the nodes that are common in both BST.

   //static HashMap<Integer,Integer>hm=new HashMap<>();

 public static ArrayList<Integer> findCommon(Node root1,Node root2)

    {

        //code here

        HashMap<Integer,Integer>hm=new HashMap<>();

        ArrayList<Integer>a=new ArrayList<>();

        tree1(root1,hm);

        tree2(root2,a,hm);

        return a;

    }

    static void tree1(Node root,HashMap<Integer,Integer>hm)

    {

        if(root==null)

        return;

        tree1(root.left,hm);

     //store every value in hashmap from bst1 

 hm.put(root.data,hm.getOrDefault(root.data,0)+1);

        tree1(root.right,hm);

    }

   static void tree2(Node root,ArrayList<Integer>a,HashMap<Integer,Integer>hm)

    {

        if(root==null)

        return;

        tree2(root.left,a,hm);

//Check values of bst2 matches with values in hashmap

 

        if(hm.containsKey(root.data))

        {

            a.add(root.data);

            hm.put(root.data,hm.getOrDefault(root.data,0)-1);

        }

        tree2(root.right,a,hm);

    }

}



//{ Driver Code Starts.
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
    
    public static void main(String args[]) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            Solution g = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = g.findCommon(root1,root2);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
            
            t--;
        }
    }
}
// } Driver Code Ends