package BitManipulation;

public class BitwiseOperators {

    public static void main(String[] args) {

        // Bitwise XOR (^)
        // Returns 1 when the corresponding bits are different
        System.out.println(5 ^ 6);

        // Bitwise AND (&)
        // Returns 1 when both corresponding bits are 1
        System.out.println(5 & 6);

        // Bitwise OR (|)
        // Returns 1 when at least one corresponding bit is 1
        System.out.println(5 | 6);

        // Bitwise NOT (~)
        // Inverts all bits (0 becomes 1 and 1 becomes 0)
        System.out.println(~0);

        // Left Shift (<<)
        // Shifts bits to the left by the given number of positions
        // Equivalent to multiplying by 2^n for suitable values
        System.out.println(5 << 2);

        // Right Shift (>>)
        // Shifts bits to the right while preserving the sign bit
        // Equivalent to dividing by 2^n for suitable values
        System.out.println(6 >> 1);
    }
}