/*
Problem: Pair Sum in a Sorted Rotated ArrayList

Approach:

- Find the breaking point where the sorted order is rotated
- The element after the breaking point becomes the left pointer
- The breaking point itself becomes the right pointer
- Use two pointers to find a pair whose sum equals the target
- If the sum is smaller than the target, move the left pointer forward
- If the sum is greater than the target, move the right pointer backward
- Use modulo (%) to make the pointers move circularly through the ArrayList
- Return true when a valid pair is found
- Return false if no valid pair exists

Complexity:

Time: O(n)
Space: O(1)

Key Idea:

- Find the rotation point to identify the smallest and largest elements
- Use circular two-pointer traversal to search for the target pair
- The modulo operation allows the pointers to wrap around the ArrayList
*/
package ArrayLists;
import java.util.ArrayList;

public class PairSumSortedRotated {
    public static boolean pairSum2(ArrayList<Integer> list, int target){
        int bp = -1;
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i) > list.get(i+1)){
                bp = i;
                break;
            }
        }
        int lp = bp+1;
        int rp = bp;
        int n = list.size();

        while (lp!=rp) {
            //Case 1
            if(list.get(lp) + list.get(rp) == target){
                return true;
            }
            //Case 2
            if(list.get(lp) + list.get(rp) < target){
                lp = (lp+1) % n;
            }else{
                rp = (n + rp-1) % n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 16;
        System.out.println(pairSum2(list, target));
    }
}
