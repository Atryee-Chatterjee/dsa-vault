/*
Problem: Activity Selection

Approach:
- Store each activity's index, start time, and end time in a 2D array
- Sort activities by their ending times in ascending order
- Select the first activity because it finishes earliest
- Traverse the remaining activities
- Select an activity if its start time is greater than or equal to the last selected activity's end time
- Update the lastEnd time after selecting an activity
- Store the selected activity indices and print the maximum count

Complexity:
Time: O(n log n)
Space: O(n)

Key Idea:
- Greedily select the activity that finishes earliest
- Choosing activities with earlier end times leaves more room for future activities
- Only non-overlapping activities can be selected
*/
package GreedyAlgorithms;

import java.util.*;

public class ActivitySelection {
    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        // Sorting
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        // Lamda function - shortform.
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // End time basis sorted
        int maxActivity = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // First activity
        maxActivity = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];

        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) { // disjoint / non-overlapping
                // Activity select
                maxActivity++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Max Acitvity " + maxActivity);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }

}
