//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    public static int findMaxDistance(Map<Node, Node> mpp, Node target) {
        Queue<Node> q = new LinkedList<>();
        q.add(target);
        Map<Node, Integer> vis = new HashMap<>();
        vis.put(target, 1);
        int maxi = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            int fl = 0;
            for (int i = 0; i < sz; i++) {
                Node node = q.poll();
                if (node != null) {
                    if (node.left != null && !vis.containsKey(node.left)) {
                        fl = 1;
                        vis.put(node.left, 1);
                        q.add(node.left);
                    }
                    if (node.right != null && !vis.containsKey(node.right)) {
                        fl = 1;
                        vis.put(node.right, 1);
                        q.add(node.right);
                    }

                    if (mpp.containsKey(node) && !vis.containsKey(mpp.get(node))) {
                        fl = 1;
                        vis.put(mpp.get(node), 1);
                        q.add(mpp.get(node));
                    }
                }
            }
            if (fl == 1) maxi++;
        }
        return maxi;
    }

    public static Node bfsToMapParents(Node root, Map<Node, Node> mpp, int start) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node res = null;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node != null) {
                if (node.data == start) res = node;
                if (node.left != null) {
                    mpp.put(node.left, node);
                    q.add(node.left);
                }
                if (node.right != null) {
                    mpp.put(node.right, node);
                    q.add(node.right);
                }
            }
        }
        return res;
    }

    public static int minTime(Node root, int target) {
        Map<Node, Node> mpp = new HashMap<>();
        Node start = bfsToMapParents(root, mpp, target);
        int maxi = findMaxDistance(mpp, start);
        return maxi;
    }
}