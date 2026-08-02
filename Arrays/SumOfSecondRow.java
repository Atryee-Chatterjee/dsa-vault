/*
Problem: Sum of Elements in the Second Row of a 2D Array

Approach:
- Initialize a variable sum = 0
- Traverse only the second row (index = 1)
  → Use a loop for all columns
  → Add each element of the second row to sum
- After traversal:
  → Print the total sum

Complexity:
Time: O(m)  (m = number of columns)
Space: O(1)

Notes:
- Assumes the array has at least 2 rows
- Directly accesses second row using index 1
- Efficient since only one row is traversed
*/
public class SumOfSecondRow {
    public static void sum(int nums[][]){
        int sum = 0;
        for(int j=0; j<nums[0].length; j++){
            sum += nums[1][j];
        }
        System.out.println("The sum of the numbers in second row = " + sum);
    }
    public static void main(String[] args) {
        int nums[][] =  {{1,4,9},{11,4,3},{2,2,3} };
        sum(nums);
    }
}
