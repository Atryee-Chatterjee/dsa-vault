/*
 Problem: Calculate a^n (power of a number) using recursion (optimized)

 Approach (Divide & Conquer):
 - Base case: if n == 0, return 1
 - Recursively calculate power(a, n/2)
 - Store it as halfPower
 - Square it → halfPower * halfPower
 - If n is odd, multiply one extra 'a'

 Complexity:
 - Time: O(log n)
 - Space: O(log n) (recursion stack)

 Note:
 - This is an optimized approach compared to normal recursion (O(n))
 - Uses the idea: a^n = (a^(n/2))^2
 - For odd n: a^n = a * (a^(n/2))^2
 */
package Recursion;

public class Power {
    // public static int power(int a, int n) { // Not optimized , Time complexity: O(n)
    //     if(n == 0){
    //         return 1;
    //     }
    //     return a * power(a, n-1);
    // }
    public static int power(int a, int n) {
        if (n == 0) {
            return 1;
        }
        int halfPower = power(a, n / 2);
        int halfPowerSq = halfPower * halfPower;

        if (n % 2 != 0) {
            halfPowerSq = a * halfPowerSq;
        }

        return halfPowerSq;
    }

    public static void main(String[] args) {
        int a = 2, n = 5;
        System.out.println(power(a, n));
    }
}
