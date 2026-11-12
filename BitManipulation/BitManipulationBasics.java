package BitManipulation;

/*
 Problem: Perform basic bit manipulation operations on an integer

 Concepts:
 - Check Odd or Even
 - Get the ith Bit
 - Set the ith Bit
 - Clear the ith Bit
 - Update the ith Bit

 Note:
 - Bit indexing starts from 0 (rightmost bit)
 - Bitwise operations use binary representations of numbers
 */

public class BitManipulationBasics {

    // Check if a number is Odd or Even
    public static void oddOrEven(int n) {

        int bitMask = 1;

        // If the last bit is 0, the number is even
        // If the last bit is 1, the number is odd
        if ((n & bitMask) == 0) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }
    }

    // Get the ith Bit
    public static int getIthBit(int n, int i) {

        // Create a bit mask with only the ith bit set to 1
        int bitMask = 1 << i;

        // Perform AND to check whether the ith bit is 0 or 1
        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    // Set the ith Bit (set to 1)
    public static int setIthBit(int n, int i) {

        // Create a bit mask with only the ith bit set to 1
        int bitMask = 1 << i;

        // OR sets the ith bit to 1 without changing other bits
        return n | bitMask;
    }

    // Clear the ith Bit (set to 0)
    public static int clearIthBit(int n, int i) {

        // Create a bit mask with the ith bit set to 0
        int bitMask = ~(1 << i);

        // AND clears the ith bit without changing other bits
        return n & bitMask;
    }

    // Update the ith Bit
    public static int updateIthBit(int n, int i, int newBit) {

        // First, clear the ith bit
        n = clearIthBit(n, i);

        // Shift newBit to the ith position
        int bitMask = newBit << i;

        // OR updates the ith bit with the new value
        return n | bitMask;
    }

    public static void main(String[] args) {

        // oddOrEven(3);

        // Get the ith bit
        // System.out.println(getIthBit(10, 3));

        // Set the ith bit
        // System.out.println(setIthBit(10, 2));

        // Clear the ith bit
        // System.out.println(clearIthBit(15, 1));

        // Update the ith bit
        System.out.println(updateIthBit(10, 2, 1));
    }
}