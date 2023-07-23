//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node head,PrintWriter out)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
// class Solution
// {
    
    
    
    
//     static void insertAtTail(Node tail , Node curr){
        
//         tail.next = curr;
//         tail = curr;
//     }
    
//     //Function to sort a linked list of 0s, 1s and 2s.
//     static Node segregate(Node head)
//     {
//         // add your code here
        
//         Node zeroHead = new Node(-1);
//         Node zeroTail = zeroHead;
//         Node oneHead = new Node(-1);
//         Node oneTail =   oneHead; 
//         Node twoHead = new Node(-1);
//         Node twoTail = twoHead;
        
        
//         Node curr = head;
        
//         while(curr != null){
            
//             int value = curr.data;
            
//             if(value == 0) insertAtTail(zeroTail,curr);
            
//             else if(value ==1) insertAtTail(oneTail,curr);
            
//             else if(value ==2) insertAtTail(twoTail,curr);
            
//             curr = curr.next;
            
//         }
            
            
            
            
//         if(oneHead.next != null) zeroTail.next = oneHead.next;
            
            
//         else{
                
//                 zeroTail.next = twoHead.next;
//             }
            
            
            
//         oneTail.next = twoHead.next;
//         twoTail.next = null;
            
            
        
        
//         head = zeroHead.next;
        
        
        
        
//         return head;
//     }
// }


// class Solution {
//     static void insertAtTail(Node tail, Node curr) {
//         tail.next = curr;
//         tail = curr;
//     }

//     // Function to sort a linked list of 0s, 1s, and 2s.
//     static Node segregate(Node head) {
//         // Add your code here

//         Node zeroHead = new Node(-1);
//         Node zeroTail = zeroHead;
//         Node oneHead = new Node(-1);
//         Node oneTail = oneHead;
//         Node twoHead = new Node(-1);
//         Node twoTail = twoHead;

//         Node curr = head;

//         while (curr != null) {
//             int value = curr.data;

//             if (value == 0) insertAtTail(zeroTail, curr);
//             else if (value == 1) insertAtTail(oneTail, curr);
//             else if (value == 2) insertAtTail(twoTail, curr);

//             curr = curr.next;
//         }

//         if (oneHead.next != null) zeroTail.next = oneHead.next;
//         else {
//             zeroTail.next = twoHead.next;
//         }

//         oneTail.next = twoHead.next;
//         twoTail.next = null;

//         head = zeroHead.next;

//         return head;
//     }
// }



class Solution {
    static Node insertAtTail(Node tail, Node curr) {
        tail.next = curr;
        return tail.next;
    }

    static Node segregate(Node head) {
        Node zeroHead = new Node(-1);
        Node zeroTail = zeroHead;
        Node oneHead = new Node(-1);
        Node oneTail = oneHead;
        Node twoHead = new Node(-1);
        Node twoTail = twoHead;

        Node curr = head;

        // Create separate lists for 0s, 1s, and 2s
        while (curr != null) {
            int value = curr.data;
            if (value == 0) {
                zeroTail = insertAtTail(zeroTail, curr);
            } else if (value == 1) {
                oneTail = insertAtTail(oneTail, curr);
            } else if (value == 2) {
                twoTail = insertAtTail(twoTail, curr);
            }
            curr = curr.next;
        }

        // Merge the three sublists
        if (oneHead.next != null) {
            zeroTail.next = oneHead.next;
        } else {
            zeroTail.next = twoHead.next;
        }

        oneTail.next = twoHead.next;
        twoTail.next = null;

        // Setup head
        head = zeroHead.next;

        return head;
    }
}

