/*
Problem: Print All Pairs in an Array

Approach:
- Use two loops
- Fix one element (i) and pair it with all next elements (j = i+1)
- Print each pair (arr[i], arr[j])
- Count total number of pairs

Complexity:
Time: O(n^2)
Space: O(1)

Notes:
- Each element is paired with every element after it
- Total pairs = n*(n-1)/2
 */

public class PairsInArray {
    public static void pairsInArray(int arr[]){
        int totalPairs = 0;

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
                totalPairs++;
            }
            System.out.println();
        }
        System.out.println("Total numbers of pairs = " + totalPairs);
    }
    public static void main(String[] args) {
        int arr[] = {1, 6, 8, 3, 7};
        pairsInArray(arr);
    }
}
