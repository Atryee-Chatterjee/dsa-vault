/*
Problem: Print Number in Words

Approach:
- Use recursion to process the number digit by digit
- Extract the last digit using number % 10
- Recursively process the remaining number using number / 10
- After recursion returns, print the word corresponding to the digit
- This prints the digits in their original order

Example:
Input: 12345
Output: one two three four five

Complexity:
Time: O(n)
Space: O(n) due to recursion stack

Key Idea:
- Recursion reverses the order in which digits are processed
- Printing after the recursive call restores the original order
*/
package Recursion;

public class PrintNumberInWords {
    static String digits[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public static void printDigits(int number) {
        if(number == 0){
            return;
        }

        int lastDigit = number % 10;
        printDigits(number/10);
        System.out.print(digits[lastDigit] + " ");
    }

    public static void main(String[] args) {
        printDigits(12345);
    }
}
