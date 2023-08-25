//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from post and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        
         if (in == null || post == null || in.length != 
        post.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i=0;i<in.length;++i)
            hm.put(in[i], i);
        return buildTreePostIn(in, 0, in.length-1, post, 0, 
                              post.length-1,hm);
    }

    private Node buildTreePostIn(int[] in, int is, int ie, int[] post,
    int ps, int pe,HashMap<Integer,Integer> hm){
        if (ps>pe || is>ie) return null;
        Node root = new Node(post[pe]);
        int ri = hm.get(post[pe]);
        Node leftchild = buildTreePostIn(in, is, ri-1, post, ps,
        ps+ri-is-1, hm);
        Node rightchild = buildTreePostIn(in,ri+1, ie, post, 
        ps+ri-is, pe-1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
}
