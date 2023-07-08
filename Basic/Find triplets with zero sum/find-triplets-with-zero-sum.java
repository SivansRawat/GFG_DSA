//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        Arrays.sort(arr);
        boolean flag = false;

        // List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {

            if (i == 0 || (i > 0 && arr[i] != arr[i - 1])) {

                int lo = i + 1, hi = arr.length - 1, sum = 0 - arr[i];

                while (lo < hi) {
                    if (arr[lo] + arr[hi] == sum) {
                        return true;
                        // ArrayList < Integer > temp = new ArrayList < > ();
                        // temp.add(arr[i]);
                        // temp.add(arr[lo]);
                        // temp.add(arr[hi]);
                        // res.add(temp);

                        // while (lo < hi && arr[lo] == arr[lo + 1]) lo++;
                        // while (lo < hi && arr[hi] == arr[hi - 1]) hi--;

                        // lo++;
                        // hi--;
                    } else if (arr[lo] + arr[hi] < sum) lo++;

                    else hi--;
                }
            }
        }
        return false ;
    }
}