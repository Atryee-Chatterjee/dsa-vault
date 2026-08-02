/*
Problem: Count Number of 7’s in a 2D Array

Approach:
- Initialize a counter variable (count = 0)
- Traverse the entire 2D array using nested loops:
  → For each element:
      - Check if it is equal to 7
      - If yes → increment count
- After traversal:
  → Return the total count of 7’s

Complexity:
Time: O(n * m)  (n = rows, m = columns)
Space: O(1)

Notes:
- Simple traversal problem
- Works for any rectangular 2D array
- Can be generalized to count any target number
*/
public class Print7sIn2Darray {
    public static int printSevens(int arr[][]){
        int count =0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == 7){
                    count ++;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int arr[][] = { {4,7,8},{8,8,7} };

        System.out.println(printSevens(arr));
    }
}