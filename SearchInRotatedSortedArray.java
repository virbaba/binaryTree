import java.util.ArrayList;
public class Solution {
    public static int searching(ArrayList<Integer> arr, int s, int e, int k){
        
        while(s <= e){
            int mid = s + (e-s)/2;
            if(arr.get(mid) == k)
                return mid;
            
            else if(arr.get(mid) < k){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }

        return -1;
    }
    public static int search(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.

        int pivot = -1;

      // firstly find the pivot element & then serach from start to pivot and then pivot to end

        int s = 0, e = n-1;
        while(s < e){
            int mid = s + (e-s)/2;
            if(arr.get(mid) >= arr.get(0)){
                s = mid + 1;
            }
            else{
               e = mid;
            }
        }
        pivot = s;
        s = 0;
        e = n - 1;
        System.out.println(pivot);
        int ind1 = searching(arr, s, pivot, k);
        int ind2 = searching(arr, pivot, e, k);

        if(ind1 != -1)
            return ind1;
        
        return ind2;
    }
}
