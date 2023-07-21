//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    // public static Node reverse(Node head, int k)
    // {
    //     //Your code here
        
        
        
    //     if (head == null || k <= 1) return head;

    //     Node current = head;
    //     Node next = null;
    //     Node prev = null;
    //     int count = 0;

    //     // Count the number of nodes in the current chunk
    //     while (current != null && count < k) {
    //         current = current.next;
    //         count++;
    //     }

    //     // If the current chunk has at least k nodes, reverse it
    //     if (count == k ) {
    //         current = head;
    //         for (int i = 0; i < k; i++) {
    //             next = current.next;
    //             current.next = prev;
    //             prev = current;
    //             current = next;
    //         }

    //         // Recursively reverse the remaining linked list
    //         if (next != null) {
    //             head.next = reverse(next, k);
    //         }

    //         // 'prev' is the new head of the reversed chunk
    //         return prev;
    //     } else {
    //         // If the current chunk has fewer than k nodes, return head as is
    //         return head;
    //     }
    // }
    
    
    
    public static Node reverse(Node head, int k){
        
    
    
        
    if(head == null||head.next == null) return head;
    
    int length = lengthOfLinkedList(head);
    
    Node dummyHead = new Node(0);
    dummyHead.next = head;
    
    Node pre = dummyHead;
    Node cur = dummyHead;
    Node nex = dummyHead;
    
    while(length >= k ) {
        cur = pre.next;
        nex = cur.next;
        for(int i=1;i<k;i++) {
            cur.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
            nex = cur.next;
        }
        pre = cur;
        length -= k;
    }
    
    
     if (length > 0) {
        cur = pre.next;
        nex = cur.next;
        for (int i = 1; i < length; i++) {
            cur.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
            nex = cur.next;
        }
    }

    return dummyHead.next;
    }
    
    static int lengthOfLinkedList(Node head) {
    int length = 0;
    while(head != null) {
        ++length;
        head = head.next;
    }
    return length;
}



}
