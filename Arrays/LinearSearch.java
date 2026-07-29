/*
Problem: Linear Search

Approach:
- Traverse the array one by one
- Compare each element with the key
- Return index if found, else return -1

Complexity:
Time: O(n)
Space: O(1)

Notes:
- Simple brute-force searching technique
- Works on unsorted arrays
 */
class LinearSearch {
    public static int linearSearch(int arr[], int key) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 6, 8, 3, 7 };

        int result = linearSearch(arr, 8);

        if (result == -1) {
            System.out.println("Key not found!");
        } else {
            System.out.println("Key found at index " + result);
        }

    }
}