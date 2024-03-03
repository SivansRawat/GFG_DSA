//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/
class Solution {
    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node l1, Node l2) {
        l1 = reverse(l1); // Reverse the first linked list
        l2 = reverse(l2); // Reverse the second linked list
        
        Node dummy = new Node(0); // Dummy node to hold the result
        Node temp = dummy; // Pointer to traverse the result linked list
        int carry = 0; // Variable to store the carry
        
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Initialize sum with carry
            
            if (l1 != null) {
                sum += l1.data; // Add value of current node in l1 to sum
                l1 = l1.next; // Move to next node in l1
            }
            
            if (l2 != null) {
                sum += l2.data; // Add value of current node in l2 to sum
                l2 = l2.next; // Move to next node in l2
            }
            
            // Calculate sum and update carry
            temp.next = new Node(sum % 10); // Create new node with sum % 10
            temp = temp.next; // Move temp to newly added node
            carry = sum / 10; // Update carry for next iteration
        }
        
        // Reverse the result linked list to get the correct order
        Node result = reverse(dummy.next);
        
        return result; // Return the result
    }
    
    // Function to reverse a linked list
    static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}
