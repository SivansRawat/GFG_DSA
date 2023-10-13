//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class Node {
    int data;
    Node right;
    Node left;

    Node(int val) {
        data = val;
        right = null;
        left = null;
    }
}

class GFG {

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) {
            return new Node(val);
        }

        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }

        return tree;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            Node root = null;
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int k = sc.nextInt();
                root = insert(root, k);
            }

            int s = sc.nextInt();

            Solution obj = new Solution();
            int ans = obj.floor(root, s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int floor(Node root, int x) {
        // Code here
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        Collections.sort(list);
        if(list.get(0) > x) return -1;
        int len = list.size();
        for(int i=0; i<len; i++){
            int n = list.get(i);
            if(n == x){
                return n;
            }
            else if(i>0 && n>x) return list.get(i-1);
        }
        return list.get(len-1);
    }
    
    static void traverse(Node root,List<Integer> list){
        if(root == null) return;
        list.add(root.data);
        traverse(root.left, list);
        traverse(root.right, list);
    }
}